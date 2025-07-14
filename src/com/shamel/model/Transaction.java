package com.shamel.model;

public class Transaction {

    private final int routingNumber;
    private final int customerId;
    private final long transactionId;

    private final double transactionAmount;

    Transaction(int routingNumber, int customerId, long transactionId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

}

