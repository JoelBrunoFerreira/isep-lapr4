package eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecruitmentProcessPhaseID implements Serializable, Comparable<RecruitmentProcessPhaseID> {
    private String id;
    private String jobOpeningID;

    protected RecruitmentProcessPhaseID(String id, String jobOpeningID) {
        this.id = id;
        this.jobOpeningID = jobOpeningID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecruitmentProcessPhaseID that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(jobOpeningID, that.jobOpeningID);
    }

    protected RecruitmentProcessPhaseID() {
    }

    private String getId() {
        return this.id;
    }

    private String getJobOpeningID() {
        return this.jobOpeningID;
    }


    @Override
    public int hashCode() {
        return (jobOpeningID.toUpperCase() + id.toUpperCase()).hashCode();
    }

    @Override
    public int compareTo(RecruitmentProcessPhaseID o) {
        return 0;
    }
}
