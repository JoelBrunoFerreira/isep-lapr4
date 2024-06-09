package candidate.presentation;

import candidate.application.ApplicationMonitorSvc;
import eapli.base.Application;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class CandidateMainMenu extends AbstractUI {
    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN_LABEL = "Return";
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int PREVIOUS_MENU = 4;
    private final ApplicationMonitorSvc svc =new ApplicationMonitorSvc();
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    private Menu buildMainMenu() {
        svc.startMonitoring();
        final Menu mainMenu = new Menu();
        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        mainMenu.addItem(OPTION_1, "Display Job Applications", new DisplayJobApplicationsUI()::show);
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAndAction("Thank you for using Jobs4U, goodbye!"));
        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        return mainMenu;
    }
    @Override
    public String headline() {
        return "Main Menu";
    }

}
