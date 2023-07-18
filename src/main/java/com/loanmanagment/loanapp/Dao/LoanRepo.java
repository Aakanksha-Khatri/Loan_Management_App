package com.loanmanagment.loanapp.Dao;

import com.loanmanagment.loanapp.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends JpaRepository<Loan , String> {
}
