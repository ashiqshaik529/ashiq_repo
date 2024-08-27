package com.loanprovider.customer.service;

import com.loanprovider.customer.model.Customer;
import com.loanprovider.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    // Save a new customer
    public Customer saveCustomer(Customer customer) {
        logger.info("Saving customer: {}", customer.getEmail());
        return customerRepository.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        logger.info("Fetching all customers");
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        logger.info("Fetching customer with ID: {}", id);
        return customerRepository.findById(id);
    }

    // Update an existing customer
    public Optional<Customer> updateCustomer(Long id, Customer customerDetails) {
        logger.info("Updating customer with ID: {}", id);
        return customerRepository.findById(id).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPassword(customerDetails.getPassword());
            customer.setGovernmentIdentityCard(customerDetails.getGovernmentIdentityCard());
            customer.setGovernmentIdentityCardNumber(customerDetails.getGovernmentIdentityCardNumber());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            customer.setCreatedAt(customerDetails.getCreatedAt());
            return customerRepository.save(customer);
        });
    }

    // Delete a customer by ID
    public boolean deleteCustomer(Long id) {
        logger.info("Deleting customer with ID: {}", id);
        return customerRepository.findById(id).map(customer -> {
            customerRepository.delete(customer);
            return true;
        }).orElse(false);
    }

    // Authenticate customer
    public boolean authenticateCustomer(String email, String password) {
        logger.info("Authenticating customer with email: {}", email);
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.isPresent() && customer.get().getPassword().equals(password);
    }
}
