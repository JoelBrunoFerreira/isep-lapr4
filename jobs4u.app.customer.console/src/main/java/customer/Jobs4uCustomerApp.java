package customer;

import customer.presentation.CustomerFrontMenu;
import eapli.base.Application;
import eapli.base.app.bootstrap.BaseBootstrap;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

public class Jobs4uCustomerApp extends BaseApplication {
    private Jobs4uCustomerApp() {
        // private constructor to avoid instantiation
    }

    public static void main(String[] args) {

        System.out.println(Application.settings().getIP_ADDRESS());
        //new Jobs4uCustomerApp().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        new CustomerFrontMenu().show();
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
    protected void configureAuthz() {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}
