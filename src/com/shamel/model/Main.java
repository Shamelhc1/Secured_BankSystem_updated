package com.shamel.model;


import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Bank bmo = new Bank(new Random().nextInt());

        bmo.addCustomer("Donald Trump", 10000, 50000);
        bmo.addCustomer("Nikita Khrushchev", 10000, 50000);

        System.out.println(bmo);

        bmo.doTransaction("000001000000001", Bank.BankAccount.Type.CHECKING,
                1995);

        System.out.println("-".repeat(30));
        System.out.println(bmo);




    }


}