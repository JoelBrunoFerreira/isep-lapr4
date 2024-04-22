
## ANALYSIS ## 

**2002 - As Operator, I want to register an application of a candidate for a job opening and import all files received**

#### Meeting with the client: ####

    * Q1 - Is it the Operator who registers an application or is it the system that does it automatically? And how does the application verification plugin integrate into this process?
    * A1 - The Operator registers the application. For this, it's the Operator who initiates the process, but the system must import the data resulting from the Application File Bot "automatically". The mentioned plugin enters this process through US 2003, where the Operator generates a template file with the data to be entered to validate an application. In US 2004, after filling in the specific data of the application (based on the previous template file), the Operator submits this file to the system, which will be used to evaluate/verify the application. If the criteria are not met, the application is rejected.

    * Q2 - I'd like to know what is the expected flow of executing US2002 (application registration and files import, by the operator). Can you reproduce step by step which actions should the operator execute? Example: 1. The system asks the operator for the candidate's email. 2. The operator enters the candidate's email. 3. The system asks for the job reference. 4. The operator enters the job reference. 5. The system creates the job application, if there is data for it in the shared folder.    
    * A2 - There are no specific requirements for the UI/UX but I think it will be more user friendly if the Operator could start the process by selecting the shared folder for the application to be imported.

    * Q3 - After the files' information in the shared folder has been used by the Operator to register an application, should they remain in the folder or be deleted? If they are not deleted, how do we determine which ones have not yet been "used"?
    * A3 - Assuming they have already been imported into the system, I have no additional requirements regarding the files. The second question is a problem that should be addressed by the proposed solution. I have nothing to say about that aspect.
    
    * Q4 - What needs to be recorded in the system?
    * A4 - There must be a record indicating that the candidate in question submitted the application, and all submitted files must be recorded/imported into the system.

---
#### Business rules: ####

    * The Operator is a company employee whose main responsibility is to monitor the automatic process that registers applications for job offers.
    * The Operator will import the files produced by the Applications File Bot and register the applications, creating candidates that dot not exist in the system.
    * Operator Application Registration and Verification:
        - Rule: The Operator is responsible for registering the application.
        - Process:
            The Operator initiates the registration process.
            The system automatically imports data from the Application File Bot.
            The Operator generates a template file for validation.
            After filling in specific data based on the template, the Operator submits the file to the system.
            The system evaluates and verifies the application against predefined criteria.
            If the criteria are not met, the application is rejected.
    * Execution Flow for Application Registration and Files Import (US2002):
        - Rule: The Operator initiates the process by selecting the shared folder for the application to be imported.
        - Process: There are no specific UI/UX requirements, but it's suggested that the Operator starts by selecting the shared folder. The exact steps for the Operator's actions are not specified.
    * Handling of Files in the Shared Folder:
        - Rule: No specific requirements are provided regarding the retention or deletion of files in the shared folder after being used by the Operator.
        - Process: Assuming the files have already been imported into the system, no additional actions are required concerning the files in the shared folder. Determining which files have been used is a problem to be addressed by the proposed solution.
    * Recording in the System:
        - Rule: The system must record that the candidate submitted the application, and all submitted files must be imported into the system.
        - Process: The system must maintain a record of each application submitted by a candidate, including all files associated with the application.

---
#### Unit Tests: ####

