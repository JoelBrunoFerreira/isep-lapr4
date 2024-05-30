### 1. User Interface Interaction
#### Scenario
- **Description:** Verify that the user interface allows the Customer Manager to view an ordered list of candidates by interview scores.
- **Steps:**
   1. Open the UI to view candidates for a specific job opening.
   2. Select a job opening that has an interview phase.
   3. Request to view the ordered list of candidates.
- **Expected Result:**  The UI should display the list of candidates ordered by their interview scores in descending order.

### 2. Controller Functionality
#### Scenario
- **Description:** Test the controller’s ability to handle requests for an ordered list of candidates and apply business rules.
- **Steps:**
   1. Simulate a request from the UI for an ordered list of candidates for a job opening.
   2. Verify that the controller retrieves the candidates, applies the sorting logic, and handles cases where interview scores are not available.
   3. Check that the ordered list is returned correctly.
- **Expected Result:** The controller should handle the request, apply business rules, and return an ordered list of candidates by interview scores in descending order.

### 3. Business Rules Enforcement
#### Scenario
- **Description:** Validate that business rules are enforced when generating the ordered list of candidates.
- **Steps:**
   1. Request an ordered list for a job opening with an interview phase.
   2. Request an ordered list for a job opening without an interview phase.
   3. Request an ordered list for a job opening with candidates lacking interview scores.
- **Expected Result:**
   1. The list should be ordered by interview scores in descending order.
   2. The system should notify the user that sorting by interview score is not applicable.
   3. The system should handle candidates without interview scores appropriately, notifying the user if necessary.

### 4. Data Consistency
#### Scenario
- **Description:** Ensure that data consistency is maintained when retrieving and ordering candidate lists.
- **Steps:**
   1. Retrieve candidates for a job opening and order them by interview scores.
   2. Verify that the candidate details and scores remain unchanged.
   3. Check that the ordered list reflects the correct scores and order.
- **Expected Result:** The candidate details and scores should remain consistent, and the ordered list should accurately reflect the interview scores in descending order.

### 5. Error Handling
#### Scenario
- **Description:** Test the system's behavior when encountering errors or invalid inputs while generating the ordered list of candidates.
- **Steps:**
   1. Attempt to request an ordered list for a job opening with no candidates.
   2. Attempt to request an ordered list for a non-existent job opening.
   3. Attempt to request an ordered list when there are no interview scores available.
- **Expected Result:** The system should display appropriate error messages, handle the errors gracefully, and notify the user when sorting by interview score is not applicable.