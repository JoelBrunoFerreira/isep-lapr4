package eapli.base.jobOpeningManagement.domain;

import java.io.Serializable;


public enum Status implements Serializable {
    ACTIVE("active"), //when the jobopening has phases set up (dates)
    ACTIVE_IMPENDING("impending"), //active jobopening with phases, but still hasn't started
    ACTIVE_APPLICATION("application"), //when it's in application phase
    ACTIVE_SCREENING("screening"),

    ACTIVE_INTERVIEW("interview"),

    ACTIVE_ANALYSIS("analysis"),
    ACTIVE_RESULT("result"),
    PENDING("pending"),
    COMPLETED("completed");

    private String description;
    Status(String description) {
        this.description = description;
    }

    public static Status parse(String status) {
        return Status.valueOf(status.trim().toUpperCase());
    }

    @Override
    public String toString() {
        return description;
    }
}
