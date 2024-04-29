package eapli.base.usermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.representations.dto.GeneralDTO;
import lombok.Getter;

import java.util.Set;

@Getter
public class RegisterUserService {
    private final UserRepository repo;

    private String generatedPassword;
    private GeneralDTO registeredSystemUserDTO;
    private SystemUser registeredSystemUser;

    public RegisterUserService() {
        repo = PersistenceContext.repositories().users();
    }

    public RegisterUserService(TransactionalContext autoTx) {
        repo = PersistenceContext.repositories().users(autoTx);
    }

    public void registerUser(String username, String firstName, String lastName, String email, final Set<Role> roles) {
        // generate password
        generatedPassword = BasePasswordPolicy.generatePassword();

        // encode password
        Password encodedPassword = Password.encodedAndValid(generatedPassword, new BasePasswordPolicy(), new PlainTextEncoder()).get();

        // build SystemUser
        SystemUserBuilder userBuilder = new SystemUserBuilder(new BasePasswordPolicy(), new PlainTextEncoder());
        userBuilder.with(Username.valueOf(username), encodedPassword, Name.valueOf(firstName, lastName), EmailAddress.valueOf(email)).withRoles(roles);

        // save SystemUser
        registeredSystemUser = repo.save(userBuilder.build());

        registeredSystemUserDTO = registeredSystemUser.toDTO();
        // add to DTO password in plainText
        registeredSystemUserDTO.put("password", generatedPassword);
    }

}
