package com.loanprovider.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.loanprovider.loan.repository")
public class LoanServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoanServiceApplication.class, args);
    }
}
