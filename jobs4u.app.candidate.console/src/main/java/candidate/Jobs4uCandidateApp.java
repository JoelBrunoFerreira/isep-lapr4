package candidate;

import candidate.presentation.FrontMenu;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

public class Jobs4uCandidateApp extends BaseApplication {
    private Jobs4uCandidateApp() {
        // private constructor to avoid instantiation
    }

    public static void main(String[] args) {
        new Jobs4uCandidateApp().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        new FrontMenu().show();
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
    protected void configureAuthz() {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}
