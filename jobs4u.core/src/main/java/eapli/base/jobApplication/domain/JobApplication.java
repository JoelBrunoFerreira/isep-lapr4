package eapli.base.jobApplication.domain;


import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"candidateID", "jobReference"})})
public class JobApplication implements AggregateRoot<Long>, DTOable<JobApplicationDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private List<ApplicationFile> applicationFiles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status jobApplicationState;
    @Column(name = "JobRequirement")
    private RequirementAnswers requirementAnswers;
    private RequirementResult requirementResult;

    private InterviewSchedule interviewSchedule;
    @Column(name = "InterviewAnswers")
    @Getter
    private InterviewAnswers interviewAnswers;
    @Getter
    private InterviewResult interviewResult;
    @ManyToOne
    @JoinColumn(name = "candidateID")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "jobReference")
    private JobOpening jobOpening;
    private Rank rank;
    protected JobApplication() {
    }

    public JobApplication(List<ApplicationFile> applicationFiles, Candidate candidate, JobOpening jobOpening) {
        this.applicationFiles = applicationFiles;
        this.candidate = candidate;
        this.jobOpening = jobOpening;
        this.jobApplicationState = Status.ACTIVE_APPLICATION;
        this.requirementResult = new RequirementResult(false, "Pending");
        this.interviewAnswers = null;
        this.requirementAnswers = null;
    }

    public boolean saveInterviewModelAnswers(String answers) {
        if (this.jobApplicationState.equals(Status.ACTIVE_INTERVIEWS)){
            this.interviewAnswers = new InterviewAnswers(answers);
            System.out.println("Interview answers saved successfully.");
            return true;
        }
        else{
            System.out.println("Operation must be executed during interview phase.");
            return false;
        }
    }
    public boolean saveJobRequirementAnswers(String answers){
        if (this.jobApplicationState.equals(Status.ACTIVE_APPLICATION) || this.jobApplicationState.equals(Status.ACTIVE_SCREENING)){
            this.requirementAnswers = new RequirementAnswers(answers);
            System.out.println("Job Requirements answers saved successfully.");
            return true;
        }
        else{
            System.out.println("Operation must be executed during Application or Screening phases.");
            return false;
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof JobApplication)) {
            return false;
        }
        return id == ((JobApplication) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public JobApplicationDTO toDTO() {
        List<String> files = new ArrayList<>();
        for (ApplicationFile file : applicationFiles) {
            files.add(file.toString());
        }
        return new JobApplicationDTO(id,
                files,
                rank == null ? 0 : rank.valueOf(),
                jobApplicationState.toString(),
                interviewResult == null ? 0 : this.interviewResult.getGrade(),
                candidate.getEmail().toString(), jobOpening.getJobReference().toString(), requirementResult.isApproved());
    }

    public void setInterviewGrade(float interviewGrade) {
        this.interviewResult = new InterviewResult().valueOf(interviewGrade);
    }

    public void setRanking(int ranking) {
        this.rank = new Rank(ranking);
    }

    public boolean hasJobOpeningReference(String jobRefrence) {
        return this.jobOpening.getJobReference().equals(new JobReference(jobRefrence));
    }

    public boolean hasCandidateEmail(String email) {
        return this.candidate.getEmail().equals(new Email(email));
    }

    public void setInterviewSchedule(Calendar dateTime) {
        this.interviewSchedule = new InterviewSchedule(dateTime);
    }

    public void applicationPassedRequirements(String description) {
        this.requirementResult = new RequirementResult(true, description);
    }

    public void rankApplication(String rank) {
        if (rank == null) {
            throw new IllegalArgumentException();
        }
        this.rank = new Rank(Integer.parseInt(rank));
    }
    public Status jobApplicationState(){
        return this.jobApplicationState;
    }
}
