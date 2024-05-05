package eapli.base.jobRequirementsManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRequirementDTO {
    private long id;
    private String requirementTitle;
    private String fileName;
}
