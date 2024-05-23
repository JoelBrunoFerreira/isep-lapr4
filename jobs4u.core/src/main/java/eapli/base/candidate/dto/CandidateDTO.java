package eapli.base.candidate.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CandidateDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;

    @Override
    public String toString() {
        return String.format("Candidate: %s | Name: %s %s | Phone number: %s", username, firstName, lastName, phoneNumber);
    }
}
