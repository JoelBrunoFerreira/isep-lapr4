package eapli.base.interviewModelManagement.domain;


import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class InterviewModel implements AggregateRoot<Long>, DTOable<InterviewModelDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Class")
    private InterviewModelClass className;
    @Column(name = "Title")
    private InterviewModelTitle title;
    @Getter
    @Column(name = "Model")
    private InterviewModelTemplate interviewModelTemplate;

    public InterviewModel(long id, InterviewModelClass className, InterviewModelTitle interviewModelTitle, InterviewModelTemplate interviewModelTemplate) {
        this.id = id;
        this.className = className;
        this.title = interviewModelTitle;
        this.interviewModelTemplate = interviewModelTemplate;
    }

    public InterviewModel(InterviewModelClass className, InterviewModelTitle interviewModelTitle, InterviewModelTemplate interviewModelTemplate) {
        this.className = className;
        this.title = interviewModelTitle;
        this.interviewModelTemplate = interviewModelTemplate;
    }
    public InterviewModel(long id, InterviewModelClass className, InterviewModelTitle interviewModelTitle) {
        this.id = id;
        this.className = className;
        this.title = interviewModelTitle;
        this.interviewModelTemplate = null;
    }

    public InterviewModel(InterviewModelClass className, InterviewModelTitle interviewModelTitle) {
        this.className = className;
        this.title = interviewModelTitle;
        this.interviewModelTemplate = null;
    }


    @Override
    public String toString() {
        return "%ID: " + String.valueOf(id) + " Tilte: " + title;
    }

    protected InterviewModel() {
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
    public InterviewModelPlugin buildThePlugin(){
        try{
            return (InterviewModelPlugin) java.lang.Class.forName(className.toString()).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            throw new IllegalStateException("Error loading the plugin!");
        }
    }

}
