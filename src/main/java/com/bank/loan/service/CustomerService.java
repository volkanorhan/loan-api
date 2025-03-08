package com.bank.loan.service;

import com.bank.loan.model.Customer;
import com.bank.loan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setSurname(updatedCustomer.getSurname());
            existingCustomer.setCreditLimit(updatedCustomer.getCreditLimit());
            existingCustomer.setUsedCreditLimit(updatedCustomer.getUsedCreditLimit());
            return customerRepository.save(existingCustomer);
        }).orElse(null);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
