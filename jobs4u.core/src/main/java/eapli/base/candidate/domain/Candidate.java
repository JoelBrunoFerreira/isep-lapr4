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
    private FirstName firstName;
    private LastName lastName;
    private Email email;
    private PhoneNumber phoneNumber;
    @OneToOne
    private SystemUser systemUser;


    // Constructor
    // -------------------------------
    public Candidate(String firstName, String lastName,String email, String phoneNumber, final SystemUser systemUser) {
        this(firstName, lastName, email, phoneNumber);
        Preconditions.nonNull(systemUser);
        this.systemUser = systemUser;
    }

    public Candidate(final String firstName, final String lastName, final String email, final String phoneNumber) {
        Preconditions.nonEmpty(firstName);
        Preconditions.nonEmpty(lastName);
        Preconditions.nonEmpty(email);
        Preconditions.nonEmpty(phoneNumber);
        this.firstName = new FirstName(firstName);
        this.lastName = new LastName(lastName);
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }
    public Candidate() {
        // Empty constructor
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
        return new CandidateDTO(id, firstName.toString(), lastName.toString(), email.toString(), phoneNumber.toString(), systemUser.username().toString());
    }

    @Override
    public String toString() {
        return "Candidate: " +
                "id= " + id +
                " First name= " + firstName +
                " Last name= " + lastName +
                " Email= " + email +
                " Phone Number= " + phoneNumber +
                " System User= " + systemUser.username().toString()+ "\n";
    }
}
