package eapli.base.JobOpeningManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.Getter;


@DTO
@Getter
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

    public JobOpeningDTO(String jobReference, String description, String numberVacancies, String jobOpeningAddress, String mode, String jobTitle, String contractType, String jobRequirement, String interviewModel, String recruitmentProcess) {
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
    }

    @Override
    public String toString() {
        return "JobOpeningDTO{" +
                "jobReference='" + jobReference + '\'' +
                ", description='" + description + '\'' +
                ", numberVacancies='" + numberVacancies + '\'' +
                ", jobOpeningAddress='" + jobOpeningAddress + '\'' +
                ", mode='" + mode + '\'' +
                ", contractType='" + contractType + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", recruitmentProcess='" + recruitmentProcess + '\'' +
                ", jobRequirement='" + jobRequirement + '\'' +
                ", interviewModel='" + interviewModel + '\'' +
                '}';
    }
}

