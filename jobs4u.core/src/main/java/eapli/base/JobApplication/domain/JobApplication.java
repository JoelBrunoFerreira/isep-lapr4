package eapli.base.JobApplication.domain;


import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.candidate.domain.Candidate;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class JobApplication implements AggregateRoot<Long>, DTOable<JobApplicationDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private List<ApplicationFile> applicationFiles;
    private Rank rank;
    private State state;
    private InterviewGrade interviewGrade;
    @OneToOne
    private Candidate candidate;
    @OneToOne
    private JobOpening jobOpening;

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof JobApplication)) {
            return false;
        }
        return id == ((JobApplication) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public JobApplicationDTO toDTO() {
        List<String> files = new ArrayList<>();
        for (ApplicationFile file : applicationFiles) {
            files.add(file.toString());
        }
        return new JobApplicationDTO(id,files,rank.valueOf(),state.toString(),Integer.parseInt(interviewGrade.toString()));
    }
}
