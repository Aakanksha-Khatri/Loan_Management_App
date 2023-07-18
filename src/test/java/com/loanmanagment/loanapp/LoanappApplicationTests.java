package com.loanmanagment.loanapp;

import com.loanmanagment.loanapp.Controller.LoanController;
import com.loanmanagment.loanapp.Entity.Loan;
import com.loanmanagment.loanapp.exception.InvalidLoanDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LoanappApplicationTests {

	@Autowired
	LoanController loanController;
	@Test
	void contextLoads() {
	}

	//test to check if you can save details of loan
	@Test
	void ValidateAndStoreLoanDetails()
	{
		Loan l = createLoan("L1",1,LocalDate.now(), LocalDate.parse("2018-05-05"));
		ResponseEntity responseEntity = loanController.LoanValidStore(l);
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(),responseEntity);
		List<Loan> list = loanController.findAllLoans();
		Assertions.assertEquals(list.size(),1);
	}

	//check if the loan is Valid i.e. due date is after payment date
	//should throw and exception for invalid details
	@Test
	void ValidateForInvalidDueDate()
	{
		try{
			Loan l = createLoan("L1",1,LocalDate.parse("2018-05-05"), LocalDate.now() );
			ResponseEntity responseEntity = loanController.LoanValidStore(l);
			Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(),responseEntity);
		}
		catch (InvalidLoanDetails e)
		{
			Assertions.assertEquals("Invalid Details : L1 Payment date is after the due date!!", e.getMessage());
		}

	}

	//create a loan
	private Loan createLoan(String l1, int i, LocalDate now, LocalDate payment) {
		Loan l = new Loan();
		l.setLoanId(l1);
		l.setAmount(i);
		l.setDueDate(now);
		l.setInterest(1);
		l.setCustomerId("c1");
		l.setCancel("N");
		l.setLenderId("LEN1");
		l.setPaymentDate(payment);
		l.setPenalty(2);
		l.setRemainingAmount(12345);
		return l;
	}




}
