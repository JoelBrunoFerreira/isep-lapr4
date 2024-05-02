package eapli.base.infrastructure.bootstrapers;


import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.customer.domain.Customer;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


public class JobsDataBootstrap implements Action {

    MasterUsersBootstrapper usersBootstrapper = new MasterUsersBootstrapper();
    JobsDataBootstrapService service = new JobsDataBootstrapService();

    @Override
    public boolean execute() {
        /*
        ---------------------------------------------------------------    Customers    --------------------------------------------------------------------------
         */
        System.out.println("Persisting customers");
        Customer meta = service.addCustomer("META", "mark.zuckerberg@meta.com", "California, Office 5");
        Customer tesla = service.addCustomer("TESLA", "elon.musk@tesla.com", "New York, office 1");
        Customer softwareMasters = service.addCustomer("SOFTWARE MASTERS", "software_m@sm.com", "London, office 2");
        Customer fcp = service.addCustomer("FCP", "vilas-boas@fcp.pt", "New York, office 1");

        /*
        -----------------------------------------------------    customer managers ---------------------------------------------------------------
         */

        System.out.println("Persisting customer managers");
        SystemUser sysCustomerManager = usersBootstrapper.registerCustomerManager("john_manager@jobs4u.com", "Pa$$word1",
                "john", "brown", "john_manager@jobs4u.com");

        SystemUser sysCustomerManager1 = usersBootstrapper.registerCustomerManager("john_manager1@jobs4u.com", "Pa$$word1",
                "John", "Brown", "john_manager1@jobs4u.com");

        SystemUser sysCustomerManager2 = usersBootstrapper.registerCustomerManager("jane_manager2@jobs4u.com", "Pa$$word2",
                "Jane", "Smith", "jane_manager2@jobs4u.com");

        SystemUser sysCustomerManager3 = usersBootstrapper.registerCustomerManager("peter_manager3@jobs4u.com", "Pa$$word3",
                "Peter", "Johnson", "peter_manager3@jobs4u.com");

        SystemUser sysCustomerManager4 = usersBootstrapper.registerCustomerManager("susan_manager4@jobs4u.com", "Pa$$word4",
                "Susan", "Davis", "susan_manager4@jobs4u.com");

        SystemUser sysCustomerManager5 = usersBootstrapper.registerCustomerManager("michael_manager5@jobs4u.com", "Pa$$word5",
                "Michael", "Wilson", "michael_manager5@jobs4u.com");

        SystemUser sysCustomerManager6 = usersBootstrapper.registerCustomerManager("emily_manager6@jobs4u.com", "Pa$$word6",
                "Emily", "Martinez", "emily_manager6@jobs4u.com");

        SystemUser sysCustomerManager7 = usersBootstrapper.registerCustomerManager("david_manager7@jobs4u.com", "Pa$$word7",
                "David", "Anderson", "david_manager7@jobs4u.com");

        SystemUser sysCustomerManager8 = usersBootstrapper.registerCustomerManager("lisa_manager8@jobs4u.com", "Pa$$word8",
                "Lisa", "Taylor", "lisa_manager8@jobs4u.com");

        SystemUser sysCustomerManager9 = usersBootstrapper.registerCustomerManager("kevin_manager9@jobs4u.com", "Pa$$word9",
                "Kevin", "Moore", "kevin_manager9@jobs4u.com");

        SystemUser sysCustomerManager10 = usersBootstrapper.registerCustomerManager("sarah_manager10@jobs4u.com", "Pa$$word10",
                "Sarah", "Walker", "sarah_manager10@jobs4u.com");




       /*  ---------------------------------------------------------------   JobOpenings    --------------------------------------------------------------------*/

        System.out.println("Persisting openings");
       JobOpening opening1 = service.addJobOpening("Front-end hero with lots of skills", 25, "Office1", "REMOTE", "FULL_TIME",
                "Front-end senior", meta, sysCustomerManager);

        JobOpening opening2 = service.addJobOpening("Data Wizard for Innovative Energy Solutions", 30, "California", "remote", "Full-time",
                "Data Analyst", tesla, sysCustomerManager1);

        JobOpening opening3 = service.addJobOpening("AI Architect for Next-Gen Software Revolution", 20, "London", "remote", "Part-time",
                "AI Architect", softwareMasters, sysCustomerManager2);

        JobOpening opening4 = service.addJobOpening("Soccer Analyst for Passionate Fans", 15, "Porto", "onsite", "Internship",
                "Soccer Analyst", fcp, sysCustomerManager3);

        JobOpening opening5 = service.addJobOpening("Eco-Friendly Transportation Innovator", 25, "New York", "onsite", "Full-time",
                "Transportation Engineer", tesla, sysCustomerManager4);

        JobOpening opening6 = service.addJobOpening("Virtual Reality Game Developer", 20, "London", "remote", "Full-time",
                "VR Developer", softwareMasters, sysCustomerManager5);

        JobOpening opening7 = service.addJobOpening("Creative Director for Sports Marketing", 15, "Porto", "hybrid", "Full-time",
                "Creative Director", fcp, sysCustomerManager6);

        JobOpening opening8 = service.addJobOpening("Blockchain Engineer for Finance Revolution", 30, "New York", "onsite", "Full-time",
                "Blockchain Engineer", tesla, sysCustomerManager7);

        JobOpening opening9 = service.addJobOpening("Cybersecurity Analyst for Cutting-Edge Protection", 25, "London", "remote", "Part-time",
                "Cybersecurity Analyst", softwareMasters, sysCustomerManager8);

        JobOpening opening10 = service.addJobOpening("Sports Science Researcher for Performance Enhancement", 20, "Porto", "onsite", "Full-time",
                "Sports Scientist", fcp, sysCustomerManager9);

        JobOpening opening11 = service.addJobOpening("Renewable Energy Engineer for Sustainable Solutions", 35, "California", "hybrid", "Full-time",
                "Renewable Energy Engineer", tesla, sysCustomerManager10);


        /*
         ----------------------------------------------------------------   Job Applications    -----------------------------------------------------------------
         */



        return true;
    }


}
