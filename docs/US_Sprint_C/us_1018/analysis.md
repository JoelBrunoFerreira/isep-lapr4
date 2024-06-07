# US1019 - As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening.
## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - after the process of evaluating all interviews for the job opening, should the phase it is in be automatically changed to "Result," or should it remain in "Analysis"?
    * A1 - US1018 should not change the current phase. US1010 allows for the phase changes in the recruitment process.

---
#### Business rules: ####
    *   To execute this US, job openings must be in Analysis phase;
    *   The job opening must have the interview phase;
    *   Each interview to be evaluated belongs to a job application, therefore to one candidate.
    *   The job application must have an interview already answered before beeing evaluated.
---
#### Unit Tests: ####
    *   Test empty job opening list;
    *   Test empty application list;
    *   Test job openings have interview phase;
    *   Test application has no interview answered;
    *   Test evaluateInterviewAnswers;
