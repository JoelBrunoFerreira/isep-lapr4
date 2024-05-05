package eapli.base.jobApplication.dto;

import eapli.framework.representations.dto.DTO;
import lombok.Data;

import java.util.List;

@DTO
@Data
public class JobApplicationDTO {
    private long id;
    private List<String> files;
    public int rank;
    public String state;
    public int interviewGrade;
    public String candidateEmail;
    public String JobOpeningReference;

    public JobApplicationDTO(List<String> files, String candidateEmail, String jobOpeningReference) {
        this.files = files;
        this.candidateEmail = candidateEmail;
        this.JobOpeningReference = jobOpeningReference;
    }

    public JobApplicationDTO(long id, List<String> files, int rank, String state, int interviewGrade, String candidateEmail, String jobOpeningReference) {
        this.id = id;
        this.files = files;
        this.rank = rank;
        this.state = state;
        this.interviewGrade = interviewGrade;
        this.candidateEmail = candidateEmail;
        this.JobOpeningReference = jobOpeningReference;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public String getJobOpeningReference() {
        return JobOpeningReference;
    }
}
