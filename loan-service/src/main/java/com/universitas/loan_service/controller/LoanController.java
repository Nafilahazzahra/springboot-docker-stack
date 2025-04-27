package com.universitas.loan_service.controller;

import com.universitas.loan_service.model.Loan;
import com.universitas.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Endpoint: Ambil semua peminjaman
    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    // Endpoint: Ambil peminjaman berdasarkan ID
    @GetMapping("/{id}")
    public Optional<Loan> getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    // Endpoint: Ambil semua peminjaman berdasarkan user
    @GetMapping("/user/{userId}")
    public List<Loan> getLoansByUserId(@PathVariable Long userId) {
        return loanService.getLoansByUserId(userId);
    }

    // Endpoint: Tambah peminjaman baru
    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    // Endpoint: Perbarui peminjaman
    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        return loanService.updateLoan(id, loan);
    }

    // Endpoint: Hapus peminjaman
    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}

