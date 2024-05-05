package eapli.base.JobOpeningManagement.RecruitmentProcessManagement.domain;

import eapli.base.JobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter

public class RecruitmentProcessPhase implements DomainEntity<Phase> {
    @EmbeddedId
    private RecruitmentProcessPhaseID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private final Phase phase;
    private final PhasePeriod period;


    public RecruitmentProcessPhase(Phase phase, PhasePeriod period, String jobOpeningReference) {
        this.phase = phase;
        this.period = period;
        this.id = new RecruitmentProcessPhaseID(phase.toString(), jobOpeningReference);
    }

    protected RecruitmentProcessPhase() {
        this.phase = null;
        this.period = null;
        this.id = null;
    }

    public boolean isActive(LocalDate date) {
        if (this.period == null) throw new AssertionError();
        return this.period.isActive(date);
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof RecruitmentProcessPhase)) {
            return false;
        }

        final RecruitmentProcessPhase that = (RecruitmentProcessPhase) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && period.equals(that.period);
    }


    @Override
    public String toString() {
        return "RecruitmentProcessPhase{" +
                "phase=" + phase +
                ", period=" + period +
                ", jobOpening_id='" + id + '\'' +
                '}';
    }

    public RecruitmentProcessPhaseDTO toDTO() {
        return new RecruitmentProcessPhaseDTO(getPhase().toString());
    }


    @Override
    public Phase identity() {
        return phase;
    }
}
