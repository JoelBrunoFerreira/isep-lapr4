package eapli.base.RecruitmentProcessManagement.domain;

import eapli.base.RecruitmentProcessManagement.domain2.PhasePeriod;
import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Phase implements ValueObject, Serializable {
    private final Phases phase;
    private PhasePeriod phasePeriod;

    protected Phase(){
        this.phase = null;
    }
    public Phase(Phases phase, PhasePeriod phasePeriod) {
        this.phase = phase;
        this.phasePeriod = phasePeriod;
    }
}
