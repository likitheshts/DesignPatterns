package com.DesignPatterns.Factory;

public class FactoryService {

    public Payment getPayment(String paymentType) {
        switch (paymentType) {
            case "UPI":
                return new UPIPayment();

            case "CARD":
                return new CardPayment();

            default:
                return null;
        }
    }
}
