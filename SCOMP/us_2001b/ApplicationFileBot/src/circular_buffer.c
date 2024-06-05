#include "header.h"

// Function to initialize the circular buffer
circular_buffer *init_buffer(config_struct *config)
{
    circular_buffer *cb = (circular_buffer *)malloc(sizeof(circular_buffer));
    if (cb != NULL)
    {
        cb->buffer = (int *)malloc(config->buffer_size * sizeof(int));
        if (cb->buffer != NULL)
        {
            cb->capacity = config->buffer_size;
            cb->reader = 0;
            cb->writer = 0;
            cb->count = 0;
            return cb;
        }
        free(cb->buffer);
    }
    free(cb);
    return NULL;
}

// Function to check if the circular buffer is empty
int is_empty(circular_buffer *cb)
{
    return (cb->count == 0);
}

// Function to check if the circular buffer is full
int is_full(circular_buffer *cb)
{
    return (cb->count == cb->capacity);
}

// Function to enqueue an element into the circular buffer without repeated elements
void enqueue(circular_buffer *cb, int number)
{
    if (is_full(cb))
    {
        printf("Buffer is full!\n");
        return;
    }
    int i = cb->reader;
    int count = cb->count;
    while (count > 0)
    {
        if (cb->buffer[i] == number)
        {
            return;
        }
        i = (i + 1) % cb->capacity;
        count--;
    }
    cb->buffer[cb->writer] = number;
    cb->writer = (cb->writer + 1) % cb->capacity;
    cb->count++;
}

// Function to dequeue an element from the circular buffer
int dequeue(circular_buffer *cb)
{
    if (is_empty(cb))
    {
        printf("Buffer is empty!\n");
        return -1;
    }
    int data = cb->buffer[cb->reader];
    cb->reader = (cb->reader + 1) % cb->capacity;
    cb->count--;
    return data;
}

// Function to free memory allocated for the circular buffer
void free_buffer(circular_buffer *cb)
{
    free(cb->buffer);
    free(cb);
}

void display_buffer(circular_buffer *cb)
{
    printf("Buffer elements: ");
    int i = cb->reader;
    int count = 0;
    while (count < cb->count)
    {
        printf("%d ", cb->buffer[i]);
        i = (i + 1) % cb->capacity;
        count++;
    }
    printf("\n");
}
