package eapli.base.customer.dto;

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
public class CustomerDTO {
    private String name;
    private String acronym;
    private String email;
    private String address;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

