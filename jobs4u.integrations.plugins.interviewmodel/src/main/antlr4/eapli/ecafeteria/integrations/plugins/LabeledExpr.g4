grammar LabeledExpr;

/* Entry point */
start: TITLE (question SEPARATOR)+ END;

/* Question types */
question:
        true_false
        | short_text
        | single_choice
        | multiple_choice
        | integer_number
        | decimal_number
        | date
        | time
        | numeric_scale;

/* True/False questions */
true_false: 'TRUE_FALSE' LEFT_BRACE description bool_solution feedback_text? RIGHT_BRACE;
bool_solution: 'SOLUTION' id=INT COLON value=BOOL LEFT_BRACKET points=FLOAT RIGHT_BRACKET;

/* Short answer questions */
short_text: 'SHORT_ANSWER' LEFT_BRACE description case_sensitive short_text_solution+ feedback_text? RIGHT_BRACE;
short_text_solution: 'SOLUTION' id=INT COLON value=STRING LEFT_BRACKET points=FLOAT RIGHT_BRACKET;
case_sensitive: 'CASE_SENSITIVE' COLON value=BOOL;

/* Matching questions */
single_choice: 'MATCHING' LEFT_BRACE description subquestion+ answer+ matching_solution+ feedback_text? RIGHT_BRACE;
subquestion: 'SUBQUESTION' id=INT COLON value=STRING;
answer: 'ANSWER' id=INT COLON value=STRING;
matching_solution: 'SOLUTION' id=INT COLON match LEFT_BRACKET points=FLOAT RIGHT_BRACKET;
match: subquestion_id=INT DASH answer_id=INT;

/* Multiple choice questions */
multiple_choice: 'MULTIPLE_CHOICE' LEFT_BRACE choice_type description answer+ numerical_solution+ feedback_text? RIGHT_BRACE;
numerical_solution: 'SOLUTION' id=INT COLON combinations LEFT_BRACKET points=FLOAT RIGHT_BRACKET;
combinations: INT (COMMA INT)*;
choice_type: 'CHOICE_TYPE' COLON value=('single-answer' | 'multiple-answer');

/* Integer number questions */
integer_number: 'INTEGER_NUMBER' LEFT_BRACE description error? integer_number_solution feedback_text? RIGHT_BRACE;
integer_number_solution: 'SOLUTION' id=INT COLON value=INT LEFT_BRACKET points=FLOAT RIGHT_BRACKET;

/* Decimal number questions */
decimal_number: 'FLOAT';

/* Date questions */
date: 'DATE' LEFT_BRACE description date_solution feedback_text? RIGHT_BRACE;
date_solution: 'SOLUTION' id=INT COLON value=DATE LEFT_BRACKET points=FLOAT RIGHT_BRACKET;

/* Time questions */
time: 'TIME' LEFT_BRACE description time_solution feedback_text? RIGHT_BRACE;
time_solution: 'SOLUTION' id=INT COLON value=TIME LEFT_BRACKET points=FLOAT RIGHT_BRACKET;

/* Numerical scale questions */
numeric_scale: 'NUMERICAL' LEFT_BRACE description error? numeric_scale_solution feedback_text? RIGHT_BRACE;
numeric_scale_solution: 'SOLUTION' id=INT COLON value=INT LEFT_BRACKET points=FLOAT RIGHT_BRACKET;
error: 'ERROR' COLON value=INT;

/* Common rules */
description: 'DESCRIPTION' COLON value=STRING;

feedback_text: 'FEEDBACK' LEFT_BRACE feedback_combination RIGHT_BRACE;
feedback_combination: (wrong_answer correct_answer?) | (correct_answer wrong_answer?);
wrong_answer: 'WRONG_ANSWER' COLON value=STRING;
correct_answer: 'CORRECT_ANSWER' COLON value=STRING;

/* Lexer Rules */
TITLE: 'INTERVIEW_MODEL';
END: 'END_OF_INTERVIEW';
/* Punctuation and operators */
COLON: ':';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
DASH: '-';
SLASH: '/';
SEPARATOR: '#';
COMMA: ',';

/* Comments */
COMMENT: '//' ~[\r\n]* -> skip;

/* Tokens */
FLOAT: DIGIT+ ('.' DIGIT+);
INT: DIGIT+;
DATE: DAY SLASH MONTH SLASH YEAR;
BOOL: 'true' | 'false';
STRING: '"' ~[\n"]* '"';
DAY: ('0'[1-9] | [12] DIGIT | '3'[01]);
MONTH: ('0'[1-9] | '1'[0-2]);
YEAR: DIGIT DIGIT DIGIT DIGIT;
TIME: HOUR COLON MINUTE;

/* Fragments */
fragment DIGIT: [0-9];
fragment HOUR: ('0' DIGIT | '1' DIGIT | '2' [0-3]);
fragment MINUTE: [0-5] DIGIT;

/* Whitespace */
WS: [ \t\r\n]+ -> skip;
