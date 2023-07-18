package com.loanmanagment.loanapp.exception;

public class InvalidLoanDetails extends RuntimeException{

    private final String id;

    public InvalidLoanDetails(final String id){
        super("Invalid Details : " + id);
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
