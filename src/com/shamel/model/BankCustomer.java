package com.shamel.model;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private final String customerName;
    private final int customerId;
    private static int ID_maker = 10000;

    private List<BankAccount> accountList = new ArrayList<>();

    // The constructor for Bank customer.
    // Account list will be defensively deep-copied for data integrity purposes.

    public BankCustomer(String customerName, List<BankAccount> accountList) {
        this(customerName, ID_maker, accountList);
    }


    private BankCustomer(String customerName, int customerId, List<BankAccount> accountList) {

        this.customerName = customerName;
        this.customerId = ID_maker++;

//        this.accountList = accountList;

        accountList.forEach(account ->
                this.accountList.add(new BankAccount(account))
        );

    }

    @Override
    public String toString() {

        String s = String.join("", accountList.toString()).replace("[", "")
                .replace("]", "").replace(", ", "\n");

        return "%-10s%10s\n%s".formatted(customerName, "ID:" + customerId, s);
    }
}