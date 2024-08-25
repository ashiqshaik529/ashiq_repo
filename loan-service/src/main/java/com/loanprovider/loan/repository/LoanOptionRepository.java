package com.loanprovider.loan.repository;

import com.loanprovider.loan.model.LoanOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanOptionRepository extends JpaRepository<LoanOption, Long> {
    // Custom query methods (if needed) can be added here
}
