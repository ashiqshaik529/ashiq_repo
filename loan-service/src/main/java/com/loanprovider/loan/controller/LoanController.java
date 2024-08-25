package com.loanprovider.loan.controller;

import com.loanprovider.loan.model.LoanOption;
import com.loanprovider.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan-options")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanOption> createLoanOption(@RequestBody LoanOption loanOption) {
        LoanOption createdOption = loanService.createLoanOption(loanOption);
        return ResponseEntity.status(201).body(createdOption);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanOption> getLoanOption(@PathVariable Long id) {
        LoanOption loanOption = loanService.getLoanOption(id);
        return loanOption != null ? ResponseEntity.ok(loanOption) : ResponseEntity.notFound().build();
    }

    @GetMapping("/type/{typeOfLoan}")
    public ResponseEntity<List<LoanOption>> getLoanOptionsByType(@PathVariable String typeOfLoan) {
        List<LoanOption> loanOptions = loanService.getLoanOptionsByType(typeOfLoan);
        return ResponseEntity.ok(loanOptions);
    }
}
