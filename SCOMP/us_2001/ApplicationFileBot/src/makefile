# A Makefile with variables and suffix rules

# variables
INCLUDES = header.h
SOURCES = main.c parent_func.c child1_func.c child2_func.c utils.c circular_buffer.c
OBJFILES = main.o parent_func.o child1_func.o child2_func.o utils.o circular_buffer.o
EXEC = ApplicationFileBot

# Suffix rules
.SUFFIXES : .c .o

# How to build an object .c from a code file .o ; $< -- file name
.c.o:
	gcc -g -Wall -Wextra -fanalyzer -c $<
	

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

