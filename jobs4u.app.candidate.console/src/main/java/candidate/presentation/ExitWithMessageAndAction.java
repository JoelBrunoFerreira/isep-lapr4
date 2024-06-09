package candidate.presentation;

import candidate.application.ApplicationMonitorSvc;
import candidate.application.SrvProxy;
import eapli.framework.actions.Action;

public class ExitWithMessageAndAction implements Action {
    private final String message;
private final ApplicationMonitorSvc svc = new ApplicationMonitorSvc();
    public ExitWithMessageAndAction(String message) {
        this.message = message;
    }

    public boolean execute() {
        svc.stopMonitoring();
        SrvProxy.disconnect();
        System.out.println(this.message);
        return true;
    }
}
