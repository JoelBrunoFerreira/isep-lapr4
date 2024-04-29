package eapli.base.customerManager.application;


import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.customerManager.dto.CustomerManagerDTO;
import eapli.base.customerManager.repository.CustomerManagerRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CustomerManagerService {
  private CustomerManagerRepository customerManagerRepository;

  public CustomerManagerService(CustomerManagerRepository customerManagerRepository) {
    this.customerManagerRepository = customerManagerRepository;
  }

//  public Iterable<CustomerManagerDTO> allTeachers() {
//    final Iterable<CustomerManager> customerManager = customerManagerRepository.findAll();
//    return convertToDto(customerManager);
//  }

//  public Collection<CustomerManagerDTO> allTeachersExceptFromCourse(Set<CustomerManager> teachersFromCourse) {
//    Set<CustomerManagerDTO> teachersExceptFromCourse = new HashSet<>();
//    final Iterable<CustomerManagerDTO> allTeachers = allTeachers();
//
//    for (CustomerManagerDTO customerManager : allTeachers)
//      for (CustomerManager t : teachersFromCourse)
//        if (!customerManager.getName().equals(t.taxPayerNumber()))
//          teachersExceptFromCourse.add(customerManager);
//
//    return teachersExceptFromCourse;
//  }

  public Iterable<CustomerManager> toDomain(Iterable<CustomerManagerDTO> teachersDTO) {
    Set<CustomerManager> customerManagers = new HashSet<>();
    for (CustomerManagerDTO customerManager : teachersDTO) {
      CustomerManager t = customerManagerRepository.ofIdentity(customerManager.getId()).orElseThrow();
      customerManagers.add(t);
    }
    return customerManagers;
  }

  public Iterable<CustomerManagerDTO> allCustomerManagers() {
    return null;
  }

//  private Iterable<CustomerManagerDTO> convertToDto(Iterable<CustomerManager> teachers) {
//    return StreamSupport.stream(teachers.spliterator(), true)
//        .map(CustomerManager::toDto)
//        .collect(Collectors.toUnmodifiableList());
//  }
}
