package eapli.base.JobOpeningManagement.domain;


import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.RecruitmentProcessManagement.domain.RecruitmentProcess;
import eapli.base.RecruitmentProcessManagement.domain2.RecruitmentProcessPhase;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

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
    @Getter
    private Status status;
    @OneToMany
    @JoinColumn(name = "jobOpening_id", referencedColumnName = "id")
    private List<RecruitmentProcessPhase> recruitmentProcess;
    @ManyToOne
    private JobRequirement jobRequirement;

    @ManyToOne
    private InterviewModel interviewModel;

    @ManyToOne
    @Getter
    private Customer customer;

    @ManyToOne
    private SystemUser customerManager;

    protected JobOpening() {
    }

    public JobOpening(String description, int numberVacancies, String jobOpeningAddress, String mode, String contractType, String jobTitle, Customer customer, SystemUser customerManager) {
        this.description = Description.valueOf(description);
        this.numberVacancies = new NumberVacancies(numberVacancies);
        this.jobOpeningAddress = new JobOpeningAddress(jobOpeningAddress);
        this.mode = WorkingMode.valueOf(mode);
        this.contractType = ContractType.valueOf(contractType);
        this.jobTitle = new JobTitle(jobTitle);
        this.recruitmentProcess = null;
        this.jobRequirement = null;
        this.interviewModel = null;
        this.customer = customer;
        this.customerManager = customerManager;
        this.status = Status.PENDING;
    }

    public void changeStatus(Status status) {
        this.status = status;
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
        return new JobOpeningDTO(jobReference.getId(), description.toString(), numberVacancies.toString(), jobOpeningAddress.toString(),
                mode.toString(), jobTitle.toString(), contractType.toString(),
                jobRequirement == null ? "" : jobRequirement.toString(),
                interviewModel == null ? "" : interviewModel.toString(),
                recruitmentProcess == null ? "" : recruitmentProcess.toString());
    }

    public boolean isActive() {
        return this.status.equals(Status.ACTIVE);
    }
    public boolean isPending() {
        return this.status.equals(Status.PENDING);
    }

    public boolean isCompleted() {
        return this.status.equals(Status.COMPLETED);
    }
}
