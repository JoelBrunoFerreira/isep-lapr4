#include "header.h"

volatile sig_atomic_t kill_flag = 0;
volatile sig_atomic_t action_flag = 0;

// Signal handler func
void sig_handler(int signum, siginfo_t *info, void *context)
{
    switch (signum)
    {
    case SIGUSR1:
        write(STDOUT_FILENO, "New file signal caught!\n", 24);
        action_flag = 1;
        break;
    case SIGALRM:
        write(STDOUT_FILENO, "Alarm triggered!\n", 17);
        break;
    case SIGINT:
        write(STDOUT_FILENO, "SIGINT caught, goodbye world!\n", 30);
        kill_flag = 1;
        break;
    default:
        break;
    }
}


int main(int argc, char *argv[])
{
    config_struct config;
    build_config(argc, argv, &config);

    // Signal structure:
    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = sig_handler;
    act.sa_flags = SA_SIGINFO;

    report_struct report;
    pid_t child_pids[config.number_of_children][2];
    int i, child_process_num, file_prefix_num, number_of_pipes = (config.number_of_children * 2);
    int pipes[number_of_pipes][2];

    // Create pipes:
   if (create_pipes(pipes, number_of_pipes)== -1)
   {
        perror("Pipe creation failed!\n");
        exit(EXIT_FAILURE);
   }
    

    // Create child processes:
    child_process_num = create_child_process(config.number_of_children, child_pids);

    if (child_process_num == -1)
    {
        perror("Child process creation failed!\n");
        exit(EXIT_FAILURE);
    }
    else if (child_process_num > 0)
    {
        // Child_1:
        if (child_process_num == 1)
        {
            // Close all pipes with father:
            close(pipes[0][WRITE]);
            close(pipes[0][READ]);
            close(pipes[1][WRITE]);
            close(pipes[1][READ]);

            // Monitor input directory for new files indefinitely:
            sigaction(SIGALRM, &act, NULL);

            while (1)
            {
                alarm(config.time_interval);
                pause();
                monitor_input_dir(config.input_dir);
            }
        }
        else
        {
            close(pipes[(child_process_num - 1) * 2][WRITE]); // parent: pipe[2][WRITE]    -->     child2: pipe[2][READ]
            close(pipes[(child_process_num * 2) - 1][READ]);  // parent: pipe[3][READ]     <--     child2: pipe[3][WRITE]

            while (1)
            {
                read(pipes[(child_process_num - 1) * 2][READ], &file_prefix_num, sizeof(int));
                // while (read(pipes[(child_process_num - 1) * 2][READ], &file_prefix_num, sizeof(int)) == 0);

                printf("READ FILE NUMBER: %d\n", file_prefix_num);

                move_files(&config, &report, file_prefix_num);

                write(pipes[(child_process_num * 2) - 1][WRITE], &report, sizeof(report_struct));
            }
            close(pipes[(child_process_num * 2) - 1][WRITE]);
            close(pipes[(child_process_num - 1) * 2][READ]);
        }
    }
    else
    {
        sigaction(SIGUSR1, &act, NULL);
        sigaction(SIGINT, &act, NULL);
        create_report_file(&config);
        close_parent_pipes(pipes, number_of_pipes, READ, WRITE);

        while (1)
        {
            pause();

            if (kill_flag == 1)
            {
                close_parent_pipes(pipes, number_of_pipes, WRITE, READ);
                for (i = 0; i < config.number_of_children; i++)
                {
                    printf("Killing child(%d)\n", child_pids[i][0]);
                    kill(child_pids[i][0], SIGKILL);
                }
                exit(EXIT_SUCCESS);
            }
            else if (action_flag == 1)
            {

                circular_buffer *cb = init_buffer(&config);
                // fill buffer with unique file prefix numbers
                get_file_prefixes(config.input_dir, cb);

                display_buffer(cb);
                int child_count = config.number_of_children;
                while (cb->count > 0)
                {
                    if (child_count <= 0)
                    {
                        for (i = 1; i < config.number_of_children; i++)
                        {
                            if (child_pids[i][1] == 1)
                            {
                                child_pids[i][1] = 0;
                                child_count++;
                                read(pipes[((i + 1) * 2) - 1][READ], &report, sizeof(report_struct));
                                write_report(&config, &report);
                                break;
                            }
                        }
                    }

                    int num = dequeue(cb);

                    printf("\n");
                    for (i = 1; i < config.number_of_children; i++) // i = child number, start at 1 because child 1 (i=0)  is monitor
                    {
                        if (child_pids[i][1] == 0)
                        {
                            child_count--;
                            write(pipes[((i + 1) - 1) * 2][WRITE], &num, sizeof(int));
                            child_pids[i][1] = 1;
                            break;
                        }
                    }
                }
                for (i = 1; i < config.number_of_children; i++)
                {
                    if (child_pids[i][1] == 1)
                    {
                        child_pids[i][1] = 0;
                        read(pipes[((i + 1) * 2) - 1][READ], &report, sizeof(report_struct));
                        write_report(&config, &report);
                    }
                }
                free_buffer(cb);
            }
            action_flag = 0;
        }
    }
    return 0;
}