package eapli.base.customer.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class CustomerBuilder implements DomainFactory<Customer> {
  private SystemUser systemUser;
  private Address address;
  private Code code;

  public CustomerBuilder withSystemUser(final SystemUser systemUser) {
    this.systemUser = systemUser;
    return this;
  }

  public CustomerBuilder withAddress(final Address address) {
    this.address = address;
    return this;
  }

  public CustomerBuilder withAddress(final String address) {
    this.address = new Address(address);
    return this;
  }

  public CustomerBuilder withCode(final Code code) {
    this.code = code;
    return this;
  }

  public CustomerBuilder withCode(final String code) {
    this.code = Code.valueOf(code);
    return this;
  }

  @Override
  public Customer build() {
    return null;
  }
}
