#include "header.h"

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
void create_report_file(config_struct *config) {
    char file_path[SIZE];
    strcpy(file_path, config->output_dir);
    strcat(file_path, "/");
    strcat(file_path, REPORT_NAME);
    //printf("File path: %s\n", file_path);

    FILE *file = fopen(file_path, "a");
    if (file == NULL) {
        perror("fopen failed!\n");
        exit(EXIT_FAILURE);
    }

    fprintf(file, "Candidate;Job_Reference;Number_Files;Timestamp;\n");
    fclose(file);
}

void write_report(config_struct *config, report_struct *report)
{
    char file_path[SIZE];
    strcpy(file_path, config->output_dir);
    strcat(file_path, "/");
    strcat(file_path, REPORT_NAME);
    //printf("File path: %s\n", file_path);
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
    //printf("Date and time: %s\n", datetime_str);
    // Write the report details to the file
    fprintf(fp, "%s;%s;%d;%s;\n", report->application, report->job_reference, report->number_of_files, datetime_str);
    // Close the file
    fclose(fp);
}