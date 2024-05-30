package candidate;

import candidate.application.SrvProxy;
import candidate.presentation.CandidateMainMenu;
import candidate.presentation.LoginUI;
import eapli.base.app.common.console.BaseApplication;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

public class Jobs4uCandidateApp extends BaseApplication {
    private Jobs4uCandidateApp() {
        // private constructor to avoid instantiation
    }


    public static void main(String[] args) {
        new Jobs4uCandidateApp().run(args);
    }

    @Override
    protected void configureAuthz() {

    }

    @Override
    protected void doMain(String[] args) {
        try {
            if (!SrvProxy.connect()) {
                System.out.println("Couldn't connect to server!");
                System.exit(1);
            }
            final boolean auth = new LoginUI().login();
            if (auth) {
                final var menu = new CandidateMainMenu();
                menu.mainLoop();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected String appTitle() {
        return """
                |       Jobs4u - Candidate App      |
                =====================================
                """;
    }

    @Override
    protected String appGoodbye() {
        return "    Thank you for using our App";
    }


    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}
