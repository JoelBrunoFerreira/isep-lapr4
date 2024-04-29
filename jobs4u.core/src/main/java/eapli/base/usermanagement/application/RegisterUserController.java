package eapli.base.usermanagement.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.Set;

public class RegisterUserController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Role[] getRoleTypes() {
        return BaseRoles.getAllValues();
    }

    public GeneralDTO registerNewUser(String username, String firstName, String lastName, String email, final Set<Role> roles) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        RegisterUserService registerUserService = new RegisterUserService();
        registerUserService.registerUser(username, firstName, lastName, email, roles);
        return registerUserService.getRegisteredSystemUserDTO();
    }
}
