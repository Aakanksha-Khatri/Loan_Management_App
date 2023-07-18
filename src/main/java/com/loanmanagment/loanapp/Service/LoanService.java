package com.loanmanagment.loanapp.Service;

import com.loanmanagment.loanapp.Dao.LoanDao;
import com.loanmanagment.loanapp.Dao.LoanRepo;
import com.loanmanagment.loanapp.Entity.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
public class LoanService {

    private static final Logger log = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    LoanRepo loanRepo;

    public void persist(Loan loan) {
        loanRepo.save(loan);
        updateCancelFlagOfLoan();
    }

    public List<Loan> findAll() {
        return loanRepo.findAll();
    }

    public boolean isValid(Loan loan) {

        if(loan.getDueDate().isBefore(loan.getPaymentDate()))
            return false;

        return true;
    }

    //3.If the Loan crosses the due date, it should write an alert in the log message.
    public void updateCancelFlagOfLoan(){

        loanRepo.findAll().stream().forEach(t -> {
            if (validDueDate(t) == false) {
                t.setCancel("Y");
                log.info(" Loan due date has expired for loan ID : " + t.getLoanId());
                loanRepo.save(t);
            }
        });
    }

    private boolean validDueDate(Loan t) {

        if(t.getDueDate().isBefore(LocalDate.now()))
            return false;
        return true;
    }

}
