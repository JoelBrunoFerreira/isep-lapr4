package eapli.base.JobOpeningManagement.domain;


import eapli.base.InterviewModelManagement.InterviewModel;
import eapli.base.RecruitmentProcessManagement.RecruitmentProcess;
import eapli.base.RequirementSpecificationsManagement.domain.JobRequirement;
import eapli.base.customerManager.domain.CustomerManager;
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
    private CustomerManager customerManager;
    private Description description;
    private JobOpeningAddress jobOpeningAddress;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkingMode mode;
    private JobTitle jobTitle;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractType contractType;

    private Customer customer;


    private RecruitmentProcess recruitmentProcess;

    private JobRequirement jobRequirement;

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

        this.jobTitle = new JobTitle(title);
        this.description = new Description(description);
        this.customer = new Customer(company);
        this.jobOpeningAddress = new JobOpeningAddress(companyAddress);
        this.numberVacancies = new NumberVacancies(numberVacancies);
        this.mode = WorkingMode.parse(mode);
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
                numberVacancies.toString(), description.toString(), jobOpeningAddress.toString(), mode.toString(),
                jobTitle.toString(), contractType.toString(), jobRequirement.toString(), interviewModel.toString());
    }

    @Override
    public <R> R buildRepresentation(RepresentationBuilder<R> builder) {
        return null;
    }
}
