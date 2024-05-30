package customer.presentation;

import customer.application.SrvProxy;
import eapli.framework.actions.Action;

public class ExitWithMessageAndAction implements Action {
    private final String message;

    public ExitWithMessageAndAction(String message) {
        this.message = message;
    }

    public boolean execute() {
        SrvProxy.disconnect();
        System.out.println(this.message);
        return true;
    }
}
