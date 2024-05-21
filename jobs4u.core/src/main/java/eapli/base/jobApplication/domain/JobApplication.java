package eapli.base.jobApplication.domain;


import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.jobRequirementsManagement.domain.RequirementClass;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"candidateID","jobReference"})})
public class JobApplication implements AggregateRoot<Long>, DTOable<JobApplicationDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private List<ApplicationFile> applicationFiles;
    private Rank rank;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobApplicationState jobApplicationState;
    private RequirementResult requirementResult;
    private InterviewGrade interviewGrade;
    private InterviewSchedule interviewSchedule;
    @ManyToOne
    @JoinColumn(name = "candidateID")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "jobReference")
    private JobOpening jobOpening;

    protected JobApplication(){}

    public JobApplication(List<ApplicationFile> applicationFiles, Candidate candidate, JobOpening jobOpening) {
        this.applicationFiles = applicationFiles;
        this.candidate = candidate;
        this.jobOpening = jobOpening;
        this.jobApplicationState = JobApplicationState.RECEIVED;
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
        return new JobApplicationDTO(id, files,rank==null? 0 : rank.valueOf(), jobApplicationState.toString(),interviewGrade==null? 0 :Integer.parseInt(interviewGrade.toString()), candidate.getEmail().toString(),jobOpening.getJobReference().toString());
    }

    public void setInterviewGrade(int interviewGrade) {
        this.interviewGrade = new InterviewGrade();
    }

    public void setRanking(int ranking){
        this.rank = new Rank(ranking);
    }

    public boolean hasJobOpeningReference(String jobRefrence){
        return this.jobOpening.getJobReference().equals(new JobReference(jobRefrence));
    }
    public boolean hasCandidateEmail(String email){
        return this.candidate.getEmail().equals(new Email(email));
    }
}
