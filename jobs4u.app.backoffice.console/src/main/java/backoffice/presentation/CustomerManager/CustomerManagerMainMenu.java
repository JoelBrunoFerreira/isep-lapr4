package backoffice.presentation.CustomerManager;

import backoffice.Jobs4uBackofficeApp;
import backoffice.presentation.CustomerManager.JobApplicationsManagement.ListJobApplicationsUI;
import backoffice.presentation.CustomerManager.JobApplicationsManagement.ScheduleInterviewUI;
import backoffice.presentation.CustomerManager.JobOpeningManagement.*;
import backoffice.presentation.CustomerManager.candidateManagement.DisplayRankedCandidatesUI;
import backoffice.presentation.CustomerManager.customerManagement.AddCustomerUI;
import backoffice.presentation.candidates.DisplayCandidateDataUI;
import backoffice.presentation.interviewModel.GenerateInterviewModelTemplateUI;
import eapli.base.Application;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;

import java.util.InputMismatchException;

public class CustomerManagerMainMenu {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_6 = 6;
    private static final int OPTION_7 = 7;
    private static final int OPTION_8 = 8;
    private static final int OPTION_9 = 9;
    private static final int PREVIOUS_MENU = 10;

    public Menu buildCustomerManagerMenu() {
        final Menu menu = new Menu("Actions >");
        final Menu customersMenu = new Menu("Customers >");
        //TODO customersMenu.addItem(OPTION_1, "List Customers", new ListJobOpeningsUI()::show);
        customersMenu.addItem(OPTION_1, "Register Customer", new AddCustomerUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            customersMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        customersMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu jobOpeningMenu = new Menu("Job Opening Management >");
        jobOpeningMenu.addItem(OPTION_1, "List Job Openings", new ListJobOpeningsUI()::show);
        jobOpeningMenu.addItem(OPTION_2, "Register Job Openings", new RegisterJobOpeningUI()::show);
        jobOpeningMenu.addItem(OPTION_3, "Edit Job Openings", new EditJobOpeningsUI()::show);
        jobOpeningMenu.addItem(OPTION_4, "Setup Recruitment Process Phases", new SetupRecruitmentPhasesUI()::show);
        jobOpeningMenu.addItem(OPTION_5, "Select Requirement Specifications", new SelectJobRequirementsUI()::show);
        jobOpeningMenu.addItem(OPTION_6, "Select an Interview Model", new SelectInterviewModelUI()::show);
        jobOpeningMenu.addItem(OPTION_7, "Generate interview template", new GenerateInterviewModelTemplateUI()::show);
        //TODO jobOpeningMenu.addItem(OPTION_8, "Generate Job Requirement template", new SelectInterviewModelUI()::show);
        jobOpeningMenu.addItem(OPTION_9, "Open or close phases of the process for a job opening", new OpenOrClosePhasesUI()::show);
        //
        // , "Generate Job Requirement template", new SelectInterviewModelUI()::show);

        if (!Application.settings().isMenuLayoutHorizontal())
            jobOpeningMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        jobOpeningMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu jobApplicationMenu = new Menu("Job Application Management >");
        jobApplicationMenu.addItem(OPTION_1, "List Job Applications", new ListJobApplicationsUI():: show);
        jobApplicationMenu.addItem(OPTION_2, "Schedule Interviews", new ScheduleInterviewUI():: show);
        if (!Application.settings().isMenuLayoutHorizontal())
            jobApplicationMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        jobApplicationMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu candidatesMenu = new Menu("Candidates >");
        candidatesMenu.addItem(OPTION_1, "Display Candidates", new DisplayCandidateDataUI()::show);
        //TODO candidatesMenu.addItem(OPTION_2, "Display Candidates Applications Customer", new RegisterJobOpeningUI()::show);
        candidatesMenu.addItem(OPTION_3, "Display Candidates Ranked", new DisplayRankedCandidatesUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            candidatesMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        candidatesMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        menu.addSubMenu(OPTION_1, customersMenu);
        menu.addSubMenu(OPTION_2, jobOpeningMenu);
        menu.addSubMenu(OPTION_3, jobApplicationMenu);
        menu.addSubMenu(OPTION_4, candidatesMenu);

        if (!Application.settings().isMenuLayoutHorizontal())
            menu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}

