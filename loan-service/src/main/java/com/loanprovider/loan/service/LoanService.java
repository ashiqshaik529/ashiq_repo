package com.loanprovider.loan.service;

import com.loanprovider.loan.model.LoanOption;
import com.loanprovider.loan.repository.LoanOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanOptionRepository loanOptionRepository;

    public LoanOption createLoanOption(LoanOption loanOption) {
        return loanOptionRepository.save(loanOption);
    }

    public LoanOption getLoanOption(Long id) {
        return loanOptionRepository.findById(id).orElse(null);
    }

    public List<LoanOption> getLoanOptionsByType(String typeOfLoan) {
        return loanOptionRepository.findAll().stream()
                .filter(option -> option.getTypeOfLoan().equalsIgnoreCase(typeOfLoan))
                .toList();
    }
}
