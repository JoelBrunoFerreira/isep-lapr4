package eapli.base.RecruitmentProcessManagement.domain;

import eapli.framework.domain.model.ValueObject;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@ToString
public class PhasePeriod implements ValueObject, Serializable {
    private LocalDate startDate;
    private LocalDate endDate;

    protected PhasePeriod(){
        this.startDate = null;
        this.endDate = null;
    }
    public PhasePeriod(LocalDate start, LocalDate end){
        this.startDate = start;
        this.endDate = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhasePeriod that = (PhasePeriod) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    public boolean isActive(LocalDate date) {
        return (this.startDate.isBefore(date)|| this.startDate.isEqual(date)) && (this.endDate.isAfter(date)||this.endDate.isEqual(startDate));
    }
}
