#include "header.h"
//gets the candidate info from the candidate data file with the given file_prefix
void get_candidate_files_info(config_struct *config, candidate_struct *candidate, int file_number)
{
    char file_to_find[SIZE];
    sprintf(file_to_find, "%d-candidate-data.txt", file_number);
    printf("File to find: %s\n", file_to_find); // testing purposes

    DIR *dir = opendir(config->input_dir);
    if (!dir)
    {
        perror("opendir failed");
        exit(EXIT_FAILURE);
    }

    struct dirent *entry;
    char file_path[SIZE];
    int file_found = 0;

    while ((entry = readdir(dir)) != NULL)
    {
        if (entry->d_type == DT_REG)
        {
            if (strcmp(entry->d_name, file_to_find) == 0)
            {
                strcpy(file_path, config->input_dir);
                strcat(file_path, "/");
                strcat(file_path, entry->d_name);
                printf("File name: %s\n", file_path); // testing purposes
                file_found = 1;
                break;
            }
        }
    }

    closedir(dir);

    if (!file_found)
    {
        perror("file not found.\n");
        exit(EXIT_FAILURE);
    }

    FILE *file = fopen(file_path, "r");
    if (!file)
    {
        perror("file open failed.\n");
        exit(EXIT_FAILURE);
    }

    char line[SIZE];
    fgets(line, sizeof(line), file);
    sscanf(line, "%s", candidate->job_reference);
    // printf("Job reference: %s\n", candidate->job_reference);
    fgets(line, sizeof(line), file);
    sscanf(line, "%s", candidate->email);
    // printf("Email: %s\n", candidate->email);
    fgets(line, sizeof(line), file);
    sscanf(line, "%s", candidate->name);
    // printf("Name: %s\n", candidate->name);
    fgets(line, sizeof(line), file);
    sscanf(line, "%d", &candidate->phone_number);
    // printf("Phone number: %d\n", candidate->phone_number);
    fclose(file);
}
// move files from input dir into output dir, job subfolder, application subfolder (CHILD_2...n)
void move_files(config_struct *config, report_struct *report, int file_number)
{
    candidate_struct candidate;
    printf("READING CANDIDATE FILES...\n");
    get_candidate_files_info(config, &candidate, file_number); //get candidate info from file, to create directories
    printf("CANDIDATE FILES READ\n");
    char file_names[SIZE];
    pid_t pid;
    int file_counter = 0;
    DIR *dir = opendir(config->input_dir);
    if (dir == NULL)
    {
        perror("No directory found!\n");
        exit(EXIT_FAILURE);
    }

    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL)
    {
        // Check if the entry is a regular file and has the specified file extension
        if (entry->d_type == DT_REG && strstr(entry->d_name, FILE_EXTENSION_TXT) != NULL)
        {
            // Check if the file starts with the specified file_number
            int num;
            if (sscanf(entry->d_name, "%d", &num) == 1 && num == file_number)
            {
                strcpy(file_names, entry->d_name);
                file_counter++;
                // Construct the full source path
                char source_path[SIZE];
                strcpy(source_path, config->input_dir);
                strcat(source_path, "/");
                strcat(source_path, entry->d_name);

                // Construct the job_reference directory
                char job_sub_dir[SIZE];
                strcpy(job_sub_dir, config->output_dir);
                strcat(job_sub_dir, "/");
                strcat(job_sub_dir, candidate.job_reference);

                // Construct the application_subfolder path
                char application_sub_dir[SIZE];
                strcpy(application_sub_dir, job_sub_dir);
                strcat(application_sub_dir, "/");
                strcat(application_sub_dir, candidate.email);

                // Construct the full destination path, file.txt
                char dest_path[SIZE];
                strcpy(dest_path, application_sub_dir);
                strcat(dest_path, "/");
                strcat(dest_path, entry->d_name);

                // Create job sub folder and application sub folder
                if (file_counter == 1)
                {
                    if ((pid = fork()) == -1)
                    {
                        perror("fork failed!\n");
                        exit(EXIT_FAILURE);
                    }
                    else if (pid == 0)
                    {
                        execlp("mkdir", "mkdir", "-p", job_sub_dir, NULL);
                        perror("mkdir job_reference failed!\n");
                        exit(EXIT_FAILURE);
                    }
                    wait(NULL);

                    if ((pid = fork()) == -1)
                    {
                        perror("fork failed!\n");
                        exit(EXIT_FAILURE);
                    }
                    else if (pid == 0)
                    {
                        execlp("mkdir", "mkdir", "-p", application_sub_dir, NULL);
                        perror("mkdir application_subfolder failed!\n");
                        exit(EXIT_FAILURE);
                    }
                    wait(NULL);
                }

                // Move the file to the destination directory
                pid = fork();
                if (pid == 0)
                {
                    execlp("mv", "mv", source_path, dest_path, NULL);
                    perror("mv file to destination path failed!\n");
                    exit(EXIT_FAILURE);
                }
                wait(NULL);
            }
        }
    }
    strcpy(report->job_reference, candidate.job_reference);
    strcpy(report->application, candidate.email);
    report->number_of_files = file_counter;

    if (closedir(dir) == -1)
    {
        perror("closedir");
        exit(EXIT_FAILURE);
    }
}