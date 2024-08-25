package com.loanprovider.customer.service;

import com.loanprovider.customer.model.Customer;
import com.loanprovider.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save a new customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Update an existing customer
    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);  // Ensure the ID is set for the update
            Customer updatedCustomer = customerRepository.save(customer);
            return Optional.of(updatedCustomer);
        }
        return Optional.empty();
    }

    // Delete a customer by ID
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
