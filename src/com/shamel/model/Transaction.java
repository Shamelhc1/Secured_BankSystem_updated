package com.shamel.model;

public class Transaction {

    private  int routingNumber;
    private  int customerId;
    private  long transactionId;
    private  double transactionAmount;

    // This is the Transactions class, each BankAccount will
    // have a list of transactions assosiated with it.
    // A transaction is uniquely defined by its Transaction ID.


    Transaction(int routingNumber, int customerId,
                long transactionId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    // A transaction instance is uniquely defined by its Transaction ID.
    // Therefore, transaction IDs should be globally unique as per this logic.
    // At least, they should be uniquely assigned by the controlling code.

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;
        return getTransactionId() == that.getTransactionId();
    }

    @Override
    public int hashCode() {
        return 33* Long.hashCode(getTransactionId());
    }


    // Getter methods:

    public int getRoutingNumber() {
        return routingNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }


    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

}

