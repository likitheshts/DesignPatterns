package com.DesignPatterns.StateMachines;

public class HasCoinState implements VendingMachineState{
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin already inserted");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        machine.setState(new DispenseState());
        System.out.println("Product selected");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Select the product");
    }
}
