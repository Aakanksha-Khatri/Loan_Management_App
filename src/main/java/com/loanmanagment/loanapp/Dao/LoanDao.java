package com.loanmanagment.loanapp.Dao;

import com.loanmanagment.loanapp.Entity.Loan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public interface LoanDao {

    public  static Map<String, Loan> tradeMap =new ConcurrentHashMap<>();

    public void save(Loan loan);

    List<Loan> findAll();
}
