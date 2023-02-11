package edu.isu.cs2235l20.credit;

import edu.isu.cs2235l20.credit.CreditCard;

public class PredatoryCreditCard extends CreditCard {

    private double apr;

    /**
     * Constructs a new credit card instance
     *
     * @param customer The name of the customer
     * @param bank     the name of the bank
     * @param account  the account identifier
     * @param limit    the credit limit
     * @param balance  the initial balance
     */
    public PredatoryCreditCard(String customer, String bank, String account, int limit, double balance, double apr) {
        super(customer, bank, account, limit, balance);
        this.apr = apr;
    }

    public void processMonth() {
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
    }

    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     *
     * @param price the amount to be charged
     * @return true if the charge was accepted; false otherwise
     */
    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess) {
            balance += 5;
        }
        return isSuccess;
    }
}
