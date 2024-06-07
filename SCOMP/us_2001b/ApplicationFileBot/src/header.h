#ifndef HEADER_H
#define HEADER_H
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <errno.h>
#include <dirent.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <semaphore.h>
#include <sys/mman.h>
#include <time.h>
#define DIR_PATH "../../"
#define REPORT_NAME "report.csv"
#define CONFIG_FILE "../config_file.txt"
#define FILE_EXTENSION_TXT ".txt"
#define SEM_MONITOR_CHILD "/sem_monitor_child"
#define SEM_PARENT_READY_TO_READ "/sem_parent_ready_to_read"
#define SEM_CHILD_WORK_START "/sem_child_work_start"
#define SEM_CHILD_WORK_DONE "/sem_child_work_done"
#define SHM_AREA "/shm_area"
#define SEM_TIMER "/sem_timer"
#define SEM_PARENT_MONITOR_READY "/sem_parent_monitor_ready"
#define SIZE 256
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
    int file_prefix;
    int number_of_files;
    char candidate_name[SIZE];
    char job_reference[SIZE];
    char application[SIZE];
} report_struct;

//Parent functions:
void build_config(int argc, char *argv[], config_struct *config);
int create_child_process(int number_of_children, pid_t *child_pids);
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
int monitor_input_dir(const char *input_dir);
//Cild_2, ..., Child_n functions:
void move_files(config_struct *config, report_struct *report,int file_number);
#endif