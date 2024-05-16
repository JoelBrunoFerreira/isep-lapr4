#ifndef HEADER_H
#define HEADER_H
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <signal.h>
#include <dirent.h>
#include <time.h>
#define DIR_PATH "../../"
#define REPORT_NAME "report.csv"
#define CONFIG_FILE "../config_file.txt"
#define FILE_PREFIX "-candidate-data"
#define FILE_EXTENSION_TXT ".txt"
#define SIZE 100
#define READ 0
#define WRITE 1
typedef struct {
    int *buffer;
    int capacity;
    int writer;  
    int reader;  
    int count;  // Number of elements in the buffer
} circular_buffer;
typedef struct
{
    int number_of_children;
    int time_interval;
    int buffer_size;
    char input_dir[SIZE];
    char output_dir[SIZE];
} config_struct;
typedef struct
{
    int phone_number;
    char job_reference[SIZE];
    char email[SIZE];
    char name[SIZE];
} candidate_struct;
typedef struct
{
    int number_of_files;
    char candidate_name[SIZE];
    char job_reference[SIZE];
    char application[SIZE];
} report_struct;
//Parent functions:
void build_config(int argc, char *argv[], config_struct *config);
int create_child_process(int number_of_children, pid_t (*child_pids)[2]);
int create_pipes(int pipes[][2], int number_of_pipes);
void close_parent_pipes(int pipes[][2], int number_of_pipes, int read, int write);
void get_file_prefixes(const char *input_dir, circular_buffer *cb);
void create_report_file(config_struct *config);
void write_report(config_struct *config, report_struct *report);
//Circular Buffer functions:
circular_buffer *init_buffer();
int is_empty(circular_buffer *cb);
int is_full(circular_buffer *cb);
void enqueue(circular_buffer *cb, int number);
int dequeue(circular_buffer *cb);
void free_buffer(circular_buffer *cb);
void display_buffer(circular_buffer *cb);
//Child_1 functions:
void monitor_input_dir(const char *input_dir);
//Cild_2, ..., Child_n functions:
void move_files(config_struct *config, report_struct *report,int file_number);
#endif