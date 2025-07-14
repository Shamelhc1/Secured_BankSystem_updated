package com.shamel.model;

import java.time.LocalDateTime;

public class BankAccount {

    enum Type {
        CHECKING, SAVING
    }

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



}
