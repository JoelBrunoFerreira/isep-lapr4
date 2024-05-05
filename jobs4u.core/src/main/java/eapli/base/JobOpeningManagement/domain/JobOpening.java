package eapli.base.JobOpeningManagement.domain;


import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.InterviewModelManagement.domain.InterviewModelClass;
import eapli.base.InterviewModelManagement.domain.InterviewModelTitle;
import eapli.base.InterviewModelManagement.dto.InterviewModelDTO;
import eapli.base.JobOpeningManagement.RecruitmentProcessManagement.domain.Phase;
import eapli.base.JobOpeningManagement.RecruitmentProcessManagement.domain.PhasePeriod;
import eapli.base.JobOpeningManagement.RecruitmentProcessManagement.domain.RecruitmentProcessPhase;
import eapli.base.JobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
public class JobOpening implements AggregateRoot<JobReference>, DTOable<JobOpeningDTO> {

    @EmbeddedId
    @GeneratedValue(generator = "code_id", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "code_id", type = JobOpeningIDGenerator.class)
    @Getter
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @OneToMany
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "jobOpeningID", referencedColumnName = "id")
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
        this.mode = WorkingMode.parse(mode);
        this.contractType = ContractType.parse(contractType);
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
    public JobOpeningDTO toDTO() {
        return new JobOpeningDTO(jobReference.getId(), description.toString(), numberVacancies.toString(), jobOpeningAddress.toString(),
                mode.toString(), contractType.toString(), jobTitle.toString(),
                recruitmentProcess == null ? "" : recruitmentProcess.toString(),
                jobRequirement == null ? "" : jobRequirement.toString(),
                interviewModel == null ? "" : interviewModel.toString(), this.status.toString());
    }

    public List<RecruitmentProcessPhaseDTO> getRecruitmentProcessPhases(boolean interview) {
        List<RecruitmentProcessPhaseDTO> result = new ArrayList<>();
        Phase[] phases = Phase.values();
        if (interview) {
            for (Phase phase : phases) {
                result.add(new RecruitmentProcessPhaseDTO(phase.toString()));
            }
        } else {
            for (Phase phase : phases) {
                if (phase != Phase.INTERVIEWS) {
                    result.add(new RecruitmentProcessPhaseDTO(phase.toString()));
                }
            }
        }
        return result;
    }

    public void setupRecruitmentProcessPhases(List<RecruitmentProcessPhaseDTO> dtoList){
        recruitmentProcess = new ArrayList<>();
        for (RecruitmentProcessPhaseDTO dto : dtoList){
            Phase phase = Phase.parse(dto.getPhase());
            PhasePeriod phasePeriod = new PhasePeriod(dto.getStartDate(), dto.getEndDate());
            RecruitmentProcessPhase recruitmentProcessPhase = new RecruitmentProcessPhase(phase,phasePeriod, this.jobReference.getId());
            recruitmentProcess.add(recruitmentProcessPhase);
        }
        //if (jobRequirement!=null && interviewModel!=null){
            this.status = Status.ACTIVE;
        //}
    }
   public void updateInterviewModel(InterviewModelDTO dto){
        this.interviewModel = new InterviewModel(dto.getId(), new InterviewModelClass(dto.getClassName()), new InterviewModelTitle(dto.getTitle()));
        //TODO phase triggered and job application status update
    }
    /*public void setJobRequirement(JobRequirementDTO dto){
        this.jobRequirement = new JobRequirement(new RequirementTitle(dto.getRequirementTitle()),new FileName(dto.getRequirementTitle()));
        //TODO phase triggered and job application status update
    }*/
    public boolean isActive() {
        return this.status.equals(Status.ACTIVE);
    }

    public boolean isPending() {
        return this.status.equals(Status.PENDING);
    }

    public boolean isCompleted() {
        return this.status.equals(Status.COMPLETED);
    }

    public boolean isManagedBy(SystemUser user) {
        return this.customerManager.equals(user);
    }
    public boolean hasInterviewModel(){
        return this.interviewModel != null;
    }
    public boolean hasRequirementSpecification(){
        return this.jobRequirement != null;
    }
}
