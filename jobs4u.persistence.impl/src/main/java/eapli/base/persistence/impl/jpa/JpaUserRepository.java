package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

class JpaUserRepository extends JpaAutoTxRepository<SystemUser, Username, Username>
        implements UserRepository {

    public JpaUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "username");
    }

    public JpaUserRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "username");
    }

    @Override
    public Iterable<SystemUser> findByActive(boolean active) {
        if (active) {
            return match("e.systemUser.active = true");
        } else {
            return match("e.systemUser.active = false");
        }
    }
}
