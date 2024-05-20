package eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain;

import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
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
        return /*"RecruitmentProcessPhase{" +*/
                "PHASE: " + phase +
                        " - PERIOD: " + period.getStartDate().toString() + " to " + period.getEndDate().toString() /*+
                ", jobOpening_id='" + id.toString() + '\'' +
                '}'*/;
    }

    public RecruitmentProcessPhaseDTO toDTO() {
        return new RecruitmentProcessPhaseDTO(getPhase().toString(), getPeriod().getStartDate(), getPeriod().getEndDate());
    }

    @Override
    public Phase identity() {
        return phase;
    }
}
