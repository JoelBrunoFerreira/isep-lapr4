package eapli.base.JobOpeningManagement.dto;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningDTO {
	private String id;
	private List<String> phases;
	private String numberVacancies;
	private String description;
	private String companyAddress;
	private String mode;
	private String title;
	private String contractType;
	private String jobRequirement;
	private String interviewModel;

	public JobOpeningDTO(String id, List<String> phases, String numberVacancies, String description,
						 String companyAddress, String mode, String title, String contractType,
						 String jobRequirement, String interviewModel) {
		this.id = id;
		this.phases = phases;
		this.numberVacancies = numberVacancies;
		this.description = description;
		this.companyAddress = companyAddress;
		this.mode = mode;
		this.title = title;
		this.contractType = contractType;
		this.jobRequirement = jobRequirement;
		this.interviewModel = interviewModel;
	}

	// Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getPhases() {
		return phases;
	}

	public void setPhases(List<String> phases) {
		this.phases = phases;
	}

	public String getNumberVacancies() {
		return numberVacancies;
	}

	public void setNumberVacancies(String numberVacancies) {
		this.numberVacancies = numberVacancies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getJobRequirement() {
		return jobRequirement;
	}

	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	public String getInterviewModel() {
		return interviewModel;
	}

	public void setInterviewModel(String interviewModel) {
		this.interviewModel = interviewModel;
	}

	// toString method
	@Override
	public String toString() {
		return "JobOpeningDTO{" +
				"id='" + id + '\'' +
				", phases=" + phases +
				", numberVacancies='" + numberVacancies + '\'' +
				", description='" + description + '\'' +
				", companyAddress='" + companyAddress + '\'' +
				", mode='" + mode + '\'' +
				", title='" + title + '\'' +
				", contractType='" + contractType + '\'' +
				", jobRequirement='" + jobRequirement + '\'' +
				", interviewModel='" + interviewModel + '\'' +
				'}';
	}

}
