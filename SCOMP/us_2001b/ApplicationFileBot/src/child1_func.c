#include "header.h"

// Monitores input directory for new files indefinitely (CHILD_1)
int monitor_input_dir(const char *input_dir)
{
    DIR *dir = opendir(input_dir);
    if (dir == NULL)
    {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    struct dirent *entry;
    int found = 0; //find 1 file

    while (((entry = readdir(dir)) != NULL) && !found)
    {
        if (strstr(entry->d_name, FILE_EXTENSION_TXT) != NULL)
        {
            found = 1;
        }
    }

    if (closedir(dir) == -1)
    {
        perror("closedir");
        exit(EXIT_FAILURE);
    }
    return found;
}
