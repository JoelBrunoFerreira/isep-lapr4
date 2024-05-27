package eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@DTO
@Getter
public class RecruitmentProcessPhaseDTO {
    private String phase;
    private LocalDate startDate;
    private LocalDate endDate;

    public RecruitmentProcessPhaseDTO(String phase) {
        this.phase = phase;
    }

    public RecruitmentProcessPhaseDTO(String phase, LocalDate startDate, LocalDate endDate) {
        this.phase = phase;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setRecruitmentProcessPhaseDates(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return phase;
    }

    public String toStringComplete() {
        return String.format("PHASE: %s \n   START DATE: %s      END DATE: %s", phase, startDate, endDate);
    }
}
