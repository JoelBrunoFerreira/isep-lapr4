#include "header.h"
// read config file if parameters werent not given (FATHER)
void read_config_file(config_struct *config)
{
    FILE *file;
    char line[SIZE];

    // Open the config file for reading
    file = fopen(CONFIG_FILE, "r");
    if (file == NULL)
    {
        perror("Configuration file open failed!\n");
        exit(EXIT_FAILURE);
    }

    while (fgets(line, sizeof(line), file))
    {  
        // For each "line" extract the variable name and value (prints for testing purposes)
        char var_name[SIZE], value[SIZE];
        if (sscanf(line, "%[^:]: %[^\n]", var_name, value) == 2)
        {
            if (strcmp(var_name, "Input directory") == 0)
            {
                char aux[SIZE];
                strcpy(aux, DIR_PATH);
                strcat(aux, value);
                strncpy(config->input_dir, aux, SIZE);
                //printf("Input directory: %s\n", config->input_dir); //testing purposes
            }
            else if (strcmp(var_name, "Output directory") == 0)
            {
                char aux[SIZE];
                strcpy(aux, DIR_PATH);
                strcat(aux, value);
                strncpy(config->output_dir, aux, SIZE);
                //printf("Output directory: %s\n", config->output_dir); //testing purposes
            }
            else if (strcmp(var_name, "Number of children") == 0)
            {
                int result = atoi(value);
                if (result < 2)
                {
                    perror("Number of children must be greater than 1!\n");
                    exit(EXIT_FAILURE);
                    
                }
                   config->number_of_children = result;
                // printf("Number of children: %d\n", config->number_of_children); //testing purposes
                
                
            }
            else if (strcmp(var_name, "Time interval") == 0)
            {
                int result = atoi(value);
                if (result <= 0)
                {
                    perror("Time interval must be positive!\n");
                    exit(EXIT_FAILURE);
                }
                config->time_interval = result;
                // printf("Time interval: %d\n", config->time_interval); //testing purposes
            }
            else if (strcmp(var_name, "Buffer size") == 0)
            {
                int result = atoi(value);
                if (result <= 0)
                {
                    perror("Buffer must be graeter than zero!\n");
                    exit(EXIT_FAILURE);
                }
                config->buffer_size =result;
                // printf("Time interval: %d\n", config->time_interval); //testing purposes
            }
        }
    }

    // Close config file
    fclose(file);
}
//Build configuration structure with parameters given in command line or by config file (FATHER)
void build_config(int argc, char *argv[], config_struct *config)
{
    switch (argc)
    {
    case 1:
        read_config_file(config); //case parameters not given, use config file
        break;
    case 6:
        char input_dir_path[SIZE];
        strcpy(input_dir_path, DIR_PATH);
        strcat(input_dir_path, argv[1]);
        strcpy(config->input_dir, input_dir_path);
        char output_dir_path[SIZE];
        strcpy(output_dir_path, DIR_PATH);
        strcat(output_dir_path, argv[2]);
        strcpy(config->output_dir, output_dir_path);
        if ((atoi(argv[3]) < 2) || (atoi(argv[4])<=0) || (atoi(argv[5])<=0))
        {
            perror("Wrong values for child processes | time interval | buffer size!\n");
            exit(EXIT_FAILURE);
        }
        else{
            config->number_of_children = atoi(argv[3]);
            config->time_interval = atoi(argv[4]);
            config->buffer_size = atoi(argv[5]);
        }
        break;
    default:
        perror("Invalid number of arguments!\n");
        exit(EXIT_FAILURE);
    }
}

// creates number_of_children child processes
int create_child_process(int number_of_children, pid_t *child_pids)
{
    int i;
    pid_t pid;
    for (i = 0; i < number_of_children; i++)
    {
        pid = fork();
        if (pid < 0)
        {
            return -1;
        }
        else if (pid == 0)
        {
            return i + 1;
        }
        else
        {
            child_pids[i] = pid;
        }
    }
    return 0;
}