package com.DesignPatterns.Decorator;

public class MilkDecorator extends CoffeeDecorator {


    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 10;
    }
}
