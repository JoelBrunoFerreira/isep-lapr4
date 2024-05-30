package customer;

import customer.application.SrvProxy;
import customer.presentation.CustomerMainMenu;
import customer.presentation.LoginUI;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import eapli.framework.io.util.Console;

import java.io.IOException;

public class Jobs4uCustomerApp extends BaseApplication {
    private Jobs4uCustomerApp() {
    }

    public static void main(String[] args) {
        new Jobs4uCustomerApp().run(args);
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
                final var menu = new CustomerMainMenu();
                menu.mainLoop();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected String appTitle() {
        return """
                |       Jobs4u - Customer App      |
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
