package com.shamel.model;

import java.time.LocalDateTime;
import java.util.*;

public class Bank {

    // the routing number is unique to each bank
    // this is logically a final and immutable field
    private final int routingNumber;

    //Transaction ids should be assigned by using the
    // lastTransactionId field on this instance of the bank.
    private long lastTransactionId;

    private static long transactionid_increment;

    // Bank customer collection is saved on a Map, with the
    // keys being the unique customerIdStrings:
    Map<String, BankCustomer> customers = new LinkedHashMap<>();

    Bank(int routingNumber){

        this.routingNumber = routingNumber;

    }

    void addCustomer(String name, double checkingInitialDeposit,
                     double savingInitialDeposit){

        BankAccount checking = new BankAccount(BankAccount.Type.CHECKING,checkingInitialDeposit );
        BankAccount savings = new BankAccount(BankAccount.Type.CHECKING,savingInitialDeposit );


        BankCustomer Customer = new BankCustomer(name, new ArrayList<>(List.of(
                checking,savings
        )));

        // adding the customer to the customer collection:
        // the customer ID is uniquely generated
        customers.put(Customer.getCustomerId(), Customer);

    }

    @Override
    public String toString() {

        String customersString= (customers == null) ? "" :  customers.toString().replace(", ","\n")
                .replace("[","").replace("]", "");

        return "Bank{" +
                "customers=" + customers +
                '}';
    }

    // The main method should not have access to the commit transaction code on the BankAccount itself.
    // You should only be able to perform a withdrawal or deposit of funds through the Bank Instance.

    // Note:
    // Although this BankAccount class is static, its transaction method is PRIVATE
    // and is only called from an instance method from the Bank class.
    //The only reason bankAccount was kept static is for ease of demonstration here.


    static class BankAccount {

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

        BankAccount(BankAccount account) {
            this(account.type, account.balance);
        }

        @Override
        public String toString() {
            return "%1$tr %1$tF %2$-10s %3$-10.2f $".formatted(LocalDateTime.now(), type, balance);
        }

        // adding a method that allows the customer to perform a transaction from each account:
        private void commitTransaction(int routingNumber, int customerId, long transactionId
                , double transactionAmount) {

            if (adjustBalance(transactionAmount)) {
                // creating the transaction:
                Transaction t = new Transaction(routingNumber, customerId,
                        transactionId, transactionAmount);

                // adding the transaction to the account's transaction collection
                transactions.put(transactionId, t);
            }
        }


        private boolean adjustBalance(double transactionAmount) {
            //A negative amount is a withdrawal, and a positive amount is a deposit.
            // The balance will not be allowed to go below zero

            if ((balance + transactionAmount) < 0) {
                System.out.println("Insuficient founds for this transaction.");
                return false;
            } else {
                balance = balance + transactionAmount;
                return true;
            }

        }

        // making a defensive copy of the customer's transactions:
        public Map<Long, Transaction> getTransactios() {
            Map<Long, Transaction> copyTransaction = new HashMap<>();
            getTransactios().forEach((k, v) ->
                    copyTransaction.put(k, v)
            );
            return copyTransaction;
        }

        public Type getType() {
            return type;
        }
    }

}
