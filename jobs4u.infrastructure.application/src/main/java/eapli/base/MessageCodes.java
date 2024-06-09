package eapli.base;

public enum MessageCodes {
    COMMTEST('0'), //Communications test request with no other effect on the server application than the response with an ACK message. This request has no data.
    DISCONN('1'), //End of session request. The server application is supposed to respond with an ACK message, afterwards both client and server applications are expected to close the session (TCP connection). This request has no data.
    ACK('2'), // Generic acknowledgment and success response message. Used in response to a successful request. This response contains no data.
    ERR('3'), //Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase is carried in the DATA1 field as string of ASICII codes, it’s not required to be null terminated.
    AUTH('4'), //User authentication request carrying the username in DATA1 and the user’s password in DATA2, both are strings of ASICII codes and are not required to be null terminated. If the authentication is successful, the server application response is ACK, otherwise it’s ERR.
    LIST_JOBOPENINGS_REQ('5'),
    LIST_JOBOPENINGS_RES('6'),
    LIST_JOBAPPLICATIONS_REQ('7'),
    LIST_JOBAPPLICATIONS_RES('8'),
    NOTIFY_CANDIDATES_REQ('9'),
    NOTIFY_CANDIDATES_RES('A');
    private char value;

    MessageCodes(char value) {
        this.value = value;
    }

    public static MessageCodes parse(char value) {
        for (MessageCodes code : MessageCodes.values()) {
            if (code.value == value) {
                return code;
            }
        }
        return null;
    }
    public char valueOf(){
        return this.value;
    }
}
