package com.DesignPatterns.StateMachines;

public class VendingMachine {
    public VendingMachineState vendingMachineState;

    public VendingMachine() {
        this.vendingMachineState = new NoCoinState();
    }

    public void setState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void insertCoin() {
        vendingMachineState.insertCoin(this);
    }
    public void selectProduct() {
        vendingMachineState.selectProduct(this);
    }

    public void dispense() {
        vendingMachineState.dispense(this);
    }
}
