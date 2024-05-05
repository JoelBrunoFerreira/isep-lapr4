package eapli.base.JobOpeningManagement.RecruitmentProcessManagement.dto;

import eapli.framework.representations.dto.DTO;
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

    public void setRecruitmentProcessPhaseDates(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return phase;
    }
}
