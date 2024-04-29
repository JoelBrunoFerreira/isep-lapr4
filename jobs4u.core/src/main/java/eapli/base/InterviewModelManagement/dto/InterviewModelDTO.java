package eapli.base.InterviewModelManagement.dto;

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
    private String fileName;
    private String title;
}
