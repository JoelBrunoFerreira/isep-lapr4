package eapli.base.RecruitmentProcessManagement;

import eapli.framework.domain.model.ValueObject;

import java.time.LocalDate;

public class Period implements ValueObject  {
    private LocalDate startDate;
    private LocalDate endDate;

    protected Period(){}

}
