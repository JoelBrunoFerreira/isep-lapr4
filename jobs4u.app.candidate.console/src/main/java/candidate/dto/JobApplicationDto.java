package candidate.dto;

public class JobApplicationDto {
    public String jobReference;

    public String state;
    public String applicants; // used for the customer app

    public JobApplicationDto(String jobReference, String state, String applicants) {
        this.jobReference = jobReference;
        this.state = state;
        this.applicants = applicants;
    }

    @Override
    public String toString() {
        return "Job Reference: " + jobReference + " | State: " + state + " | Total applicants: " + applicants;
    }
}
