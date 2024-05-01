package eapli.base.RecruitmentProcessManagement.domain2;

import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class RecruitmentProcessPhase implements DomainEntity<Phase>{
    @Id
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private final Phase phase;
    private final PhasePeriod period;
    private String jobOpening_id;

    public RecruitmentProcessPhase(Phase phase, PhasePeriod period, String jobOpeningReference) {
        this.phase = phase;
        this.period = period;
        this.jobOpening_id = jobOpeningReference;
    }

    protected RecruitmentProcessPhase() {
        this.phase = null;
        this.period = null;
        this.jobOpening_id = "";
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
    public Phase identity() {
        return phase;
    }

    @Override
    public String toString() {
        return "RecruitmentProcessPhase{" +
                "phase=" + phase +
                ", period=" + period +
                ", jobOpening_id='" + jobOpening_id + '\'' +
                '}';
    }
}
