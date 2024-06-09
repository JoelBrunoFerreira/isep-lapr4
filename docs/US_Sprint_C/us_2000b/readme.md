# US 2000b - Manage Candidates

## 1. Requirements Engineering
* As Operator, I want to enable/disable a candidate
* Priority: 5

## 2. Customer Specifications and Clarifications
+ From the client clarifications:

> Question: O que é o enable/disable do candidato?
> Answer: Refere-se a desativar o acesso do candidato ao sistema (i.e., Candidate App).

> Question:  US 2000b – for the use case 2000b which states "As  Operator, I want to enable/disable a candidate". 
I would like to know if the client would like two different menus to be created, with each menu responsible for either 
activating or deactivating candidates.
> Answer: I have no specific requirements for the UX/UI but I want you to follow best practices.

> Question: US2000b – Na us 2000b, é suposto ao desativar um candidato, apenas lhe retirar a role e deixa-lo como 
user ao desativa-lo completamente?
> Answer: Considero que o objetivo desta US é permitir bloquear e desbloquear o acesso de um candidato ao sistema. 
Isso não deve invalidar as candidaturas dessa pessoa, apenas o acesso desse candidato ao sistema.


## 3. Acceptance Criteria

    AC1: After disable, the candidate should not be able to login, in the application.
    AC2: After enable, the candidate should be able to login again, in the application.
    AC3: When the candidate is deactivated, the date of deactivation should appear in the DEACTIVATEDON column of the database. 
    AC4: When the candidate is activated, the DEACTIVATEDON column in the database should become NULL
   

## 4. Found out Dependencies
* The system should already have an registered Operator, with the authorization level necessary to manage candidates.
* The system should already hava at least one registered Candidate.

## 5 Input and Output Data

Input Data for enable:

     - Typed data:
        Candidate number (Integer; mandatory)

Input Data for disable:

    - Typed data:
        Candidate number (Integer; mandatory)

Output Data for disable:

    - (In)Success of the operation: Display "Wrong username or password." message.


## 6. System Sequence Diagram (SSD)
* For disable a candidate
[US_2000b_disable_candidate_SSD.puml](US_2000b_disable_candidate_SSD.puml)

* For enable a candidate
[US_2000b_enable_candidate_SSD.puml](US_2000b_enable_candidate_SSD.puml)

## 7. Tests

## 8. Observations
* n/a