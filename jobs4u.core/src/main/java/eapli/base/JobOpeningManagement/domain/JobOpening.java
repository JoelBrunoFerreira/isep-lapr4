package eapli.base.JobOpeningManagement.domain;


import eapli.base.InterviewModelManagement.InterviewModel;
import eapli.base.RecruitmentProcessManagement.RecruitmentProcess;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity

public class JobOpening implements AggregateRoot<JobReference>, DTOable<JobOpeningDTO>, Representationable {

    @EmbeddedId
    @GeneratedValue(generator = "code_id", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "code_id", type = JobOpeningIDGenerator.class)
    private JobReference jobReference;
    private NumberVacancies numberVacancies;
    private EmailAddress customerManager;
    private Description description;
    private JobOpeningAddress jobOpeningAddress;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkingMode mode;
    private JobTitle jobTitle;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractType contractType;

    private String customerAcronym;

    private RecruitmentProcess recruitmentProcess;

    private JobRequirement jobRequirement;

    private InterviewModel interviewModel;

    //Adicionar referencia ao CustomerManager

    //Mapeamento do objeto relacional (ORM)
    protected JobOpening() {
        this.customerManager = null;
        this.recruitmentProcess = null;
        this.interviewModel = null;
    }

    //Construtor

    public JobOpening(NumberVacancies numberVacancies, EmailAddress customerManager, Description description, JobOpeningAddress jobOpeningAddress, WorkingMode mode, JobTitle jobTitle, ContractType contractType, String customerAcronym) {
        Preconditions.nonEmpty(numberVacancies);
        Preconditions.nonEmpty(customerManager);
        Preconditions.nonEmpty(description);
        Preconditions.nonEmpty(jobOpeningAddress);
        Preconditions.nonEmpty(mode);
        Preconditions.nonEmpty(jobTitle);
        Preconditions.nonNull(contractType);
        Preconditions.nonNegative(customerAcronym);

        this.numberVacancies = numberVacancies;
        this.customerManager = customerManager;
        this.description = description;
        this.jobOpeningAddress = jobOpeningAddress;
        this.mode = mode;
        this.jobTitle = jobTitle;
        this.contractType = contractType;
        this.customerAcronym = customerAcronym;
    }


//    public JobOpening(Company company, NumberVacancies numberVacancies,
//                      Description description, CompanyAddress companyAddress,
//                      Mode mode, Title title, ContractType contractType, Customer customer) {
//        this.company = company;
//        this.numberVacancies = numberVacancies;
//        this.description = description;
//        this.companyAddress = companyAddress;
//        this.mode = mode;
//        this.title = title;
//        this.contractType = contractType;
//        this.customer = customer;
//    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof JobOpening)) {
            return false;
        }
        return jobReference.equals(((JobOpening) other).jobReference);
    }

    @Override
    public JobReference identity() {
        return jobReference;
    }

   /* @Override
    public JobOpeningDTO toDTO() {
        List<String> phases = new ArrayList<>();
        for (JobOpeningPhase phase : jobOpeningPhases) {
            phases.add(phase.toString());
        }
        return new JobOpeningDTO(jobReference.getId(), phases,
                numberVacancies.toString(), description.toString(), jobOpeningAddress.toString(), mode.toString(),
                jobTitle.toString(), contractType.toString(), jobRequirement.toString(), interviewModel.toString());
    }*/

    @Override
    public <R> R buildRepresentation(RepresentationBuilder<R> builder) {
        return null;
    }

    @Override
    public JobOpeningDTO toDTO() {
        return new JobOpeningDTO();
    }
}
