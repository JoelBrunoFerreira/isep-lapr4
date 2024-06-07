package daemon;

import eapli.base.Application;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class SrvListener {
    static ServerSocket sock;

    public static void main(String args[]) throws Exception {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());

        Socket cliSock;
        try {
            sock = new ServerSocket(Application.settings().getPort());
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }
        while (true) {
            cliSock = sock.accept();
            new Thread(new SrvCliHandler(cliSock)).start();
        }
    }
}

