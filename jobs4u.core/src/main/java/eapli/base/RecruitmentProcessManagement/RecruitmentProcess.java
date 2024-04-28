package eapli.base.RecruitmentProcessManagement;

import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class RecruitmentProcess implements DomainEntity<RecruitmentProcess>, Serializable {
    @Id
    private Long id;
    @OneToMany
    private List<Phase> phasesList;
    public RecruitmentProcess(List<Phase> phases) {
        this.phasesList = phases;
    }

    protected RecruitmentProcess() {

    }

    @Override
    public RecruitmentProcess identity() {
        return null;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(RecruitmentProcess other) {
        return DomainEntity.super.compareTo(other);
    }

    public void setId(Long id) {
        this.id = id;
    }

}
