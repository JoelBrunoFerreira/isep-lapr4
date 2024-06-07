# A Makefile with variables and suffix rules

# variables
INCLUDES = header.h
SOURCES = main.c utils.c  child1_func.c circular_buffer.c parent_func.c  child2_func.c
OBJFILES = main.o utils.o  child1_func.o circular_buffer.o parent_func.o  child2_func.o
EXEC = ApplicationFileBot

# Suffix rules
.SUFFIXES : .c .o

# How to build an object .c from a code file .o ; $< -- file name
.c.o:
	gcc -g -Wall -Wextra -lpthread -lrt -fanalyzer -c $<
	

#build main program
${EXEC}: ${OBJFILES}
	gcc ${OBJFILES} -z noexecstack -o ${EXEC}

${OBJFILES}: ${SOURCES} ${INCLUDES}


#exec main program
run: ${EXEC}
	./${EXEC}


clean:
	rm -f ${OBJFILES} ${EXEC}

# EOF #
#######

