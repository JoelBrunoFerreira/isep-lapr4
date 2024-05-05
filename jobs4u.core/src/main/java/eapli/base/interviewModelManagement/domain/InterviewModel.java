package eapli.base.interviewModelManagement.domain;

import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
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

    private InterviewModelClass className;

    private InterviewModelTitle title;

    @Override
    public String toString() {
        return "%ID: " + String.valueOf(id) + " Tilte: " + title;
    }

    protected InterviewModel() {
    }

    public InterviewModel(long id, InterviewModelClass className, InterviewModelTitle title) {
        this.id = id;
        this.className = className;
        this.title = title;
    }

    @Override
    public InterviewModelDTO toDTO() {
        return new InterviewModelDTO(id, className.toString(), title.toString());
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null){
            return false;
        } else if (!(other instanceof InterviewModel)) {
            return false;
        }
        return id ==((InterviewModel)other).id;
    }

    @Override
    public Long identity() {
        return null;
    }
    public InterviewModelPlugin buildPThelugin(){
        try{
            return (InterviewModelPlugin) java.lang.Class.forName(className.toString()).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            throw new IllegalStateException("Error loading the plugin!");
        }
    }
}
