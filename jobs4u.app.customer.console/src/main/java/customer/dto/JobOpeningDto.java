package customer.dto;

public class JobOpeningDto {

    public String jobReference;

    public String jobTitle;
    public String activeDate; // used for the customer app
    public String applicants; // used for the customer app

    public JobOpeningDto(String jobReference, String jobTitle, String activeDate, String applicants) {
        this.jobReference = jobReference;
        this.jobTitle = jobTitle;
        this.activeDate = activeDate;
        this.applicants = applicants;
    }

    @Override
    public String toString() {
        return "Job Reference: " + jobReference +" | Job Title: " + jobTitle + " | Active since: " + activeDate + " | Total applicants: " + applicants;
    }
}
