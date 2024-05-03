package eapli.base.JobApplication.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@DTO
@Data
public class JobApplicationDTO {
    private long id;
    private List<String> files;
    private int rank;
    private String state;
    private int interviewGrade;
    private String candidateEmail;
    private String JobOpeningReference;

    public JobApplicationDTO(List<String> files, String candidateEmail, String jobOpeningReference) {
        this.files = files;
        this.candidateEmail = candidateEmail;
        JobOpeningReference = jobOpeningReference;
    }

    public JobApplicationDTO(long id, List<String> files, int rank, String state, int interviewGrade, String candidateEmail, String jobOpeningReference) {
        this.id = id;
        this.files = files;
        this.rank = rank;
        this.state = state;
        this.interviewGrade = interviewGrade;
        this.candidateEmail = candidateEmail;
        JobOpeningReference = jobOpeningReference;
    }
}
