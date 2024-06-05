# US1019 - As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants.

## ANALYSIS ## 

#### Meeting with the client: ####

    * Q1 - You stated that one of the this to show in the listing of job openings is "active since". You've clarified that an active job opening is the one where its recruitment process is on-going. Are the job openings listed in this funcionality only the ones with recruitment process on-going? Or also the ones without recruitment processes, the ones with processes that haven't yet started or have ended?
    * A2 - In the context of this US, “active since” means the date from the start of the process, the “application” phase (since that date, candidates can apply). This functionality should include all the “active” job openings.

---
#### Business rules: ####
    *   A job reference has the customers acronym;
    *   The position to be displayed is the job opening function/title;
    *   A job opening is active since the start date of the application phase;
    *   Job openings to be listed must all be in an active phase (Application, Screening, Interview, Analysis and Result);
    *   Number of applicants - counter of all candidates with applications to a specific job opening;
---

#### Protocol description ####
    *   It's a TCP (Transmission Control Protocol) based client-server protocol.
    *   The client application takes the initiative of establishing a TCP connection with the server application, for such the client application is required to know (IP address or DNS name) the node where the server application is running and the TCP port number where the server application is accepting TCP connections.
    *   After the TCP connection is established, the connected applications exchange messages with the format described in Section 4.2.
    *   Once established, the TCP connection between the client application and the server application is kept alive and is used for all required data exchanges while the client application is running.
    *   All message exchanges between the client application and the server application must follow a very restrict client-server pattern: the client application sends one request message, and the server application sends back one response message.
##### Messages format #####
| Field         | Offset | Length | Description                                                                                                                                                                                                                                                                                  |
|---------------|--------|--------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| VERSION       | 0      | 1      | Message format version. This field is a single byte and should be interpreted as an unsigned integer (0 to 255). The present message format version number is one.                                                                                                                            |
| CODE          | 1      | 1      | This field identifies the type of request or response, it should be interpreted as an unsigned integer (0 to 255). See Section 4.3.                                                                                                                                                         |
| DATA1_LEN_L   | 2      | 1      | These two fields are used to specify the length in bytes of the following DATA1 field. Both these fields are to be interpreted as unsigned integer numbers (0 to 255). The length of the DATA1 field is to be calculated as: DATA1_LEN_L + 256 x DATA1_LEN_M If the resulting value is zero, it means DATA1 does not exist, and the message has ended at this point. |
| DATA1_LEN_M   | 3      | 1      |                                                                                                                                                                                                                                                                                              |
| DATA1         | 4      | -      | First chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message code.                                                                                                                                  |
| DATA2_LEN_L   | -      | 1      | These two fields are used to specify the length in bytes of the following DATA2 field. Both these fields are to be interpreted as unsigned integer numbers (0 to 255). The length of the DATA2 field is to be calculated as: DATA2_LEN_L + 256 x DATA2_LEN_M If the resulting value is zero, it means DATA2 does not exist, and the message has ended at this point. |
| DATA2_LEN_M   | -      | 1      |                                                                                                                                                                                                                                                                                              |
| DATA2         | -      | -      | Second chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message code.                                                                                                                                  |

##### Messages format #####
| CODE | Type     | Meaning                                                                                                                                                                                                                                                                                          |
|------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0    | Request  | COMMTEST – Communications test request with no other effect on the server application than the response with an ACK message. This request has no data.                                                                                                                                           |
| 1    | Request  | DISCONN – End of session request. The server application is supposed to respond with an ACK message, afterwards both client and server applications are expected to close the session (TCP connection). This request has no data.                                                                |
| 2    | Response | ACK – Generic acknowledgment and success response message. Used in response to a successful request. This response contains no data.                                                                                                                                                             |
| 3    | Response | ERR – Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase is carried in the DATA1 field as string of ASCII codes, it’s not required to be null terminated. |
| 4    | Request  | AUTH – User authentication request carrying the username in DATA1 and the user’s password in DATA2, both are strings of ASCII codes and are not required to be null terminated. If the authentication is successful, the server application response is ACK, otherwise it’s ERR.                 |
| 5    | Request  | LIST_JOBOPENINGS_REQ – Request list of job openings                                                                                                                                                                                                                                              |
| 6    | Response  | LIST_JOBOPENINGS_RES |
| 7    | Request  | LIST_JOBAPPLICATIONS_REQ – Request of job applications                                                                                                                                                                                                                                           |
| 8    | Response  | LIST_JOBAPPLICATIONS_RES |

---
#### Unit Tests: ####
    *   testJobOpeningListingIncludesOnlyActiveJobs();
    *   testJobOpeningListingExcludesInactiveJobs();
    *   testJobOpeningListingIsEmpty();
    *   testActiveSinceDateIsStartOfApplicationPhase();
    *   testJobReferenceIncludesCustomerAcronym();
    *   testPositionDisplayedAsJobFunctionTitle();
    *   testJobOpeningWithNoApplications();
