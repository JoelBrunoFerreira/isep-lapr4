package eapli.base.candidate.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String username;
}
