package com.shamel.model;

import java.util.ArrayList;
import java.util.List;

public final class BankCustomer {

    private final String customerName;
    private final int customerId;
    private static int ID_maker = 10000_00000;


    private List<Bank.BankAccount> accountList = new ArrayList<>();

    // The constructor for Bank customer.
    // Account list will be defensively deep-copied for data integrity purposes.
    // Package private constructors - codes in other packages must not instantiate a customer.

    BankCustomer(String customerName, List<Bank.BankAccount> accountList) {
        this(customerName, ID_maker, accountList);
    }

    BankCustomer(String customerName, int customerId, List<Bank.BankAccount> accountList) {

        this.customerName = customerName;
        this.customerId = ID_maker++;

//        this.accountList = accountList;

        accountList.forEach(account ->
                this.accountList.add(new Bank.BankAccount(account))
        );

    }

    @Override
    public String toString() {

        String s = String.join("", accountList.toString()).replace("[", "")
                .replace("]", "").replace(", ", "\n");

        return "%-10s%10s\n%s".formatted(customerName, "ID:" + customerId, s);
    }

    // Returns the customer id as a 15-digit string, with leading zeros:

    public String getCustomerId() {
        return "00000" +Integer.toString( customerId);
    }

    // Return a defensive copy of the accounts list:
    List<Bank.BankAccount> getAccountList() {
        List<Bank.BankAccount> copyList = new ArrayList<>();
        accountList.forEach(account ->
                        copyList.add(account)
        );

        return copyList;
    }
    
//    

     Bank.BankAccount getAccount(Bank.BankAccount.Type type){
        
        for (Bank.BankAccount account : accountList){
            if(account.getType().equals(type)){

                return account;
            }
        }
        return null;

    }


}