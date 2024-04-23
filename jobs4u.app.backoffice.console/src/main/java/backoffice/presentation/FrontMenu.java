package backoffice.presentation;

import eapli.framework.presentation.console.AbstractUI;

public class FrontMenu extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int LOGIN_OPTION = 1;
    private static final int SIGNUP_OPTION = 2;

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }
    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return "Jobs4u - Backoffice App";
    }
}
