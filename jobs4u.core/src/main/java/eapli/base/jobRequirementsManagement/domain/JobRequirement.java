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

    @Column(name = "Title")
    private JobRequirementTitle jobRequirementTitle;

    @Column(name = "Class")
    private JobRequirementClass jobRequirementClass;

    private JobRequirementTemplate jobRequirementTemplate;
    protected JobRequirement() {
    }
//TODO NEW...
    public JobRequirement(long id, JobRequirementTitle jobRequirementTitle, JobRequirementClass jobRequirementClass, JobRequirementTemplate jobRequirementTemplate) {
        this.id = id;
        this.jobRequirementTitle = jobRequirementTitle;
        this.jobRequirementClass = jobRequirementClass;
        this.jobRequirementTemplate = jobRequirementTemplate;
    }

    public JobRequirement(JobRequirementTitle jobRequirementTitle, JobRequirementClass jobRequirementClass, JobRequirementTemplate jobRequirementTemplate) {
        this.jobRequirementTitle = jobRequirementTitle;
        this.jobRequirementClass = jobRequirementClass;
        this.jobRequirementTemplate = jobRequirementTemplate;
    }

    //TODO OLD...
    public JobRequirement(Long id, JobRequirementTitle jobRequirementTitle, JobRequirementClass jobRequirementClass) {
        this.id = id;
        this.jobRequirementTitle = jobRequirementTitle;
        this.jobRequirementClass = jobRequirementClass;
        this.jobRequirementTemplate = null;
    }
    public JobRequirement(JobRequirementTitle requirementTitle, JobRequirementClass className) {
        this.jobRequirementTitle = requirementTitle;
        this.jobRequirementClass = className;
        this.jobRequirementTemplate = null;
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
        return new JobRequirementDTO(id, jobRequirementTitle.toString(), jobRequirementClass.toString());
    }

    @Override
    public String toString() {
        return this.jobRequirementClass.toString();
    }
}
