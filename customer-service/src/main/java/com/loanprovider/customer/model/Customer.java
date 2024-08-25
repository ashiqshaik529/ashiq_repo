package com.loanprovider.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String governmentIdentityCard;
    private String governmentIdentityCardNumber;
    private String dateOfBirth;
    private String createdAt;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(Long id, String name, String email, String password, 
                    String governmentIdentityCard, String governmentIdentityCardNumber,
                    String dateOfBirth, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.governmentIdentityCard = governmentIdentityCard;
        this.governmentIdentityCardNumber = governmentIdentityCardNumber;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGovernmentIdentityCard() {
        return governmentIdentityCard;
    }

    public void setGovernmentIdentityCard(String governmentIdentityCard) {
        this.governmentIdentityCard = governmentIdentityCard;
    }

    public String getGovernmentIdentityCardNumber() {
        return governmentIdentityCardNumber;
    }

    public void setGovernmentIdentityCardNumber(String governmentIdentityCardNumber) {
        this.governmentIdentityCardNumber = governmentIdentityCardNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
