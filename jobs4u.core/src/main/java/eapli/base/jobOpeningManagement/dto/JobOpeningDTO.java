package eapli.base.jobOpeningManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DTO
@Getter
@AllArgsConstructor
public class JobOpeningDTO {
    public String jobReference;
    public String description;
    public String numberVacancies;
    public String jobOpeningAddress;
    public String mode;
    public String contractType;
    public String jobTitle;
    public String recruitmentProcess;
    public String jobRequirement;
    public String interviewModel;
    public String status;

    /*public JobOpeningDTO(String jobReference, String description, String numberVacancies, String jobOpeningAddress, String mode, String jobTitle, String contractType, String jobRequirement, String interviewModel, String recruitmentProcess, String status) {
        this.jobReference = jobReference;
        this.description = description;
        this.numberVacancies = numberVacancies;
        this.jobOpeningAddress = jobOpeningAddress;
        this.mode = mode;
        this.jobTitle = jobTitle;
        this.contractType = contractType;
        this.jobRequirement = jobRequirement;
        this.interviewModel = interviewModel;
        this.recruitmentProcess = recruitmentProcess;
        this.status = status;
    }
*/
    @Override
    public String toString() {
        return String.format("Job Reference: %s | Job Title: %s | Desc.: %s | Contract Type: %s | Mode: %s | Vacancies: %s |  Address: %s | Rec. Process: %s | Requirements: %s | Interview: %s | Status: %s",
                jobReference, jobTitle, description, contractType, mode, numberVacancies,
                jobOpeningAddress, recruitmentProcess, jobRequirement, interviewModel, status);
    }
}

