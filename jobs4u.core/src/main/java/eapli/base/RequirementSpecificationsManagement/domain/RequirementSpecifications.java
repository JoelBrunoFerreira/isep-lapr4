package eapli.base.RequirementSpecificationsManagement.domain;

import eapli.base.RecruitmentProcessManagement.domain.RecruitmentProcess;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Entity
public class RequirementSpecifications implements DomainEntity<RecruitmentProcess>, Serializable {

    private List<JobRequirement> jobRequirements;
    @Id
    @Getter
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


}
