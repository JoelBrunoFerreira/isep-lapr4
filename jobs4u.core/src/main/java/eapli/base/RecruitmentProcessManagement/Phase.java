package eapli.base.RecruitmentProcessManagement;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Phase implements ValueObject, Serializable {
    private final Phases phase;
    private Period period;

    protected Phase(){
        this.phase = null;
    }
    public Phase(Phases phase, Period period) {
        this.phase = phase;
        this.period = period;
    }
}
