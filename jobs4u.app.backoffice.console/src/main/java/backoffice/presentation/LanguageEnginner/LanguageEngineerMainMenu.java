package backoffice.presentation.LanguageEnginner;

import backoffice.presentation.LanguageEnginner.PluginsManagement.AddPluginUI;
import eapli.base.Application;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;

import java.text.CompactNumberFormat;

public class LanguageEngineerMainMenu {
    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;


    public void buildLanguageEngineerManagerMenu() {
        System.out.println("Actions >");
        System.out.println("1. Deploy new plugin");
        String option = null;
        option = Console.readLine("");


        if(option.equals("1")){
            new AddPluginUI().show();
        }else{
            System.out.println("Bye, Bye");
            System.exit(0);
        }
    }
}
