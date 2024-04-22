# UC 1009 - As Customer Manager, I want to select the requirements specification to be used for a job opening.

## 1. Analysis

### 1.1 Customer Specifications and Clarifications

**From the specifications document:**

>* A job requirement specification module should:
>* Generate a template text file with the requirements to be evaluated and the possible
   answers for each requirement
>* Evaluate if a text file with the requirements for a particular candidate is syntactically
   correct
>* Evaluate a text file with the requirements for a particular candidate and provide the
   result, approved or rejected, and in case of rejection, include justification
>* Requirement Specifications and Interview Models The support
   for this functionality must follow specific technical requirements, specified in LPROG.
   The ANTLR tool should be used (https://www.antlr.org/).
>* The plugins (i.e., Job Requirements Specification and Interview Model) support the language
   automations described in Section 2.2.4. They are developed by a Language Engineer and deployed
   and configured in the Backoffice to be used for interviews and requirements verifications.

## 2. Business Rules

>* Language Engineer develops the module/plugin .jar
>* The module/plugin is setup by a configuration file
>* Requirements specifications are not unique
>* Run in Backoffice

## 3. Unit Tests


>* testTemplateAnswers
>* testRequirementsIsSintacticallyCorrect
>* testResultApproved
>* testResultRejected
>* testJustificationNotNull
>* testValidPluginPath
>* testInvalidPluginPath
>* testConfigFileNameHasJar



