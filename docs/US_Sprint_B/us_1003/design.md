# DESIGN #
SD --> [us_1003_SD.puml](us_1003_SD.puml)
## Entities:
- **Job Opening:**
    - Attributes:
        - JobReference (ID)
        - Title
        - ContractType
        - Mode
        - NumberVacancies
        - Description
        - Address
        - RecruitmentProcess (list of Phases)
    - Relationships:
        - Belongs to one Customer
- **USERS**
    - Role : Customer
      - Attributes:
          - Acronym
          - Password
          - Name
          - Email
          - Address
      - Relationships:
          - Has one or more Job Openings
    - Role: Customer Manager
      - Attributes:
          - Email
          - Password
      - Relationships:
          - Manages one or more Customers
          - Manages one or more Job Openings (assigned to respective Customers)

## Use Case - Listing Job Openings:
1. **Customer Manager** requests the system to list job openings.
2. **System** retrieves job openings data.
3. **System** displays the job openings list to the **Customer Manager**.
4. **Customer Manager** selects filter criteria (e.g., Customer, Date).
5. **System** applies the selected filters to the job openings list.
6. **System** displays the filtered job openings list to the **Customer Manager**.

