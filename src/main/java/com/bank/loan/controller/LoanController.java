package com.bank.loan.controller;

import com.bank.loan.model.Loan;
import com.bank.loan.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @GetMapping("/{customerId}")
    public List<Loan> getLoans(@PathVariable Long customerId) {
        return loanService.getLoansByCustomerId(customerId);
    }
}
