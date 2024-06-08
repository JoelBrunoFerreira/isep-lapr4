package eapli.base.jobOpeningManagement.domain;


import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.domain.InterviewModelClass;
import eapli.base.interviewModelManagement.domain.InterviewModelTemplate;
import eapli.base.interviewModelManagement.domain.InterviewModelTitle;
import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.Phase;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.PhasePeriod;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.RecruitmentProcessPhase;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.domain.Customer;
import eapli.base.jobRequirementsManagement.domain.JobRequirementClass;
import eapli.base.jobRequirementsManagement.domain.JobRequirementTemplate;
import eapli.base.jobRequirementsManagement.domain.JobRequirementTitle;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
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
    @Getter
    private JobTitle jobTitle;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;


    @Getter
    @OneToMany
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "jobOpeningID", referencedColumnName = "id")
    private List<RecruitmentProcessPhase> recruitmentProcess;
    @ManyToOne
    private JobRequirement jobRequirement;

    @Getter
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

    public void updateJobOpening(String description, int numberVacancies, String jobOpeningAddress, String mode, String contractType, String jobTitle) {
        this.description = Description.valueOf(description);
        this.numberVacancies = new NumberVacancies(numberVacancies);
        this.jobOpeningAddress = new JobOpeningAddress(jobOpeningAddress);
        this.mode = WorkingMode.parse(mode);
        this.contractType = ContractType.parse(contractType);
        this.jobTitle = new JobTitle(jobTitle);
    }
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return this.jobReference;
    }


    @Override
    public JobOpeningDTO toDTO() {
        List<RecruitmentProcessPhaseDTO> phasesDTO = null;
        if (this.recruitmentProcess != null) {
            if (!this.recruitmentProcess.isEmpty()) {
                phasesDTO = new ArrayList<>();
                for (RecruitmentProcessPhase phase : this.recruitmentProcess) {
                    phasesDTO.add(phase.toDTO());
                }
            }
        }
        return new JobOpeningDTO(jobReference.getId(), description.toString(), numberVacancies.toString(), jobOpeningAddress.toString(), mode.toString(), contractType.toString(), jobTitle.toString(), recruitmentProcess == null ? "" : recruitmentProcess.toString(), jobRequirement == null ? "" : jobRequirement.toString(), interviewModel == null ? "" : interviewModel.toString(), this.status.toString(), phasesDTO);
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

    public void setupRecruitmentProcessPhases(List<RecruitmentProcessPhaseDTO> dtoList) {
        recruitmentProcess = new ArrayList<>();
        for (RecruitmentProcessPhaseDTO dto : dtoList) {
            Phase phase = Phase.parse(dto.getPhase());
            PhasePeriod phasePeriod = new PhasePeriod(dto.getStartDate(), dto.getEndDate());
            RecruitmentProcessPhase recruitmentProcessPhase = new RecruitmentProcessPhase(phase, phasePeriod, this.jobReference.getId());
            recruitmentProcess.add(recruitmentProcessPhase);
        }
        this.status = Status.ACTIVE;
        //setStatusByPhaseDates();
    }

    public void updateInterviewModel(InterviewModelDTO dto) {
        if (this.status.equals(Status.ACTIVE_ANALYSIS) || this.status.equals(Status.ACTIVE_RESULT) || this.status.equals(Status.COMPLETED)) {
            System.out.println("Cant add Interview model on the following phase " + this.status);
        } else {
            this.interviewModel = new InterviewModel(dto.getId(), new InterviewModelClass(dto.getClassName()), new InterviewModelTitle(dto.getTitle()), new InterviewModelTemplate(dto.getModel()));
        }
     }

    public void updateJobRequirement(JobRequirementDTO dto) {
        if (this.status.equals(Status.PENDING) || this.status.equals(Status.ACTIVE) || this.status.equals(Status.ACTIVE_PENDING) || this.status.equals(Status.ACTIVE_APPLICATION)) {
            this.jobRequirement = new JobRequirement(dto.getId(), new JobRequirementTitle(dto.getTitle()), new JobRequirementClass(dto.getClassName()), new JobRequirementTemplate(dto.getModel()));
        } else {
            System.out.println("Cant add Job Requirements on the following phase " + this.status);
        }
    }

    public boolean isPending() {
        return this.status.equals(Status.PENDING);
    }

    public boolean allActive() {
        return this.status.equals(Status.ACTIVE) || this.status.equals(Status.ACTIVE_APPLICATION) || this.status.equals(Status.ACTIVE_SCREENING) || this.status.equals(Status.ACTIVE_INTERVIEWS) || this.status.equals(Status.ACTIVE_ANALYSIS) || this.status.equals(Status.ACTIVE_RESULT);
    }

    public boolean isActive() {
        return this.status.equals(Status.ACTIVE);
    }

    public String activeSince() {
        return this.recruitmentProcess == null ? "" : this.recruitmentProcess.get(0).getPeriod().getStartDate().toString();
    }

    public boolean isActiveApplication() {
        return this.status.equals(Status.ACTIVE_APPLICATION);
    }

    public boolean isActiveScreening() {
        return this.status.equals(Status.ACTIVE_SCREENING);
    }

    public boolean isActiveInterview() {
        return this.status.equals(Status.ACTIVE_INTERVIEWS);
    }

    public boolean isActiveAnalysis() {
        return this.status.equals(Status.ACTIVE_ANALYSIS);
    }

    public boolean isActiveResult() {
        return this.status.equals(Status.ACTIVE_RESULT);
    }

    public boolean isCompleted() {
        return this.status.equals(Status.COMPLETED);
    }

    public boolean isManagedBy(SystemUser user) {
        return this.customerManager.equals(user);
    }

    public boolean hasInterviewModel() {
        return this.interviewModel != null;
    }


    public boolean hasRequirementSpecification() {
        return this.jobRequirement != null;
    }


    public InterviewModel interviewModel() {
        return interviewModel;
    }

    public void selectInterviewModel(InterviewModel interviewModel) {
        Preconditions.nonNull(interviewModel);
        this.interviewModel = interviewModel;
    }

    //chamar no final de activar/desactivar fases da jobOpening
    public void setStatusByPhaseDates() {
        if (!this.recruitmentProcess.isEmpty()) {
            LocalDate now = LocalDate.now();
            Phase activePhase = null;
            for (RecruitmentProcessPhase phase : recruitmentProcess) {
                if ((phase.getPeriod().getStartDate().isEqual(now) || phase.getPeriod().getStartDate().isBefore(now)) && (phase.getPeriod().getEndDate().isEqual(now) || phase.getPeriod().getEndDate().isAfter(now))) {
                    activePhase = phase.getPhase();
                    break;
                }
            }
            if (activePhase != null) {
                switch (activePhase) {
                    case Phase.APPLICATION -> this.status = Status.ACTIVE_APPLICATION;
                    case Phase.SCREENING -> this.status = Status.ACTIVE_SCREENING;
                    case Phase.INTERVIEWS -> this.status = Status.ACTIVE_INTERVIEWS;
                    case Phase.ANALYSIS -> this.status = Status.ACTIVE_ANALYSIS;
                    case Phase.RESULT -> this.status = Status.ACTIVE_RESULT;
                    default -> this.status = Status.COMPLETED;
                }
            }
        }
    }

    public void setStatusByMovingForwardPhase(String closePhase) {

        if (closePhase.equalsIgnoreCase(Status.COMPLETED.toString())) {
            this.status = Status.COMPLETED;
            System.out.println("Recruitment process completed!");

        } else if (!this.recruitmentProcess.isEmpty()) {

            Phase activePhase = null;
            for (RecruitmentProcessPhase phase : recruitmentProcess) {
                if (phase.getPhase().toString().equalsIgnoreCase(closePhase)) {
                    activePhase = phase.getPhase();
                    break;
                }
            }
            if (activePhase != null) {
                switch (activePhase) {
                    case Phase.APPLICATION -> this.status = Status.ACTIVE_APPLICATION;
                    case Phase.SCREENING -> this.status = Status.ACTIVE_SCREENING;
                    case Phase.INTERVIEWS -> this.status = Status.ACTIVE_INTERVIEWS;
                    case Phase.ANALYSIS -> this.status = Status.ACTIVE_ANALYSIS;
                    case Phase.RESULT -> this.status = Status.ACTIVE_RESULT;
                    default -> this.status = Status.ACTIVE;
                }
                System.out.println("[Phase successfully updated! It's now in " + activePhase.toString().toUpperCase() + " phase]");

            }
        }
    }

    public void setStatusByMovingtoPreviousPhase(String openPhase) {

        if (openPhase.equalsIgnoreCase(Status.COMPLETED.toString())) {
            this.status = Status.COMPLETED;
            System.out.println("Recruitment process completed!");

        } else if (!this.recruitmentProcess.isEmpty()) {

            Phase activePhase = null;
            for (RecruitmentProcessPhase phase : recruitmentProcess) {
                if (phase.getPhase().toString().equalsIgnoreCase(openPhase)) {
                    activePhase = phase.getPhase();
                    break;
                }
            }
            if (activePhase != null) {
                switch (activePhase) {
                    case Phase.APPLICATION -> this.status = Status.ACTIVE_APPLICATION;
                    case Phase.SCREENING -> this.status = Status.ACTIVE_SCREENING;
                    case Phase.INTERVIEWS -> this.status = Status.ACTIVE_INTERVIEWS;
                    case Phase.ANALYSIS -> this.status = Status.ACTIVE_ANALYSIS;
                    case Phase.RESULT -> this.status = Status.ACTIVE_RESULT;
                    default -> this.status = Status.ACTIVE;
                }
                System.out.println("[Phase successfully updated! It's now in " + activePhase.toString().toUpperCase() + " phase]");

            }
        }
    }

}
