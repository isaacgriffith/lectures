package edu.isu.cs2263.lab03.prob05;

// This is code for a simple customer accounts system.
public class Account {
    private String acctId;
    private Customer customer;
    private Transaction[] transactions;

    public void deposit(double amount) { // ...
    }

    public void withdraw(double amount) { // ...
    }

    public double getBal() { // ...
    }

    public String getAcctId() { // ...
    }

    public void printStatement() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
