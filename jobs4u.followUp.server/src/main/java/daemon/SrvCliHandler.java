package daemon;

import eapli.base.MessageCodes;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.stream.StreamSupport;

public class SrvCliHandler implements Runnable {
    private static Socket s;
    private static DataOutputStream sOut;
    private static DataInputStream sIn;
    private static SystemUser user;
    private final static char MESSAGE_VERSION = '1';

    public SrvCliHandler(Socket cli_s) {
        s = cli_s;
    }

    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final JobApplicationRepository applicationRepository = PersistenceContext.repositories().jobApplications();

    @Override
    public void run() {
        InetAddress clientIP;
        clientIP = s.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + s.getPort());
        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());
            while (true) {
                if (sIn.readByte() == MESSAGE_VERSION) { //check version, cleans after read
                    MessageCodes code = MessageCodes.parse((char) sIn.readByte());
                    switch (code) { //check message code
                        case COMMTEST:
                            System.out.println("Received COMMTEST");
                            returnAckCli();
                            break;
                        case DISCONN:
                            System.out.println("Received DISCONN");
                            returnAckCli();
                            s.close();
                            Thread.currentThread().interrupt();
                            break;
                        case AUTH:
                            System.out.println("Received AUTH");
                            loginCustomer();
                            break;
                        case LIST_JOBOPENINGS_REQ:
                            System.out.println("Received JOP");
                            listJobOpenings();
                            break;
                        case LIST_JOBAPPLICATIONS_REQ:
                            System.out.println("Received JAP");
                            listJobApplications();
                        default:
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Disconnected.");
        }
    }

    private void listJobApplications() throws IOException {
        readEndOfMessage();
        Iterable<JobApplication> jobApplications = applicationRepository.findApplicationsByCandidate(user.email().toString());
        if (jobApplications.iterator().hasNext()) {
            sOut.write(MESSAGE_VERSION);
            sOut.write(MessageCodes.LIST_JOBAPPLICATIONS_RES.valueOf());
            for (JobApplication ja : jobApplications) {

                System.out.println(ja.toDTO().getJobOpeningReference());

                String jobReference = ja.toDTO().getJobOpeningReference();
                String state = ja.toDTO().getStatus();

                String applicantsCount = getApplicantsCount(jobReference);
                String message = jobReference + ";" + state + ";" + applicantsCount;

                int dataLenL = message.getBytes().length % 256;
                int dataLenM = message.getBytes().length / 256;
                sOut.write(dataLenL);
                sOut.write(dataLenM);
                sOut.write(message.getBytes());
            }
            writeEndOfMessage();
        } else {
            returnErrCli("No Job Openings Available.");
        }
    }

    private void listJobOpenings() throws IOException {
        readEndOfMessage();
        Iterable<JobOpening> jobOpeningDTOS = jobOpeningSvc.allCustomerJobOpenings(user);
        if (jobOpeningDTOS.iterator().hasNext()) {
            sOut.write(MESSAGE_VERSION);
            sOut.write(MessageCodes.LIST_JOBOPENINGS_RES.valueOf());
            for (JobOpening jo : jobOpeningDTOS) {

                System.out.println(jo.toDTO().jobTitle);

                String jobReference = jo.identity().toString();
                String title = jo.getJobTitle().toString();
                String activeSince = jo.activeSince();
                String applicantsCount = getApplicantsCount(jobReference);
                String message = jobReference + ";" + title + ";" + activeSince + ";" + applicantsCount;

                int dataLenL = message.getBytes().length % 256;
                int dataLenM = message.getBytes().length / 256;
                sOut.write(dataLenL);
                sOut.write(dataLenM);
                sOut.write(message.getBytes());
            }
            writeEndOfMessage();
            //TODO send Job RES
        } else {
            returnErrCli("No Job Openings Available.");
        }
    }

    private String getApplicantsCount(String jobReference) {
        Iterable<JobApplicationDTO> list = applicationRepository.findApplicationsByJobOpeningReference(jobReference);
        long count = StreamSupport.stream(list.spliterator(), false).count();
        return String.valueOf(count);
    }

    private void loginCustomer() throws IOException {
        int usernameSize = sIn.readByte() + sIn.readByte() * 256;
        String username = new String(sIn.readNBytes(usernameSize));
        int passwordSize = sIn.readByte() + sIn.readByte() * 256;
        String password = new String(sIn.readNBytes(passwordSize));
        readEndOfMessage();
        System.out.println(username + " " + password);

        if (AuthzRegistry.authenticationService().authenticate(username, password).isPresent()) {
            user = AuthzRegistry.authorizationService().session().get().authenticatedUser();
            returnAckCli();
        } else {
            returnErrCli("Error: Username or Password wrong!");
        }
    }

    private void returnErrCli(String error) throws IOException {
        int size = error.getBytes().length;
        int dataLenL = size % 256;
        int dataLenM = size / 256;
        sOut.write(MESSAGE_VERSION);
        sOut.write(MessageCodes.ERR.valueOf());
        sOut.write(dataLenL);
        sOut.write(dataLenM);
        sOut.write(error.getBytes());
        writeEndOfMessage();
    }

    private void returnAckCli() throws IOException {
        sOut.write(MESSAGE_VERSION);
        sOut.write(MessageCodes.ACK.valueOf());
        writeEndOfMessage();
    }

    private void writeEndOfMessage() throws IOException {
        sOut.write(0);
        sOut.write(0);
    }

    private void readEndOfMessage() throws IOException {
        sIn.readByte();
        sIn.readByte();
    }
}