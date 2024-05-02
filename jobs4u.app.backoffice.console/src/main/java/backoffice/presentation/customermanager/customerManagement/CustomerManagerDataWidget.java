package backoffice.presentation.customermanager.customerManagement;

import eapli.framework.io.util.Console;

public class CustomerManagerDataWidget {

    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public void show() {
        username = Console.readLine("Username (E-mail)");
        firstName = Console.readLine("First Name");
        lastName = Console.readLine("Last Name");
        email = username;
    }

    public String username() {
        return this.username;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String email() {
        return this.email;
    }
}
