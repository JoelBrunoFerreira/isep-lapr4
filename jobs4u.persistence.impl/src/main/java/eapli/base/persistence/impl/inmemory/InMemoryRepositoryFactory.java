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
package eapli.base.persistence.impl.inmemory;

import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.customerManager.repository.CustomerManagerRepository;
import eapli.base.infrastructure.bootstrapers.Jobs4uBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.operator.repository.OperatorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    //Initialize a power user so that we can login.
    @Override
    public UserRepository users(final TransactionalContext tx) {
        final InMemoryUserRepository repo = new InMemoryUserRepository();
        Jobs4uBootstrapper.registerPowerUser(repo);
        return repo;
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

    // =========================================================================================================
    @Override
    public CandidateRepository candidates() {
        return null;
    }

    @Override
    public CandidateRepository candidates(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CustomerRepository customers() {
        return  new inMemoryCustomerRepository();
    }

    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public OperatorRepository operators() {
        return null;
    }

    @Override
    public OperatorRepository operators(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CustomerManagerRepository customerManagers() {
        return null;
    }

    @Override
    public CustomerManagerRepository customerManagers(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JobOpeningRepository jobOpenings() {
        return null;
    }


}
