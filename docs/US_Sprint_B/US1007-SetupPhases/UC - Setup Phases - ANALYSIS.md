# UC 1007 - As Customer Manager, I want to setup the phases of the process for a job opening.

## 1. Analysis

**From the specifications document:**

>* The recruitment process for a job opening follows a sequence of phases: application; resume
   screen; interviews; analysis; result.
>* Application This is the first phase of the process. During this phase candidates submit
   their applications.
>* Screening This phase follows the application phase. In this phase, applications are verified against a set of requirements. Applications that do not meet mandatory requirements
   are rejected.
>* Interviews This phase is not mandatory, but is common. During this phase, accepted
   candidates may be interviewed. Results for the interviews are registered for further
   analysis.
>* Analysis During this phase, the applications are analyzed (using all available information
   like interviews and curriculum) and candidates are ranked.
>* Result In this phase, candidates as well as customers are notified of the final result.
   The customer manager is responsible to setup the process, defining the dates for the phases
   and if the process includes interviews



## 2. Business Rules

>* The recruitment process for a job opening follows a sequence of phases: application; resume
   screen; interviews; analysis; result.
>* The phases in the recruitment process are defined by the Customer Manager.
>* Interview phase is not mandatory.
>* Each phase has a period (dates)

## 3. Unit Tests


>* testRoleMustBeCustomerManager
>* testPhaseDatesNotOverlapping
>* testMinimumNumberOfPhases
>* testMaximumNumberOfPhases




