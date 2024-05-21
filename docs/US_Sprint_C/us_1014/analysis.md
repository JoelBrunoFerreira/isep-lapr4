# US1014 - As Customer Manager, I want to record the time and date for an interview with a candidate.

## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - Time and date, does it mean the start date and not the end date? Can there be parallel interviews?
    * A1 - US1014 refers to scheduling the date of an interview with a candidate, such as indicating the day and time (e.g., April 23 at 2:00 PM). Regarding scheduling "overlapping" interviews (with the same start time), at this moment, it would be allowed (for example, the customer manager can delegate someone else to conduct the interview). This does not invalidate the need to verify if the interviews occur within the interview phase.

    * Q2 - Regarding scheduling the interview, when should it be possible to schedule this date? Should it only be possible to schedule the interview when the recruitment process is in the interview phase? Or will it be possible to schedule it in earlier phases?
    * A2 - For me, it can be possible to schedule interviews earlier, but attention should be paid to whether the candidate has "passed" the screening. It doesn't make sense to schedule an interview for a candidate who hasn't been accepted. Pay attention to these kinds of aspects.

    * Q3 - Is it possible to schedule interviews for any day and time or we must take into account weekends, working hours and holidays, for example?
    * A3 - The system should display the day of the week for the selected date. But the system should accept any valid date.

---
#### Business rules: ####
    *   It is permissible to schedule overlapping interviews, meaning multiple interviews can occur simultaneously if they have the same start time.
    
    *   Interviews can be scheduled before the interview phase of the recruitment process. However, attention must be paid to whether the candidate has passed the screening phase before scheduling an interview.
    
    *   The system should accept any valid date for scheduling interviews. However, it should display the day of the week for the selected date to provide clarity on scheduling.

---
#### Unit Tests: ####
    *   Test to check if overlapping interviews are allowed;

    *   Check if interviews can be scheduled before the interview phase;

    *   Check if interviews are scheduled only for accepted candidates(passed screening phase);

    *   Check if the system accepts any valid date for scheduling interviews.
