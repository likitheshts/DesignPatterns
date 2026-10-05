package com.DesignPatterns.StateMachines;

public class NoCoinState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        machine.setState(new HasCoinState());
        System.out.println("Coins inserted");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("Please insert coin first");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please insert coin first");
    }
}
