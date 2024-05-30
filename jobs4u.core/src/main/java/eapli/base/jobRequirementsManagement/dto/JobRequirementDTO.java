package eapli.base.jobRequirementsManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
public class JobRequirementDTO {
    private long id;
    private String title;
    private String className;
    private String model;

    public JobRequirementDTO(long id, String title, String className, String model) {
        this.id = id;
        this.title = title;
        this.className = className;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Job Requirement ID: " + id + " Title: " + title;
    }
}
