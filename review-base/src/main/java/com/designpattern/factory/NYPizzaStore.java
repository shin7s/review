package com.designpattern.factory;

public class NYPizzaStore implements PizzaStore {
    @Override
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if ("NY".equals(type)) {
            if ("Cheese".equals(type)) {
                return new NYStyleCheesePizza();
            }
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
