grammar Jobs4uGrammar;

start: interviewModelTemplate ;

interviewModelTemplate: '<MODEL>'  question+ '</MODEL>' EOF;

question: '<QUESTION>'  (title | answer| grade| format)* '</QUESTION>' ;

title: '<TITLE>' QUOTE_STRING '</TITLE>' ;

answer: '<ANSWER>' QUOTE_STRING '</ANSWER>' ;

grade: '<GRADE>' INTEGER '</GRADE>' ;

format  : boolean_answer
        | short_text_answer
        | choice_single_answer
        | choice_multiple_answer
        | integer_answer
        | decimal_answer
        | date_answer
        | time_answer
        | integer_scale_answer;

boolean_answer:
    FORMAT_START 'BOOLEAN' FORMAT_END
    SOLUTION_START BOOLEAN SOLUTION_END ;
short_text_answer:
    FORMAT_START 'SHORT_TEXT' FORMAT_END
    FORMAT_CONF_START QUOTE_STRING FORMAT_CONF_END
    SOLUTION_START QUOTE_STRING SOLUTION_END ;
choice_single_answer:
    FORMAT_START 'CHOICE_SINGLE_ANSWER' FORMAT_END
    FORMAT_CONF_START format_conf_choice_single_answer FORMAT_CONF_END
    SOLUTION_START QUOTE_STRING SOLUTION_END ;
choice_multiple_answer:
    FORMAT_START 'CHOICE_MULTIPLE_ANSWER' FORMAT_END
    FORMAT_CONF_START format_conf_choice_multiple_answer FORMAT_CONF_END
    SOLUTION_START format_answer_choice_multiple_answer SOLUTION_END ;
integer_answer:
    FORMAT_START 'INTEGER' FORMAT_END
    SOLUTION_START INTEGER SOLUTION_END ;
decimal_answer:
    FORMAT_START 'DECIMAL' FORMAT_END
    SOLUTION_START DECIMAL SOLUTION_END ;
date_answer:
    FORMAT_START 'DATE' FORMAT_END
    SOLUTION_START DATE SOLUTION_END ;
time_answer:
    FORMAT_START 'TIME' FORMAT_END
    SOLUTION_START TIME SOLUTION_END ;
integer_scale_answer:
    FORMAT_START 'INTEGER_SCALE' FORMAT_END
    FORMAT_CONF_START SCALE FORMAT_CONF_END
    SOLUTION_START SCALE SOLUTION_END ;

format_conf_choice_single_answer: QUOTE_STRING (COMMA QUOTE_STRING)*;

format_conf_choice_multiple_answer: QUOTE_STRING (COMMA QUOTE_STRING)*;

format_answer_choice_multiple_answer:  format_answer_choice_multiple_answer_option (';'format_answer_choice_multiple_answer_option)*;
format_answer_choice_multiple_answer_option: QUOTE_STRING (',' QUOTE_STRING)* PERCENTAGE;

NEWLINE : ('\r\n'|'\n'|'\r')+ -> skip;
WS: [ \t]+ -> skip;
BOOLEAN: 'y'|'Y'|'Yes'|'yes'|'t'|'T'|'True'|'true'|'n'|'N'|'No'|'no'|'f'|'F'|'False'|'false';
FORMAT_CONF_START: '<FORMAT_CONF>';
FORMAT_CONF_END: '</FORMAT_CONF>';
SOLUTION_START: '<SOLUTION>';
SOLUTION_END: '</SOLUTION>';
FORMAT_START: '<FORMAT>';
FORMAT_END: '</FORMAT>';
PERCENTAGE: ':' [0-9]+ '%';
SCALE: [0-9]+ '-' [0-9]+;
INTEGER: [0-9]+;
DECIMAL: [0-9]+ '.' [0-9]+;
DATE: '"' [0-9][0-9] '/' [0-9][0-9] '/' [0-9][0-9][0-9][0-9] '"';
TIME: '"' [0-9][0-9] ':' [0-9][0-9] ':' [0-9][0-9] '"';
COMMA: ',';
DASH: '-';
QUOTE_STRING: '"' STRING '"';
STRING: ([A-Za-z ?:;.,'0-9()/çáàãâéèêíìîºªóòõôúùû\-]|'}'|'{'|']'|'[')+;
