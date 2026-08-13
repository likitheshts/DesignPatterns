package com.DesignPatterns.strategy;

public class PaymentService {

    PaymentStratergy paymentStratergy;

    PaymentService(PaymentStratergy paymentStratergy) {
        this.paymentStratergy = paymentStratergy;
    }

    public void pay(double amount) {
        paymentStratergy.pay(amount);
    }
}
