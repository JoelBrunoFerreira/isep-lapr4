
## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - To allow editing a job opening, we are assuming that it is permitted to change: Number of vacancies; Address; Contract Type; Mode; Description; Function. Are we on the right track, or is it necessary to modify the list to include additional information or remove something from this list?
    * A1 - From my point of view, it should be possible to change "everything" except the job reference itself. The maintenance of the system's consistency state should be taken into account.

---
#### Business rules: ####
    
    *   Choose job opening to edit from a list of job openings;   
    *   Filter job opening to edit by job refrence;
    *   Guarantee that a job opening isn´t in any recruitment process phase if editing JobTitle, ContractType, WorkingMode, Address, NumberVacancies and Description;
    *   If job Opening in recruitment process phase Screening, can't edit requirements;
    *   If job Opening has and is in recruitment process phase Interview, can't edit interview model, or anything else;
    *   If job opening in any phase past interview, can´t edit anything.

---
#### Unit Tests: ####
get jobOpeningDTO that's doesn't have a recruitment process phase set;
edit jobOpeningDTO, all attributes;

get jobOpeningDTO that's in recruitment process phase application;
edit jobOpeningDTO, requirements;
edit jobOpeningDTO, interview model(if Interview phase exists);

get jobOpeningDTO that's in process phase Interview(if exists);
can't edit jobOpeningDTO;