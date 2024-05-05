/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.persistence;

import eapli.base.InterviewModelManagement.repository.InterviewModelRepository;
import eapli.base.JobApplication.repository.JobApplicationRepository;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.jobRequirementsManagement.repository.JobRequirementRepository;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.customerManager.repository.CustomerManagerRepository;
import eapli.base.operator.repository.OperatorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    TransactionalContext newTransactionalContext();

    SignupRequestRepository signupRequests();

    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    // =========================================================================================================
    UserRepository systemUsers();

    UserRepository systemUsers(TransactionalContext autoTx);

    ClientUserRepository clientUsers(TransactionalContext autoTx);

    ClientUserRepository clientUsers();

    UserRepository users();

    UserRepository users(TransactionalContext autoTx);

    CandidateRepository candidates();

    CandidateRepository candidates(TransactionalContext autoTx);

    CustomerRepository customers();

    CustomerRepository customers(TransactionalContext autoTx);

    OperatorRepository operators();

    OperatorRepository operators(TransactionalContext autoTx);

    CustomerManagerRepository customerManagers();

    CustomerManagerRepository customerManagers(TransactionalContext autoTx);

    JobOpeningRepository jobOpenings();

    JobOpeningRepository jobOpenings(TransactionalContext autoTx);

    JobApplicationRepository jobApplications();

    JobApplicationRepository jobApplications(TransactionalContext autoTx);

//    RequirementsSpecificationImporterPluginRepository requirementsSpecificationImporterPlugins();

    JobRequirementRepository jobRequirements();

    InterviewModelRepository interviewModelRepository();
}
