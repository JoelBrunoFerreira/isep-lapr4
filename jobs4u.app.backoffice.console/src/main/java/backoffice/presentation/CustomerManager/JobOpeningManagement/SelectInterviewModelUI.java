package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.InterviewModelManagement.application.SelectInterviewModelController;
import eapli.framework.presentation.console.AbstractUI;

public class SelectInterviewModelUI extends AbstractUI {
    private SelectInterviewModelController controller = new SelectInterviewModelController();
    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
