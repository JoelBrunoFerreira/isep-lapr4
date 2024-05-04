package eapli.base.InterviewModelManagement.domain;

import eapli.base.InterviewModelManagement.dto.InterviewModelDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class InterviewModel implements AggregateRoot<Long>, DTOable<InterviewModelDTO> {
    @Id
    private long id;

    private InterviewModelFilePath filePath; //jar

    private InterviewModelTitle title;

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof InterviewModel)) {
            return false;
        }
        return id == ((InterviewModel) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public InterviewModelDTO toDTO() {
        return new InterviewModelDTO(id, title.toString(), filePath.toString());
    }
}
