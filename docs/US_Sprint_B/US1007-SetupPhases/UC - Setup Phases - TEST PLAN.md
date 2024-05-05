# UC 1007 - As Customer Manager, I want to setup the phases of the process for a job opening.


## Test Plan

## Case #1: Create recruitment process phases
>1. Login as Customer Manager
>2. Create a new Job Opening
>3. Insert mandatory information
>4. Set recruitment process phases
>5. List job opening to confirm recruitment process phases creation


## Case #2: Register repeated job opening
>1. Login as Customer Manager
>2. Run case #1
>3. Run case #1 with the same input
>4. The system shall alert that the Job opening already exists


## Case #3: Create overlapping dates in recruitment phases
>1. Login as Customer Manager
>2. Create a new Job Opening
>3. Insert mandatory information
>4. Set recruitment process phases (overlap dates between phases).
>5. The system shall alert that the dates of the phases can't overlap each other.