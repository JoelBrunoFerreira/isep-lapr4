package eapli.base.JobOpeningManagement.domain;


import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.RecruitmentProcessManagement.RecruitmentProcess;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.base.customer.domain.Customer;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class JobOpening implements AggregateRoot<JobReference>, DTOable<JobOpeningDTO>, Representationable {

    @EmbeddedId
    @GeneratedValue(generator = "code_id", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "code_id", type = JobOpeningIDGenerator.class)
    private JobReference jobReference;

    private Description description;
    private NumberVacancies numberVacancies;

    private JobOpeningAddress jobOpeningAddress;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkingMode mode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractType contractType;

    private JobTitle jobTitle;

    private RecruitmentProcess recruitmentProcess;
    private JobRequirement jobRequirement;

    private InterviewModel interviewModel;

    @ManyToOne
    @Getter
    private String customerAcronym;

    private String customerManager;

    //Adicionar referencia ao CustomerManager


    //Construtor

    protected JobOpening(){}

    public JobOpening(String description, int numberVacancies, String jobOpeningAddress, String mode, String contractType, String jobTitle, String customer, String customerManager) {
        this.description = Description.valueOf(description);
        this.numberVacancies = new NumberVacancies(numberVacancies);
        this.jobOpeningAddress = new JobOpeningAddress(jobOpeningAddress);
        this.mode = WorkingMode.valueOf(mode);
        this.contractType = ContractType.valueOf(contractType);
        this.jobTitle = new JobTitle(jobTitle);
        this.recruitmentProcess = null;
        this.jobRequirement = null;
        this.interviewModel = null;
        this.customerAcronym = customer;
        this.customerManager = customerManager;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return null;
    }

    @Override
    public <R> R buildRepresentation(RepresentationBuilder<R> builder) {
        return null;
    }

    @Override
    public JobOpeningDTO toDTO() {
        return new JobOpeningDTO(jobReference.getId(),description.toString(), numberVacancies.toString(),jobOpeningAddress.toString(),
                mode.toString(), jobTitle.toString(),contractType.toString(),jobRequirement.toString(),interviewModel.toString(),recruitmentProcess.toString());
    }
}
