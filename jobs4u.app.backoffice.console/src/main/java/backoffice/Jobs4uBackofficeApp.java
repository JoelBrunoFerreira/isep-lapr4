package backoffice;

import backoffice.presentation.BackofficeFrontMenu;
import backoffice.presentation.MainMenu;
import eapli.base.app.bootstrap.BaseBootstrap;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

public class Jobs4uBackofficeApp extends BaseApplication {
    private Jobs4uBackofficeApp() {
        // private constructor to avoid instantiation
    }

    public static void main(String[] args) {
        //BaseBootstrap.main(args);
        new Jobs4uBackofficeApp().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        new BackofficeFrontMenu().show();
    }

    @Override
    protected String appTitle() {
        return """
                |      Jobs4u - Backoffice App      |
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
