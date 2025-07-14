package com.shamel.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {

    enum Type {
        CHECKING, SAVING
    }

    private Map<Long, Transaction> transactios;

    private final Type type;
    private double initialAmount;

    BankAccount(Type type, double initialAmount) {
        this.type = type;
        this.initialAmount = initialAmount;
    }

    BankAccount(BankAccount account){
        this(account.type, account.initialAmount);
    }

    @Override
    public String toString() {
        return  "%1$tr %1$tF %2$-10s %3$-10.2f $".formatted( LocalDateTime.now(), type, initialAmount);
    }

    // making a defensive copy of the customer's transactions:
    public Map<Long, Transaction> getTransactios() {
        Map<Long,Transaction> copyTransaction= new HashMap<>();
        getTransactios().forEach( (k,v)->
                copyTransaction.put(k,v)
        );

        return copyTransaction;
    }

    // adding a method that allows the customer to perform a transaction from each account:

    public void commitTransaction(int routingNumber, int customerId,
                                  long transactionId, double transactionAmount){

        Transaction t = new Transaction( routingNumber,  customerId,
         transactionId,  transactionAmount);
        transactios.put(transactionId, t);
        adjustBalance(transactionAmount);

    }

    private void adjustBalance(double transactionAmount){
        initialAmount = initialAmount - transactionAmount;
    }

}
