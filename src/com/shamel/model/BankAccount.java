package com.shamel.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {

    enum Type {
        CHECKING, SAVING
    }


    private final Type type;
    private double balance;

    // the transaction map collection for each customer's
    // account, mapped by each transaction id
    private Map<Long, Transaction> transactions;



    BankAccount(Type type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    BankAccount(BankAccount account){
        this(account.type, account.balance);
    }

    @Override
    public String toString() {
        return  "%1$tr %1$tF %2$-10s %3$-10.2f $".formatted( LocalDateTime.now(), type, balance);
    }
    
    // adding a method that allows the customer to perform a transaction from each account:
    public void commitTransaction(int routingNumber,int customerId, long transactionId
                                  , double transactionAmount){

        Transaction t = new Transaction( routingNumber,  customerId,
         transactionId,  transactionAmount);
        transactions.put(transactionId, t);
        adjustBalance(transactionAmount);

    }

    private void adjustBalance(double transactionAmount){
        balance = balance - transactionAmount;
    }

    // making a defensive copy of the customer's transactions:
    public Map<Long, Transaction> getTransactios() {
        Map<Long,Transaction> copyTransaction= new HashMap<>();
        getTransactios().forEach( (k,v)->
                copyTransaction.put(k,v)
        );

        return copyTransaction;
    }

    public Type getType() {
        return type;
    }
}
