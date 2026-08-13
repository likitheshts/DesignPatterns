package com.DesignPatterns.strategy;

public class DebitCard implements PaymentStratergy{

    @Override
    public void pay(double amount) {
        System.out.println("Debit Card payment done!!");
    }
}
