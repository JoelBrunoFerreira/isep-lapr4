package eapli.base.app.common.console.presentation.customer;

import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.io.util.Console;

public class CustomerDataWidget {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String acronym;

    public void show() {
        username = Console.readLine("Username (E-mail):");
        password = BasePasswordPolicy.generatePassword();
        firstName = Console.readLine("Company Name:");
        lastName = firstName;
        email = username;
        address = Console.readLine("Address:");
        acronym = Console.readLine("Acronym:");
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
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

    public String address() { return this.address;}

    public String acronym() {
        return this.acronym;
    }

}
