package eapli.base.JobOpeningManagement.domain;


import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity

public class JobOpening implements AggregateRoot<JobReference>, DTOable<JobOpeningDTO>, Representationable {

    @EmbeddedId
    @GeneratedValue(generator = "code_id", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "code_id", type = JobOpeningIDGenerator.class)
    private JobReference jobReference;
    private NumberVacancies numberVacancies;
    private Description description;
    private CompanyAddress companyAddress;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Mode mode;
    private Title title;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractType contractType;
    @ManyToOne
    private Customer customer;

    @OneToMany
    private RecruitmenProcess recProc;
    private List<JobOpeningPhase> jobOpeningPhases;
    @ManyToOne
    private JobRequirement jobRequirement;
    @ManyToOne
    private InterviewModel interviewModel;

    //Adicionar referencia ao CustomerManager

    //Mapeamento do objeto relacional (ORM)
    protected JobOpening() {
    }
    public CustomerDTO customerDTO(){
        return this.customer.toDTO();
    }
    public boolean isActiveAndBetweenDate(LocalDate startDate, LocalDate endDate){
        for(JobOpeningPhase phase : jobOpeningPhases){
            if(phase.isActive(startDate,endDate)){
                return true;
            }
        }
        return false;
    }

    public String getCustomerCode() {
        return customer.getCode();
    }

    //Construtor
    public JobOpening(String title, String description, String company, String companyAddress,
                      int numberVacancies, String mode, String contractType, Customer customer) {
        Preconditions.nonEmpty(title);
        Preconditions.nonEmpty(description);
        Preconditions.nonEmpty(company);
        Preconditions.nonEmpty(companyAddress);
        Preconditions.nonEmpty(mode);
        Preconditions.nonEmpty(contractType);
        Preconditions.nonNull(customer);
        Preconditions.nonNegative(numberVacancies);

        this.title = new Title(title);
        this.description = new Description(description);
        this.company = new Company(company);
        this.companyAddress = new CompanyAddress(companyAddress);
        this.numberVacancies = new NumberVacancies(numberVacancies);
        this.mode = Mode.parse(mode);
        this.contractType = ContractType.parse(contractType);
        this.customer = customer;
    }

//    public JobOpening(Company company, NumberVacancies numberVacancies,
//                      Description description, CompanyAddress companyAddress,
//                      Mode mode, Title title, ContractType contractType, Customer customer) {
//        this.company = company;
//        this.numberVacancies = numberVacancies;
//        this.description = description;
//        this.companyAddress = companyAddress;
//        this.mode = mode;
//        this.title = title;
//        this.contractType = contractType;
//        this.customer = customer;
//    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof JobOpening)) {
            return false;
        }
        return jobReference.equals(((JobOpening) other).jobReference);
    }

    @Override
    public JobReference identity() {
        return jobReference;
    }

    @Override
    public JobOpeningDTO toDTO() {
        List<String> phases = new ArrayList<>();
        for (JobOpeningPhase phase : jobOpeningPhases) {
            phases.add(phase.toString());
        }
        return new JobOpeningDTO(jobReference.getId(), phases,
                numberVacancies.toString(), description.toString(), companyAddress.toString(), mode.toString(),
                title.toString(), contractType.toString(), jobRequirement.toString(), interviewModel.toString());
    }

    @Override
    public <R> R buildRepresentation(RepresentationBuilder<R> builder) {
        return null;
    }
}
