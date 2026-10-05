package com.DesignPatterns.StateMachines;

public class VendingMachineService {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.dispense();
        machine.insertCoin();
        machine.selectProduct();
        machine.dispense();

        machine.dispense();
    }
}
