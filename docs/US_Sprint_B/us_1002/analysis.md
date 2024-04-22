
## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - In the context where the Customer Manager records a job offer, how are the requirements for that job offer selected/defined?
    * A1 - The Customer Manager records the job opening (US 1002) and then (usually) selects which requirements specification is suitable for that job opening. The requirements specification will be one that was "created" by the language engineer and recorded in the system.

    * Q2 - Could we use the same interview model for more than one job opening?
    * A2 - See Q4. Yes.

    * Q3 - Does each question in an interview model accept x types of answers (e.g., multiple choice), or is it the interview model that accepts x types of answers in all its questions? Do we assume that a job opening only follows one interview model?
    * A3 - Yes, each question/response accepts one type of question/response (one of the types listed at the beginning of page 8). In US1011, the Customer Manager selects the interview model to use in interviews for a job opening. Therefore, there will only be one interview model used in the interviews for that job opening.

    * Q4 - When the Customer Manager records a job offer, does he create the requirement specifications and interview models, or is he given a list of these to select from?
    * A4 - There is US1002 and US1009 and US1011. I think it's clear what the responsibility of each one is. Creating interview models and requirements is a specific use case with a specific US to record the respective plugins (US1008) in the system.

    * Q5 - When is a job opening considered valid? Considering functionalities 1002, 1007, 1009, we have a question regarding job openings and their constitution. In US1002, it is intended to register a job opening and only afterwards, in US1009, we should select the requirements specifications for the given job opening. Given this, when registering the job opening, it would not have all the mandatory information as required. Therefore, there should be a direct connection between these user stories so that when registering, we automatically select the requirements, thus obtaining a valid job opening? Additionally, we want to clarify if the recruitment process is mandatory for the validity of a job opening.
    * A5 - The product owner is not a domain expert of the solution (only has knowledge of the problem), but regarding the first question, suggests that perhaps user stories may not be distinct menu options. As for the second question (recruitment process), I believe it is also more related to the solution than to the problem, so I won't suggest anything that could potentially complicate rather than clarify.


---
#### Business rules: ####
    
    * On job offer creation, customer/company already exits.
    * When a Customer Manager records a job offer, they must select a suitable requirements specification for that job opening. The requirements specification must be one that was created by the language engineer and recorded in the system.
    * The same interview model can be used for more than one job opening. Therefore, interview models are reusable across different job openings.
    * Each question in an interview model accepts only one type of answer. The Customer Manager selects the interview model to use for interviews for a specific job opening, and this interview model determines the types of answers accepted for all its questions. Thus, a job opening follows only one interview model.
    * The Customer Manager is responsible for creating job offer requirements specifications and interview models. These are specific use cases with respective user stories (US1002, US1009, US1011), and there are plugins (US1008) in the system to record them.
    * A job opening is considered valid when it has been registered (US1002) and the requirements specifications have been selected (US1009). However, there should be a direct connection between these user stories to ensure that the selection of requirements happens automatically upon registration, ensuring that a job opening cannot be registered without fulfilling this requirement.
    * The recruitment process is not deemed mandatory for the validity of a job opening, as it's more related to the solution rather than the problem itself.

---
#### Unit Tests: ####


