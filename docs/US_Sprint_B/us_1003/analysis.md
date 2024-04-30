
## ANALYSIS ## 

**1003 - As Customer Manager, I want to list job openings.**

#### Meeting with the client: ####

    * Q1 - It's asked to list job openings, is there any criterion to define which ones to list? Or is it all openings in the entire system?
    * A1 - I assume being able to filter by Customer and date would be useful. Also, being able to filter only status ones or all of them seems useful to me.

    * Q2 - In this case, what will be the method that the Customer Manager will use to filter the Job Openings by Customer (name, email, ...)? And when referring to "being able to filter by date," does it mean a specific date or a time range?
    * A2 - The Customer is typically a company and has a name. The existence of a customer code has also been mentioned. Regarding filtering by date, if you are in the role of the customer manager who needs to consult job openings, does it make sense for it to be for a single day? In other words, would they need to know on which day they registered the job opening they are searching for?

    * Q3 - At what moment does a job opening become status? Is it when it's created and has a set of requirements associated with it? Is it when it's linked to an ongoing recruitment process?
    * A3 - The reference to status arises in the context of dates. A job opening whose process has already ended is not status.

    * Q4 - Regarding the listing of job openings, can a customer manager list all job openings or only those assigned to them? In other words, are job openings assigned to a specific customer manager, and can they only access their list of job openings?
    * A4 - I believe it makes sense to list only "their" job openings.

---
#### Business rules: ####

    * Listing Job Openings:
        - Job openings can be listed based on criteria such as Customer, date, and activity status.
        - Filtering by Customer and date is deemed useful for effective management.
    * Customer Management:
        - Each job opening is associated with a specific Customer (company), identified by name and possibly a customer code.
        - Customer managers have access only to job openings assigned to their respective customers.
    * Activation of Job Openings:
        - A job opening is considered status while its recruitment process is ongoing.
        - Once the recruitment process concludes, the job opening becomes inactive.

---
#### Unit Tests: ####

