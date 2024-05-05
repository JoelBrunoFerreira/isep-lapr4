package eapli.base.languageEngineer.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@DTO
@AllArgsConstructor
@NoArgsConstructor
public class LanguageEngineerDTO implements Serializable {
    private long id;
    private String name;
}