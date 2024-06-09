# US 2000b - Manage Candidates

## 1. Requirements Engineering
* As Operator, I want to enable/disable a candidate
* Priority: 5

## 2. Customer Specifications and Clarifications
+ From the client clarifications:

> Question:
> Answer: 

> Question: 
> Answer: 

> Question: 
> Answer: 

> Question: 
> Answer: 

## 3. Acceptance Criteria

    AC1: The Candidate must provide his first and last name, an email valid account and a phhone number.
    AC2: The system should generate automatically a 8 character long passorwd for each candidate, with uppercase and
         lowercase letters, numbers and ate least a special character.
    AC3: There can't be two different candidates with the same username.

## 4. Found out Dependencies
* The system should already have an registered Operator, with the authorization level necessary to manage candidates.
* The system should already hava at least one registered Candidate.

## 5 Input and Output Data

Input Data:

    Typed data:
        a First name (String; mandatory)
        a Last Name (String; mandatory)
        a email (String; mandatory)
        a Phone Number (String; mandatory)

Output Data:

    Succcess of the operation: Display "Customer registered successfully" message.
    - First name
    - Last name
    - email
    - Phone Number
    - Password (generated automatically by the system)
    - Role

    (In)Success of the operation: Display "Error registering candidate" message.


## 6. System Sequence Diagram (SSD)


## 7. Tests
 

## 8. Observations
* n/a