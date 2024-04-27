package eapli.base.candidate.domain;

import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Candidate implements AggregateRoot<Long>, DTOable<CandidateDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Name name;
    private Email email;
    private PhoneNumber phoneNumber;
    @OneToOne
    private SystemUser systemUser;

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Candidate)) {
            return false;
        }
        return id == ((Candidate) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public CandidateDTO toDTO() {
        return new CandidateDTO(id, name.toString(), email.toString(), phoneNumber.toString());
    }
}