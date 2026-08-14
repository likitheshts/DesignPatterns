package com.DesignPatterns.Factory;

public class UPIPayment implements Payment{
    @Override
    public boolean pay() {
        System.out.println("UPI");
        return false;
    }
}
