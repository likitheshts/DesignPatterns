package com.DesignPatterns.Factory;

public class PaymentMain {
    public static void main(String[] args) {
        FactoryService factoryService = new FactoryService();
        Payment payment = factoryService.getPayment("sd");
        System.out.println(payment.pay());
    }
}
