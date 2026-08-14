package com.DesignPatterns.Decorator;

public class AlmondMilkDecorator extends CoffeeDecorator{
    AlmondMilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 50;
    }
}
