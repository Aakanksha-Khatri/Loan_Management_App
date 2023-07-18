# Loan_Management_App
Created a loan management app with various validations

Problem Statement
There is a scenario where thousands of loans are flowing into one store, assume any way of
transmission of Loans. We need to create a one loan store, which store the loans in the following order: 

Loan ID Customer Id Lender Id   Amount Remaining Amount Payment Date Interest PerDay(%) Due Date    Penalty/Day(%Day)  Cancel
L1      C1          LEN1        10000  10000            05/06/2023   1                  05/07/2023  0.01%

There are couple of requirement/validation
1. The payment date can’t be greater than the Due Date. If its greater we have to reject the
Loan and thrown the exception
2. We need to write an aggregation on the remaining amount, Interest and Penalty Group by
Lender, Group by Interest and Group by Customer ID.
3. If the Loan crosses the due date, it should write an alert in the log message.


Service:  
http://localhost:8080/loan 
JSON to POST
{
    "loanId": "L1",
    "customerId": "C1",
    "lenderId": "LEN1",
    "amount": 1000,
    "remainingAmount": 500,
    "paymentDate": "2020-05-20",
    "interest": 1,
    "dueDate": "2024-06-11",
    "penalty": 1.0
}

