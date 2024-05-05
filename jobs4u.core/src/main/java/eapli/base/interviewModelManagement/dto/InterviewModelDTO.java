package eapli.base.interviewModelManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewModelDTO {
    private long id;
    private String className;
    private String title;

    @Override
    public String toString() {
        return String.format("Interview Model ID: %d, Title: %s\n", id, title.toString());
    }
}
