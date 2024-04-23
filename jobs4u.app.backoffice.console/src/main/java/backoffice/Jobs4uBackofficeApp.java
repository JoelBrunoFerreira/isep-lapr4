package backoffice;

import backoffice.presentation.FrontMenu;
import eapli.base.app.common.console.BaseApplication;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

public class Jobs4uBackofficeApp extends BaseApplication {
    private Jobs4uBackofficeApp() {
        // private constructor to avoid instantiation
    }

    public static void main(String[] args) {
        new Jobs4uBackofficeApp().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        new FrontMenu().show();
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
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}
