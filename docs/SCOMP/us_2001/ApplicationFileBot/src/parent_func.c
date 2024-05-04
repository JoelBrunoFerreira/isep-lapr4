#include "header.h"
/*
        parent:             child_2:
        pipes[2][WRITE] --> pipes[2][READ]
        pipes[3][READ] <-- pipes[3][WRITE]
        parent:             child_3:
        pipes[4][WRITE] --> pipes[4][READ]
        pipes[5][READ] <-- pipes[5][WRITE]
        ...
*/

// Closes all pipes that are not going to be used by the father process
void close_parent_pipes(int pipes[][2], int number_of_pipes, int read, int write)
{
    // close all pipes for child 1
    close(pipes[0][read]);
    close(pipes[0][write]);
    close(pipes[1][read]);
    close(pipes[1][write]);
    for (int i = 2; i < number_of_pipes; ++i)
    {
        if (i % 2 == 0)
        {
            close(pipes[i][read]); // Close read end
        }
        else
        {
            close(pipes[i][write]); // Close write end
        }
    }
}

void get_file_prefixes(const char *input_dir, circular_buffer *cb)
{

    int num;
    DIR *dir;
    struct dirent *entry;

    // Open the directory
    dir = opendir(input_dir);
    if (dir == NULL)
    {
        perror("Unable to open directory");
        exit(EXIT_FAILURE);
    }

    // Iterate through directory entries
    while (((entry = readdir(dir)) != NULL) && (!is_full(cb)))
    {
        // Check if the entry is a regular file
        if (sscanf(entry->d_name, "%d", &num) == 1)
        {
            enqueue(cb, num);
        }
    }

    // Close the directory
    closedir(dir);
}
void create_report_file(config_struct *config)
{
    char file_path[SIZE];
    strcpy(file_path, config->output_dir);
    strcat(file_path, "/");
    strcat(file_path, REPORT_NAME);
    printf("File path: %s\n", file_path);
    pid_t pid = fork();
    if (pid == -1)
    {
        perror("fork failed!\n");
        exit(EXIT_FAILURE);
    }
    if (pid == 0)
    {
        execlp("touch", "touch", file_path, NULL);
        perror("execlp failed!\n");
        exit(EXIT_FAILURE);
    }
    else
    {
        waitpid(pid, NULL, 0);
        FILE *file = fopen(file_path, "a");
        if (file == NULL)
        {
            perror("fopen failed!\n");
            exit(EXIT_FAILURE);
        }
        fprintf(file, "Candidate;Job_Reference;Number_Files;Timestamp;\n");
        fclose(file);
    }
}
void write_report(config_struct *config, report_struct *report)
{
    char file_path[SIZE];
    strcpy(file_path, config->output_dir);
    strcat(file_path, "/");
    strcat(file_path, REPORT_NAME);
    printf("File path: %s\n", file_path);
    FILE *fp;
    // Open the file for writing
    fp = fopen(file_path, "a");
    if (fp == NULL)
    {
        perror("Error opening file!\n");
        exit(EXIT_FAILURE);
    }
    // Get the current date and time
    time_t rawtime;
    struct tm *timeinfo;
    char datetime_str[20]; // Format: YYYYMMDDHHMMSS
    time(&rawtime);
    timeinfo = localtime(&rawtime);
    strftime(datetime_str, sizeof(datetime_str), "%Y%m%d%H%M%S",timeinfo);
    printf("Date and time: %s\n", datetime_str);
    // Write the report details to the file
    fprintf(fp, "%s;%s;%d;%s;\n", report->application, report->job_reference, report->number_of_files, datetime_str);
    // Close the file
    fclose(fp);
}