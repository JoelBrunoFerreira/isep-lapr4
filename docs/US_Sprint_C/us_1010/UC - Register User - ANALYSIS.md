# UC 1010 - As Customer Manager, I want to open or close phases of the process for a job opening.

## 1. Analysis


### 1.1. Use Case Description

>* As Customer Manager, I want to open or close phases of the process for a job opening.
### 1.2. Customer Specifications and Clarifications


**From the specifications document:**

>* A
   customer manager will register job offers for the entities he manages in the backoffice. **The
   customer manager will also manage other aspects of job offers, namely the entire candidate
   selection process.**


**From the Product Owner clarifications:**

>* When closing a phase, the recruitment process moves automatically to the next phase (regardless of the dates already defined).
>* A phase can't jump from start to finish if there are phases in between.
>* A previous phase can be reopened if there are no steps started in the current phase.
>* Once the process reaches the complete state, the job opening is no longer active.
>* Interview phase can't be started if there is no interview model loaded.
>* 


### 1.3 Input and Output Data


**Input Data:**

>* Typed data:
>    * Open/close phase
>    * Start date
>    * End date

>* Selected data:
>    * Phase


**Output Data:**

>* (In)Success of the operation

## 2. Business Rules

>* The recruitment process phases can only be edited by the Customer Manager or the Admin.
>* A job opening recruitment phase can only be open or closed if it's present in the job opening.
>* A phase opening or closing can't jump over more than one phase.
> 

## 3. Unit Tests


>* testChangePhaseMenuByCustomerManager
>* testChangePhaseOpen
>* testChangePhaseClose
>* testReopenPreviousPhase




