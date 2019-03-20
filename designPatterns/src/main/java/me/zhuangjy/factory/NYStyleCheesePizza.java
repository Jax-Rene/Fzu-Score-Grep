package me.zhuangjy.factory;

import me.zhuangjy.factory.absFactory.PizzaIngredientFactory;

/**
 * Created by johnny on 16/5/18.
 */
public class NYStyleCheesePizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public NYStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("prepareing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        toppings = ingredientFactory.createVeggies();
    }
}
