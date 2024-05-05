# UC 1011 - As Customer Manager, I want to select the interview model to use for the interviews of a job opening (for their evaluation/grading).
## 1. Analysis

### 1.1 Customer Specifications and Clarifications

**From the specifications document:**
>* An interview model module should::
>* Generate a template text file with the questions to be asked in the interview and the
   possible answers for each question
>* Evaluate if a text file with the questions and answers for a particular candidate interview
   is syntactically correct
>* Evaluate a text file with the questions and answers for a particular candidate interview
   and provide a numeric grade for that interview
>* Requirement Specifications and Interview Models The support
   for this functionality must follow specific technical requirements, specified in LPROG.
   The ANTLR tool should be used (https://www.antlr.org/).
>* The plugins (i.e., Job Requirements Specification and Interview Model) support the language
   automations described in Section 2.2.4. They are developed by a Language Engineer and deployed
   and configured in the Backoffice to be used for interviews and requirements verifications.
>* For job interviews, the goal is not to approve or reject a candidate but to evaluate
   the answers and calculate a grade for the interview in the range 1-100.
   A job interview is a form with a set of questions. Each question has a value associated. The
   sum of the values for all the questions should be 100.

## 2. Business Rules

>* Language Engineer develops the module/plugin .jar
>* The module/plugin is setup by a configuration file
>* Interview Model is unique
>* Run in Backoffice

## 3. Unit Tests

>* testInterviewModelAssignment



