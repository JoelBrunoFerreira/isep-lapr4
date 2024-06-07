package customer.application;

import customer.dto.JobOpeningDto;
import eapli.base.Application;
import eapli.base.MessageCodes;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SrvProxy {
    private static InetAddress serverIP;
    private static Socket sock;
    private static DataOutputStream sOut = null;
    private static DataInputStream sIn = null;
    private final static char MESSAGE_VERSION = '1';


    public static boolean connect() {
        try {
            serverIP = InetAddress.getByName(Application.settings().getIpAddress());
            sock = new Socket(serverIP, Application.settings().getPort());
            sOut = new DataOutputStream(sock.getOutputStream());
            sIn = new DataInputStream(sock.getInputStream());
            return true;
        } catch (Exception ex) {
            System.out.println("Invalid server specified: " + Application.settings().getIpAddress());
            return false;
        }
    }

    public static boolean disconnect() {
        try {
            sOut.write(MESSAGE_VERSION);
            sOut.write(MessageCodes.DISCONN.valueOf());
            writeEndOfMessage();
            sOut.close();
            sIn.close();
            sock.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean customerLogin(String username, String password) throws IOException {
        if (sOut == null || sIn == null) {
            System.out.println("No connection.");
            return false;
        }
        //build message to send for login -> AUTH
        sOut.write(MESSAGE_VERSION);
        sOut.write(MessageCodes.AUTH.valueOf());
        int getDataLenL = username.getBytes().length % 256;
        sOut.write(getDataLenL);
        int getDataLenM = username.getBytes().length / 256;
        sOut.write(getDataLenM);
        sOut.write(username.getBytes());
        getDataLenL = password.getBytes().length % 256;
        sOut.write(getDataLenL);
        getDataLenM = password.getBytes().length / 256;
        sOut.write(getDataLenM);
        sOut.write(password.getBytes());
        writeEndOfMessage();

        //read message from srv -> ACK
        char version = (char) sIn.readByte();
        if (version == MESSAGE_VERSION) {
            char code = (char) sIn.readByte();
            if (code == MessageCodes.ACK.valueOf()) {
                sIn.readByte();
                sIn.readByte();
                return true;
            } else if (code == MessageCodes.ERR.valueOf()) {
                getDataLenL = sIn.readByte();
                getDataLenM = sIn.readByte();
                int totalSize = getDataLenL + (getDataLenM * 256);
                String errorMessage = new String(sIn.readNBytes(totalSize));
                readEndOfMessage();
                System.out.println(errorMessage);
                return false;
            }
        }
        System.out.println("Wrong message version received!");
        return false;
    }

    public static List<JobOpeningDto> listJobOpenings() throws IOException {
        List<JobOpeningDto> result = new ArrayList<>();

        sOut.write(MESSAGE_VERSION);
        sOut.write(MessageCodes.LIST_JOBOPENINGS_REQ.valueOf());
        writeEndOfMessage();

        if ((char) sIn.readByte() == MESSAGE_VERSION) {
            char code = (char) sIn.readByte();
            if (code == MessageCodes.LIST_JOBOPENINGS_RES.valueOf()) {
                while (true) {
                    int getDataLenL = sIn.readByte();
                    int getDataLenM = sIn.readByte();
                    int totalSize = getDataLenL + (getDataLenM * 256);
                    if (totalSize <= 0) {
                        break;
                    }
                    String message = new String(sIn.readNBytes(totalSize));

                    String[] fields = message.split(";");
                    String jobReference = fields[0];
                    String jobTitle = fields[1];
                    String activeDate = fields[2];
                    String applicants = fields[3];
                    JobOpeningDto jobOpeningDTO = new JobOpeningDto(jobReference, jobTitle, activeDate, applicants);
                    result.add(jobOpeningDTO);
                }
            } else if (code == MessageCodes.ERR.valueOf()) {
                int getDataLenL = sIn.readByte();
                int getDataLenM = sIn.readByte();
                int size = getDataLenL + getDataLenM * 256;
                String error = new String(sIn.readNBytes(size));
                readEndOfMessage();
                System.out.println(error);
            }
        }
        return result;
    }

    private static void writeEndOfMessage() throws IOException {
        sOut.write(0);
        sOut.write(0);
    }

    private static void readEndOfMessage() throws IOException {
        sIn.readByte();
        sIn.readByte();
    }
}