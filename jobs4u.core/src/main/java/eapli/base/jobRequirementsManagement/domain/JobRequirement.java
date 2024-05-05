package eapli.base.jobRequirementsManagement.domain;


import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class JobRequirement implements AggregateRoot<Long>, DTOable<JobRequirementDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private RequirementTitle requirementTitle;

    private RequirementClass className;

    protected JobRequirement() {
    }

    public JobRequirement(RequirementTitle requirementTitle, RequirementClass className) {
        this.requirementTitle = requirementTitle;
        this.className = className;
    }

    public JobRequirement(long id, RequirementTitle requirementTitle, RequirementClass className) {
        this.id = id;
        this.requirementTitle = requirementTitle;
        this.className = className;
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof JobRequirement)) {
            return false;
        }
        return id == ((JobRequirement) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public JobRequirementDTO toDTO() {
        return new JobRequirementDTO(id, requirementTitle.toString(), className.toString());
    }

    @Override
    public String toString() {
        return this.className.toString();
    }
}
