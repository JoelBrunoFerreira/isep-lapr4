### 1. User Interface Interaction

#### Scenario
- **Description:** Verify that the user interface allows the Customer Manager to schedule an interview for a candidate.
- **Steps:**
    1. Open the scheduling interview UI.
    2. Search for a job opening by reference.
    3. Select the job opening.
    4. Display the list of candidates who have passed the screening phase.
    5. Select a candidate to schedule an interview.
    6. Enter the interview date and time.
    7. Validate the date and time.
    8. Save the scheduling details.
- **Expected Result:** The UI should allow the Customer Manager to search for job openings, display eligible candidates, and schedule an interview with proper validation and confirmation.

### 2. Controller Functionality

#### Scenario
- **Description:** Test the controller’s ability to handle scheduling requests and apply business rules.
- **Steps:**
    1. Simulate a scheduling request from the UI with valid interview details.
    2. Verify that the controller processes the request and applies the business rules (e.g., checking if the candidate passed the screening phase).
    3. Check that the scheduled interview is saved correctly in the database.
- **Expected Result:** The controller should correctly handle the scheduling request, apply business rules, and persist the interview details

### 3. Business Rules Enforcement

#### Scenario
- **Description:** Validate that business rules are enforced during the scheduling process.
- **Steps:**
    1. Attempt to schedule overlapping interviews for different candidates.
    2. Attempt to schedule an interview for a candidate before the interview phase.
    3. Attempt to schedule an interview for a candidate who has not passed the screening phase.
    4. Schedule an interview and ensure the system displays the correct day of the week.
- **Expected Result:**
    1. Overlapping interviews should be allowed.
    2.  Interviews should be allowed before the interview phase if the candidate has passed the screening phase.
    3. The system should prevent scheduling for candidates who have not passed the screening phase and provide an appropriate error message.
    4. The system should display the correct day of the week for the scheduled interview date.

### 4. Data Consistency

#### Scenario
- **Description:**  Ensure that data consistency is maintained when scheduling interviews.
- **Steps:**
    1. Schedule an interview for a candidate.
    2.   Verify that the candidate's status and details remain unchanged except for the interview schedule.
    3.   Check that the scheduled interview information is accurately reflected in the database.
- **Expected Result:** The candidate's status and details should remain consistent, and the scheduled interview information should be accurately reflected in the database.

### 5. Error Handling

#### Scenario
- **Description:** Test the system's behavior when encountering errors or invalid inputs during the scheduling process.
  - **Steps:**
    1. Attempt to schedule an interview with a missing required field (e.g., date or time).
    2. Try to schedule an interview with an invalid candidate ID.
    3. Attempt to schedule an interview for a candidate who does not exist.
- **Expected Result:** The system should display appropriate error messages, prevent invalid scheduling attempts, and maintain data integrity.