package eapli.base.jobOpeningManagement.domain;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum Status implements Serializable {
    PENDING("pending"),
    ACTIVE("active"), //when the jobopening has phases set up (dates)
    ACTIVE_PENDING("active_pending"), //active jobopening with phases, but still hasn't started
    ACTIVE_APPLICATION("active_application"), //when it's in application phase,
    ACTIVE_SCREENING("active_screening"),

    ACTIVE_INTERVIEWS("active_interviews"),

    ACTIVE_ANALYSIS("active_analysis"),
    ACTIVE_RESULT("active_result"),
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
