package com.shamel.model;

public class Transaction {

    private final int routingNumber;
    private final int customerId;
    private final long transactionId;
    private final double transactionAmount;

    // This is the Transactions class, each Bank account will
    // have a list of transactions assosiated with it.
    // A transaction is uniquely defined by its Transaction ID.


    Transaction(int routingNumber, int customerId, long transactionId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    // A transaction is uniquely defined by its Transaction ID.

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






}

