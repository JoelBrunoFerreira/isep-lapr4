package eapli.base.candidate.domain;

import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
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


    // Constructor
    // -------------------------------
    public Candidate(String name, String email, String phoneNumber, final SystemUser systemUser) {
        this(name, email, phoneNumber);
        Preconditions.nonNull(systemUser);
        this.systemUser = systemUser;
    }

    public Candidate(final String name, final String email, final String phoneNumber) {
        Preconditions.nonEmpty(name);
        Preconditions.nonEmpty(email);
        Preconditions.nonEmpty(phoneNumber);
        this.name = new Name(name);
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }
    public Candidate() {
        // Empty constructor
    }

    public SystemUser user() {
        return this.systemUser;
    }

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
        return new CandidateDTO(id, name.toString(), email.toString(), phoneNumber.toString(), systemUser.username().toString());
    }
}
