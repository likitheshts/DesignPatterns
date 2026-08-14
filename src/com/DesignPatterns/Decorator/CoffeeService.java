package com.DesignPatterns.Decorator;

public class CoffeeService {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();

        System.out.println("coffe"+ coffee.getPrice());

        coffee = new MilkDecorator(coffee);

        System.out.println("milk" + coffee.getPrice());

        coffee = new SimpleCoffee();

        System.out.println("simple"+ coffee.getPrice());
    }
}
