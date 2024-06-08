package eapli.base.jobApplication.dto;

import eapli.framework.representations.dto.DTO;
import lombok.Data;
import lombok.Getter;

import java.util.Calendar;
import java.util.List;

@DTO
@Data
public class JobApplicationDTO implements Comparable<JobApplicationDTO>  {
    private long id;
    private List<String> files;
    public int rank;
    public String status;
    public float interviewGrade;
    @Getter
    public String candidateEmail;
    @Getter
    public String JobOpeningReference;
    public Calendar interviewSchedule;
    @Getter
    private boolean approved;

    public JobApplicationDTO(List<String> files, String candidateEmail, String jobOpeningReference) {
        this.files = files;
        this.candidateEmail = candidateEmail;
        this.JobOpeningReference = jobOpeningReference;
    }

    public JobApplicationDTO(long id, List<String> files, int rank, String status, float interviewGrade, String candidateEmail, String jobOpeningReference) {
        this.id = id;
        this.files = files;
        this.rank = rank;
        this.status = status;
        this.interviewGrade = interviewGrade;
        this.candidateEmail = candidateEmail;
        this.JobOpeningReference = jobOpeningReference;
        this.interviewSchedule = null;
    }
    public JobApplicationDTO(long id, List<String> files, int rank, String status, float interviewGrade, String candidateEmail, String jobOpeningReference, boolean requirementResult) {
        this.id = id;
        this.files = files;
        this.rank = rank;
        this.status = status;
        this.interviewGrade = interviewGrade;
        this.candidateEmail = candidateEmail;
        this.JobOpeningReference = jobOpeningReference;
        this.interviewSchedule = null;
        this.approved = requirementResult;
    }

    @Override
    public int compareTo(JobApplicationDTO o) {
        return Float.compare(this.interviewGrade, o.interviewGrade);
    }

    @Override
    public String toString() {
        return String.format("Candidate: %s | Job Opening: %s | State: %s | Approved Job Requirements: %s | Interview Schedule: %s | Interview Grade: | Rank: %s'",
                candidateEmail, getJobOpeningReference(), status, isApproved(), interviewSchedule, interviewGrade, rank);

    }
}
