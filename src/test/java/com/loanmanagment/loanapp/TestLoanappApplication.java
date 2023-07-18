package com.loanmanagment.loanapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestLoanappApplication {

	public static void main(String[] args) {
		SpringApplication.from(LoanappApplication::main).with(TestLoanappApplication.class).run(args);
	}

}
