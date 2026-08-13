package com.DesignPatterns.strategy;

public class CreditCard implements PaymentStratergy{

    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment Done!!!");
    }
}
