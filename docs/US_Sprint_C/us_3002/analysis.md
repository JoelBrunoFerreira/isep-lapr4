# US1019 - As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants.

## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - You stated that one of the this to show in the listing of job openings is "active since". You've clarified that an active job opening is the one where its recruitment process is on-going. Are the job openings listed in this funcionality only the ones with recruitment process on-going? Or also the ones without recruitment processes, the ones with processes that haven't yet started or have ended?
    * A2 - In the context of this US, “active since” means the date from the start of the process, the “application” phase (since that date, candidates can apply). This functionality should include all the “active” job openings.

---
#### Business rules: ####
    *   A job reference has the customers acronym;
    *   The position to be displayed is the job opening function/title;
    *   A job opening is active since the start date of the application phase;
    *   Job openings to be listed must all be in an active phase (Application, Screening, Interview, Analysis and Result);
    *   Number of applicants - counter of all candidates with applications to a specific job opening;
---
#### Unit Tests: ####
    *   testJobOpeningListingIncludesOnlyActiveJobs();
    *   testJobOpeningListingExcludesInactiveJobs();
    *   testJobOpeningListingIsEmpty();
    *   testActiveSinceDateIsStartOfApplicationPhase();
    *   testJobReferenceIncludesCustomerAcronym();
    *   testPositionDisplayedAsJobFunctionTitle();
    *   testJobOpeningWithNoApplications();
