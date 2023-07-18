package com.loanmanagment.loanapp.Controller;

import com.loanmanagment.loanapp.Entity.Loan;
import com.loanmanagment.loanapp.Service.LoanService;
import com.loanmanagment.loanapp.exception.InvalidLoanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
     LoanService loanService;

    //1. The payment date can’t be greater than the Due Date. If its greater we have to reject the
    //Loan and thrown the exception
    @PostMapping("/loan")
    public ResponseEntity<String> LoanValidStore(@RequestBody Loan loan){

        // check if due date is after payment date
        if(loanService.isValid(loan) == true)
        {
            loanService.persist(loan);
        }
        else
        {
            //thows exception
            throw new InvalidLoanDetails(loan.getLoanId()+" Payment date is after the due date!!");
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/loan")
    public List<Loan> findAllLoans() {
        return loanService.findAll();
    }

    //2.We need to write an aggregation on the remaining amount, Interest and Penalty Group by
    //Lender, Group by Interest and Group by Customer ID.

}
