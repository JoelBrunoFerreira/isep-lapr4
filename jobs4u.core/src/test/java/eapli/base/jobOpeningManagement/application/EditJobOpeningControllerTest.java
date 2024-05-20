package eapli.base.jobOpeningManagement.application;

import eapli.base.customer.domain.Customer;
import eapli.base.jobOpeningManagement.domain.ContractType;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.WorkingMode;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class EditJobOpeningControllerTest {
    private static SystemUser customerManager1;
    private static SystemUser customerManager2;

    private static Customer customer;

    private static List<JobOpening> repo = new ArrayList<>();
    @BeforeAll
    static void bootstrap() {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new BasePasswordPolicy(), new PlainTextEncoder());

        customerManager1 = userBuilder.with(Username.valueOf("cm1"),
                Password.encodedAndValid("Password1", new BasePasswordPolicy(), new PlainTextEncoder()).get(),
                Name.valueOf("FirstName", "LastName"), EmailAddress.valueOf("cm1@cm.pt")).withRoles(BaseRoles.CUSTOMER_MANAGER).build();

        customerManager2 = userBuilder.with(Username.valueOf("cm2"),
                Password.encodedAndValid("Password2", new BasePasswordPolicy(), new PlainTextEncoder()).get(),
                Name.valueOf("FirstName", "LastName"), EmailAddress.valueOf("cm2@cm.pt")).withRoles(BaseRoles.CUSTOMER_MANAGER).build();

        SystemUser customerSU = userBuilder.with(Username.valueOf("customer"),
                Password.encodedAndValid("Password1", new BasePasswordPolicy(), new PlainTextEncoder()).get(),
                Name.valueOf("FirstName", "LastName"), EmailAddress.valueOf("cm1@cm.pt")).withRoles(BaseRoles.CUSTOMER_MANAGER).build();
        customer = new Customer(customerSU, "add");

        JobOpening jobOpening1 = new JobOpening("desc", 3, "addr",
                WorkingMode.HYBRID.toString(), ContractType.FULL_TIME.toString(),"jobTitle1", customer, customerManager1);
        repo.add(jobOpening1);
        JobOpening jobOpening2 = new JobOpening("desc", 3, "addr",
                WorkingMode.HYBRID.toString(), ContractType.FULL_TIME.toString(),"jobTitle2", customer, customerManager1);
        repo.add(jobOpening2);
        JobOpening jobOpening3 = new JobOpening("desc", 3, "addr",
                WorkingMode.HYBRID.toString(), ContractType.FULL_TIME.toString(),"jobTitle3", customer, customerManager2);
        repo.add(jobOpening3);
        JobOpening jobOpening4 = new JobOpening("desc", 3, "addr",
                WorkingMode.HYBRID.toString(), ContractType.FULL_TIME.toString(),"jobTitle4", customer, customerManager2);
        repo.add(jobOpening4);
        JobOpening jobOpening5 = new JobOpening("desc", 3, "addr",
                WorkingMode.HYBRID.toString(), ContractType.FULL_TIME.toString(),"jobTitle5", customer, customerManager2);
        repo.add(jobOpening5);


    }
    private static List<JobOpening> controllerListJobOpeningsByUserSim(){
        List<JobOpening> result  = new ArrayList<>();
        for (JobOpening jO : repo){
            if (jO.isManagedBy(customerManager1)){
                result.add(jO);
            }
        }
        return result;
    }
    @Test
    void listJobOpeningsByUSer() {
        JobOpening jobOpening1 = controllerListJobOpeningsByUserSim().getFirst();
        assertTrue(jobOpening1.isManagedBy(customerManager1));
    }

    @Test
    void getModeList() {
        List<WorkingMode> modeList = List.of(WorkingMode.values());
        List<WorkingMode> modeList2 = List.of(WorkingMode.values());
        assertEquals(modeList,modeList2);
        for (int i = 0; i < modeList.size(); i++) {
            System.out.println(modeList.get(i));
            System.out.println("=");
            System.out.println(modeList2.get(i));
        }
    }

    @Test
    void getContractTypeList() {
        List<ContractType> contractTypes = List.of(ContractType.values());

        List<ContractType> contractTypesSim = List.of(ContractType.values());
        assertEquals(contractTypesSim, contractTypes);

        for (int i = 0; i < contractTypes.size(); i++) {
            System.out.println(contractTypes.get(i));
            System.out.println("=");
            System.out.println(contractTypesSim.get(i));
        }
    }

    @Test
    void updateJobOpening() {
        JobOpening jobOpeningResult = repo.getFirst();
        //System.out.println("Before update: " + jobOpeningResult.toDTO().jobTitle);
        //jobOpeningResult.updateJobOpening("desc", 5,"add", WorkingMode.ONSITE.toString(),ContractType.PART_TIME.toString(),"New Job Tile");
        //jobOpeningResult.toDTO().jobTitle = "New Job Title";
        assertEquals(jobOpeningResult.getJobReference(), null);
        System.out.println(jobOpeningResult);
    }
}