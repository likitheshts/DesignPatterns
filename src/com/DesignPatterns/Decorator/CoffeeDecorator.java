package com.DesignPatterns.Decorator;

public abstract class CoffeeDecorator implements Coffee{

    public Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee=coffee;
    }
}
