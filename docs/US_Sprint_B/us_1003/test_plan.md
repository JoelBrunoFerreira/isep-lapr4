## Job Openings Management System Test Plan

### 1. User Interface Interaction
#### Scenario
- **Description**: Verify that the user interface properly interacts with the user during job opening listing and filtering.
- **Steps**:
    1. Open the job openings listing UI.
    2. Request to list job openings.
    3. Enter filter criteria such as Customer, date, and activity status.
    4. Apply the selected filters.
    5. Review the displayed job openings list.
- **Expected Result**: The UI should guide the user through the process and display the filtered job openings list accurately.

### 2. Controller Functionality
#### Scenario
- **Description**: Test the functionality of the controllers in handling user requests and business logic for job openings listing.
- **Steps**:
    1. Simulate a request from a Customer Manager to list job openings.
    2. Verify that the controller retrieves job openings data based on the requested criteria.
    3. Ensure that the controller applies the selected filters accurately.
- **Expected Result**: The controller should retrieve and filter job openings data correctly based on the requested criteria.

### 3. Job Openings Listing Criteria
#### Scenario
- **Description**: Validate the job openings listing criteria specified by the client.
- **Steps**:
    1. Verify that job openings can be listed by filtering based on Customer, date, and activity status.
    2. Test filtering by Customer name, customer code, and other relevant details.
    3. Test filtering by a specific date and date range.
    4. Test filtering by activity status (status or inactive).
- **Expected Result**: Job openings should be accurately listed based on the specified criteria, providing flexibility and ease of management for the users.

### 4. Customer Manager Access Rights
#### Scenario
- **Description**: Verify that Customer Managers have access only to job openings assigned to their respective customers.
