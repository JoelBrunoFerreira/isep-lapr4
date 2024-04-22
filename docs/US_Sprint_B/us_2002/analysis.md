
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

    * The Applications File Bot is continuously monitoring a folder for new applications to be processed.
    processed. 
    * The Bot should copy the files to a shared folder that is organized by job reference (top folders) and then by application(sub folder inside the job reference folder). 
    * The Bot should produce a text report of all the processed applications (including applications for job references and files available).
    * The file produced by the Applications File Bot are used to integrate candidates and applications into the system by the operator.
---
#### Unit Tests: ####

