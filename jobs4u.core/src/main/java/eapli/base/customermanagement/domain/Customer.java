package eapli.base.customermanagement.domain;

import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.representations.dto.DTOable;

public class Customer implements AggregateRoot<EmailAddress>, DTOable<CustomerDTO> {

    private EmailAddress emailAddress;

    private Password password;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public EmailAddress identity() {
        return null;
    }

    @Override
    public CustomerDTO toDTO() {
        return null;
    }
}
