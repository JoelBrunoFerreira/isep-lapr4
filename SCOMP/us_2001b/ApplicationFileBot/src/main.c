#include "header.h"

volatile sig_atomic_t kill_flag = 0;

// Signal handler func
void sig_handler(int signum, siginfo_t *info, void *context)
{
	switch (signum)
	{
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

	report_struct *shm_report; //structure to be shared with children
	pid_t child_pids[config.number_of_children]; //array of child process ids for future killing
	int fd, i, child_process_num, file_prefix_num;
	
	// Create SHM area
	if ((fd = shm_open(SHM_AREA, O_CREAT | O_EXCL | O_RDWR, S_IRUSR | S_IWUSR)) == -1)
	{
		perror("shmopen");
		exit(EXIT_FAILURE);
	}

	//define size of shm 
	if (ftruncate(fd, sizeof(report_struct)) == -1)
	{
		perror("ftruncate");
		exit(EXIT_FAILURE);
	}

	//Map shm into address space
	if ((shm_report = (report_struct *)mmap(0, sizeof(report_struct), PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0)) == MAP_FAILED)
	{
		perror("mmap");
		exit(EXIT_FAILURE);
	}

	// Create semaphores
	sem_t *sem_monitor_child //sem used between father process and child_1 process to wait for new files
	, *sem_child_work_start //sem used between parent process and child_2...n processes to notify them of new work
	, *sem_child_work_done // sem used between child_2...n processes and parent to notify they are done
	, *sem_parent_ready_to_read // sem between parent and child_2...n processes to notify them of "w" access
	, *sem_parent_monitor_ready; //sem used between parent process and child_1 to see if all files were processed

	if ((sem_parent_monitor_ready = sem_open(SEM_PARENT_MONITOR_READY, O_CREAT | O_EXCL, 0644, 1)) == SEM_FAILED 
	|| (sem_monitor_child = sem_open(SEM_MONITOR_CHILD, O_CREAT | O_EXCL, 0644, 0)) == SEM_FAILED 
	|| (sem_child_work_start = sem_open(SEM_CHILD_WORK_START, O_CREAT | O_EXCL, 0644, 0)) == SEM_FAILED 
	|| (sem_child_work_done = sem_open(SEM_CHILD_WORK_DONE, O_CREAT | O_EXCL, 0644, 0)) == SEM_FAILED 
	|| (sem_parent_ready_to_read = sem_open(SEM_PARENT_READY_TO_READ, O_CREAT | O_EXCL, 0644, 1)) == SEM_FAILED)
	{
		perror("sem_open failed.\n");
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
		// Child_1 aka monitor process:
		if (child_process_num == 1)
		{

			sem_t *sem_timer; //sem used to wait for timer, always 0
			 
			if((sem_timer = sem_open(SEM_TIMER, O_CREAT | O_EXCL, 0644, 0)) == SEM_FAILED){
				perror("sem_open failed.\n");
				exit(EXIT_FAILURE);
			}

			struct timespec ts;

			while (1)
			{
				if (clock_gettime(CLOCK_REALTIME, &ts) == -1)
				{
					perror("clock_gettime\n");
					exit(EXIT_FAILURE);
				}

				ts.tv_sec += config.time_interval;

				sem_timedwait(sem_timer, &ts); // wait for timer
				printf("Child(%d) MONITORED...\n", getpid());//testing purposes

				if (monitor_input_dir(config.input_dir)) // 1 if new files found
				{
					if (sem_trywait(sem_parent_monitor_ready) == 0) //check if father available
					{
						sem_post(sem_monitor_child); // notify father of new files
					}
				}
			}
		}
		else //child_2...n processes:
		{
			while (1)
			{
				printf("Child(%d) waiting for work\n", getpid());//testing purposes
				sem_wait(sem_child_work_start); //wait for parent to give work (write file_prefix to shared memory)
				file_prefix_num = shm_report->file_prefix; //gets the file_prefix from shared memory
				printf("Child(%d) got file file_prefix number: %d\n", getpid(), file_prefix_num);//testing purposes
				sem_wait(sem_parent_ready_to_read);//wait for "w" access to shared memory
				move_files(&config, shm_report, file_prefix_num); //moves files and writes to shared memory
				printf("Child(%d) finished working\n", getpid());//testing purposes
				sem_post(sem_child_work_done); // tells parent "ok" to read next report
			}
		}
	}
	else
	{
		sigaction(SIGINT, &act, NULL);
		create_report_file(&config); //creates the file with the report info
		circular_buffer *cb = init_buffer(&config); // buffer used to save file prefixes that are to be distributed to children
	
		//int child_count = config.number_of_children; //if concurrency is needed		
		while (!kill_flag)
		{
			sem_wait(sem_monitor_child); // wait for new files from child_1 aka monitor process

			get_file_prefixes(config.input_dir, cb); // fill buffer with unique file file_prefix numbers

			display_buffer(cb); //testing purposes

			while (!is_empty(cb))
			{
				printf("Buffer count: %d\n", cb->count); //testing purposes
				shm_report->file_prefix = dequeue(cb); //write to shm the file_prefix to be used by child_2...n processes
				sem_post(sem_child_work_start); // notify children of new work
				sem_wait(sem_child_work_done); // get notification that child has finished work
				// read from SHM & make report file
				printf("P: wrote report!\n"); //testing purposes
				write_report(&config, shm_report);//write to file the report info
				sem_post(sem_parent_ready_to_read); // notify child that parent is ready to read another report
			}

			sem_post(sem_parent_monitor_ready); //notify child_1 that all files were processed, available for new files
		}
		for (i = 0; i < config.number_of_children; i++)
		{
			printf("Killing child(%d)\n", child_pids[i]);
			kill(child_pids[i], SIGKILL);
		}
		munmap(shm_report, sizeof(shm_report));
		shm_unlink(SHM_AREA);
		sem_close(sem_monitor_child);
		sem_unlink(SEM_MONITOR_CHILD);
		sem_close(sem_child_work_start);
		sem_unlink(SEM_CHILD_WORK_START);
		sem_close(sem_child_work_done);
		sem_unlink(SEM_CHILD_WORK_DONE);
		sem_close(sem_parent_ready_to_read);
		sem_unlink(SEM_PARENT_READY_TO_READ);
		sem_unlink(SEM_TIMER);
		sem_close(sem_parent_monitor_ready);
		sem_unlink(SEM_PARENT_MONITOR_READY);
		free_buffer(cb);
		printf("CLEANUP done!\n"); //testing purposes
		exit(EXIT_SUCCESS);
	}
}