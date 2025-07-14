package com.shamel.model;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private final String customerName;
    private final int customerId;
    private List<BankAccount> accountList = new ArrayList<>();

    // The constructor for Bank customer.
    // Account list will be defensively deep-copied for data integrity purposes.

    public BankCustomer(String customerName, int customerId, List<BankAccount> accountList) {

        this.customerName = customerName;
        this.customerId = customerId;

//        this.accountList = accountList;

        accountList.forEach(
                account ->
                        accountList.add(new BankAccount(account))
        );

    }





}
