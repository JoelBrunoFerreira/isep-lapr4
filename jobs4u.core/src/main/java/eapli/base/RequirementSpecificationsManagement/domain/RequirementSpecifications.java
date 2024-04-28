package eapli.base.RequirementSpecificationsManagement.domain;

import eapli.base.RecruitmentProcessManagement.RecruitmentProcess;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.List;

@Entity
public class RequirementSpecifications implements DomainEntity<RecruitmentProcess>, Serializable {
    private List<JobRequirement> jobRequirements;
    @Id
    private Long id;

    protected RequirementSpecifications(){}
    public RequirementSpecifications(List<JobRequirement> jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public RecruitmentProcess identity() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
