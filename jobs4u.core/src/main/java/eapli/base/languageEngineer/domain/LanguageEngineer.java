package eapli.base.languageEngineer.domain;

import eapli.base.languageEngineer.dto.LanguageEngineerDTO;
import eapli.base.operator.domain.Name;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class LanguageEngineer implements AggregateRoot<Long>, DTOable<LanguageEngineerDTO> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private Name name;
        @OneToOne
        private SystemUser systemUser;

        protected LanguageEngineer() {
            // Empty constructor
        }

        public LanguageEngineer(SystemUser systemUser, String fName, String lName) {
            Preconditions.nonNull(systemUser);
            Preconditions.nonEmpty(fName);
            Preconditions.nonEmpty(lName);
            this.systemUser = systemUser;
            this.name = new Name(systemUser.name().firstName()+ " " + systemUser.name().lastName());
        }

        @Override
        public boolean sameAs(Object other) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof eapli.base.operator.domain.Operator)) {
                return false;
            }
            return id == ((eapli.base.operator.domain.Operator) other).identity();
        }

        @Override
        public Long identity() {
            return id;
        }

        @Override
        public LanguageEngineerDTO toDTO() {
            return new LanguageEngineerDTO(id, name.toString());
        }
}
