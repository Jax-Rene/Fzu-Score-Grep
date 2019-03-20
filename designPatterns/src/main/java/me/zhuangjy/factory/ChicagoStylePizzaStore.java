package me.zhuangjy.factory;

import me.zhuangjy.factory.absFactory.NYPizzaIngredientFactory;
import me.zhuangjy.factory.absFactory.PizzaIngredientFactory;

/**
 * Created by johnny on 16/5/18.
 */
public class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if(type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza(pizzaIngredientFactory);
            pizza.setName("Chi cheese");
        }
        //else...
//        else return null;
        return pizza;
    }
}
