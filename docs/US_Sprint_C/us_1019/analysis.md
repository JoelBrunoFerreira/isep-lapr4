# US1019 - As Customer Manager, I want to get an ordered list of candidates, using job interview points (grades), to help me analyze the candidates.

## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - The list you want is related to a job opening, correct? Should the sorting order be ascending or do you want an option that includes both ascending and descending?
    * A1 - Yes, the sorting is related to applications for a job opening. The sorting should be descending, from the highest score to the lowest score.

    * Q2 - How do you envision the sorting if the job opening does not have an interview?
    * A2 - This US does not make sense for processes that do not have an interview.

---
#### Business rules: ####
    *   The list of applications must be related to a specific job opening.
    *   The default sorting order for the list of candidates must be descending, from the highest score to the lowest score.
    *   If the job opening includes an interview process, the applications must be sorted based on the interview scores in descending order.
    *   If the job opening does not include an interview process, this US is not applicable.
    *   If there are no interview scores available for a job opening, the system should notify the user that sorting by interview score is not applicable.
        
---
#### Unit Tests: ####
    *   Test empty job opening list;
    *   Test empty application list;
    *   Test job openings have interview phase;
    *   Test application has no interview score;
    *   Test sorting method, must be descending;
