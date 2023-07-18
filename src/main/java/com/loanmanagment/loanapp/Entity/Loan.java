package com.loanmanagment.loanapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Loans")
public class Loan {

    @Id
    private String LoanId;

    private String CustomerId;

    private String lenderId;

    private int amount;

    private int remainingAmount;

    private LocalDate paymentDate;

    private int interest;

    private LocalDate dueDate;

    private long penalty;

    private String cancel;

    public String getLoanId() {
        return LoanId;
    }

    public void setLoanId(String loanId) {
        LoanId = loanId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public long getPenalty() {
        return penalty;
    }

    public void setPenalty(long penalty) {
        this.penalty = penalty;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    @Override
    public String toString() {
        return "Loan {" +
                "Loan Id = " + LoanId +
                ", Customer Id = " + CustomerId +
                ", Lender Id = " + lenderId +
                ", Amount = " + amount +
                ", Remaining Amount = " + remainingAmount +
                ", Payment Date = " + paymentDate +
                ", Interest = " + interest +
                ", Due Date = " + dueDate +
                ", Penalty = " + penalty +
                ", Cancel = " + cancel +
                '}';
    }
}
