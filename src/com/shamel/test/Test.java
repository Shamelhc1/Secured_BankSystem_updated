package com.shamel.test;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {

         System.out.println( "%1$tr %1$tF ".formatted( LocalDateTime.now()));

    }
}
