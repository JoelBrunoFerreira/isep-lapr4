package eapli.base.RequirementSpecificationsManagement.domain;

import eapli.base.RecruitmentProcessManagement.RecruitmentProcess;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.framework.domain.model.DomainEntity;

import java.io.Serializable;
import java.util.List;

public class RequirementSpecifications implements DomainEntity<RecruitmentProcess>, Serializable {
    private List<JobRequirement> jobRequirements;

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
}
