package eapli.base.interviewModelManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@NoArgsConstructor
public class InterviewModelDTO {
    private long id;
    private String className;
    private String title;
    private String model;

    public InterviewModelDTO(long id, String className, String title, String model) {
        this.id = id;
        this.className = className;
        this.title = title;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("Interview Model ID: %d, Title: %s\n", id, title.toString());
    }
}
