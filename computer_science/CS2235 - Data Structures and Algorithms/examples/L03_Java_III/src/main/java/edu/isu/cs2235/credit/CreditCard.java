package edu.isu.cs2235l20.credit;

/**
 * A simple model for a consumer credit card
 *
 * @author Michael T Goodrich
 * @author Roberto Tamassia
 * @author Michael H Goldwasser
 */
public class CreditCard {

    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    /**
     * Constructs a new credit card instance
     * @param customer The name of the customer
     * @param bank the name of the bank
     * @param account the account identifier
     * @param limit the credit limit
     * @param balance the initial balance
     */
    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    /**
     * Constructs a new credit card instance with an initial balance of 0.0
     * @param customer The name of the customer
     * @param bank The name of the bank
     * @param account The account identifier
     * @param limit The credit limit
     */
    public CreditCard(String customer, String bank, String account, int limit) {
        this(customer, bank, account, limit, 0.0);
    }

    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     * @param price the amount to be charged
     * @return true if the charge was accepted; false otherwise
     */
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        }

        balance += price;
        return true;
    }

    /**
     * Processes customer payment that reduces balance
     * @param amount the amount of the payment made
     */
    public void makePayment(double amount) {
        balance -= amount;
    }

    /**
     * Prints a summary of the account
     */
    public void printSummary() {
        System.out.printf("Customer = %s\n", getCustomer());
        System.out.printf("Bank = %s\n", getBank());
        System.out.printf("Account = %s\n", getAccount());
        System.out.printf("Balance = %f\n", getBalance());
        System.out.printf("Limit = %d\n", getLimit());
    }
}
