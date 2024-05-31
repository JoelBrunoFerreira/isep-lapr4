package eapli.base.jobRequirementsManagement.integration;

public class JobRequirementResult {
    private boolean valid;
    private String errorMessage;
    private double grade;

    protected JobRequirementResult() {
    }

    public JobRequirementResult(boolean valid, String errorMessage, double grade) {
        this.valid = valid;
        this.errorMessage = errorMessage;
        this.grade = grade;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
