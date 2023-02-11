package edu.isu.cs2263.lab03.prob05;

public class Customer {
    private String firstName;
    private String lastName;
    private String custNumber;
    private double balance = 0;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
