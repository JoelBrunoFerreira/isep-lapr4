package eapli.base.jobOpeningManagement.domain;

import java.io.Serializable;


public enum Status implements Serializable {
    ACTIVE("active"),
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
