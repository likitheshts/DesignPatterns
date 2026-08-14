package com.DesignPatterns.Factory;

public class CardPayment implements Payment{
    @Override
    public boolean pay() {
        System.out.println("CARD");
        return false;
    }
}
