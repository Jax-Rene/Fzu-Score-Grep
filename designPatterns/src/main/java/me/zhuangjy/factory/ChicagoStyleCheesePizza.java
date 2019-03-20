package me.zhuangjy.factory;

import me.zhuangjy.factory.absFactory.PizzaIngredientFactory;

/**
 * Created by johnny on 16/5/18.
 */
public class ChicagoStyleCheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public ChicagoStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("prepareing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        toppings = ingredientFactory.createVeggies();
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
