package com.DesignPatterns.strategy;

public class Payment {
    public static void main(String[] args) {

        PaymentService ps = new PaymentService(new DebitCard());
        ps.pay(200);
    }
}
