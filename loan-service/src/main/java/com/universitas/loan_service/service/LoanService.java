package com.universitas.loan_service.service;

import com.universitas.loan_service.model.Loan;
import com.universitas.loan_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public List<Loan> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long id, Loan updatedLoan) {
        return loanRepository.findById(id).map(loan -> {
            loan.setBookId(updatedLoan.getBookId());
            loan.setUserId(updatedLoan.getUserId());
            loan.setLoanDate(updatedLoan.getLoanDate());
            loan.setReturnDate(updatedLoan.getReturnDate());
            loan.setStatus(updatedLoan.getStatus());
            return loanRepository.save(loan);
        }).orElse(null);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
