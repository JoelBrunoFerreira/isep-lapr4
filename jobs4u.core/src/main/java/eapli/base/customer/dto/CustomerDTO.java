package eapli.base.customer.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private long id;
    private String name;
    private String address;
    private String code;
    private String username;
}

