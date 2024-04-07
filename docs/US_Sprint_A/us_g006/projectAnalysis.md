# Project Analysis

## Identify the domain
_The first step in creating a domain-driven model is to identify the domain you are working in.
This means understanding the problem space, the stakeholders involved, and the business goals that are driving the project._

### Problem space
Creation of a remote learning platform that supports the needs of the 3 major stakeholder (Jobs4U, Clients and Candidates) in the learning experience.
The system is abel, among others, to manage users, manage clients, create job offerings, enroll in those offerings(Candidates), verify state of job offerings(Customers)...

### Stakeholders:

1. **Jobs4U**

2. **Customers**

3. **Candidates**


### Business goals
- Develop an exploratory solution to automate key activities of Jobs4U, a talent acquisition company, within a 3-month timeframe;
- Create a Minimum Viable Product (MVP) to streamline recruitment services for clients;
- Provide recruitment services to other companies or entities seeking human resources;
- Develop processes to select a set of candidates for job offers based on client requirements;
- Deliver ordered candidate lists to clients, enabling them to make final recruitment decisions.


## Define the domain concepts
_Once you have a clear understanding of the domain, you can start defining the key concepts that are relevant to your model. These might be entities, value objects, or aggregates that represent the core business objects you need to work with._

### Entity and value objects

| Concept                       | Entity | ValueObject | Comments                                                       |
|-------------------------------|:------:|:-----------:|:---------------------------------------------------------------|
| **CustomerManager**           |   x    |             |                                                                |
| Email                         |        |      x      | identity, mandatory, possible validation rules                 |
| Password                      |        |      x      | mandatory, possible validation rules                           |
|                               |
| **Customer**                  |   x    |             | Companies/Entities that provide the job offers                 |
| Email                         |        |      x      | identity, mandatory, possible validation rules                 |
| Password                      |        |      x      | mandatory, possible validation rules                           |
| Address                       |        |      x      |                                                                |
| Name                          |        |      x      |                                                                |
| Acronym                       |        |      x      | unique                                                         |
|                               |
| **Candidate**                 |   x    |             |                                                                |
| Name                          |        |      x      | mandatory, validation rules                                    |
| PhoneNumber                   |        |      x      | mandatory                                                      |
| Email                         |        |      x      | identity, mandatory, validation rules                          |
| Password                      |        |      x      | mandatory, validation rules                                    |
|                               |
| **Job Opening**               |   x    |             |                                                                |
| JobReference                  |        |      x      | Identity, validation rules                                     |
| Title                         |        |      x      |                                                                |
| Address                       |        |      x      |                                                                |
| Description                   |        |      x      |                                                                |
| Number of Vacancies           |        |      x      | 	                                                              |
| ContractType                  |        |      x      | ENUM                                                           |
| Mode                          |        |      x      | ENUM                                                           |
|                               |
| **Job Application**           |   x    |             |                                                                |
| appliedCandidate              |        |             |                                                                |
| Job Opening                   |   x    |             |                                                                |
| Interview                     |   x    |             |                                                                |
|                               |
| **Interview Model**           |   x    |             |                                                                |
| Title                         |        |      x      | identify                                                       |
| Question                      |        |      x      | 		list of questions                                            |
|                               |
| **Requirement Specification** |   x    |             |                                                                |
| Title   	                     |        |      x      | Identify                                                       |
| JobRequirement                |        |      x      | a list of job requirements                                     |
| FileName                      |        |      x      |                                                                | 
|                               |
| **Recruitment Process**       |   x    |             |                                                                |
| Phase                         |        |      x      |                                                                |
| Period                        |        |      x      |                                                                |


Application File Bot -> Service
RequirementSpecificationEvaluation -> Service
InterviewModelEvaluation -> Service