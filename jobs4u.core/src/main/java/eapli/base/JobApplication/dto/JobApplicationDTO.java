package eapli.base.JobApplication.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDTO {
    private long id;
    private List<String> files;
    private int rank;
    private String state;
    private int interviewGrade;
}
