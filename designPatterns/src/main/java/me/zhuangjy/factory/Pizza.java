package me.zhuangjy.factory;

import me.zhuangjy.factory.absFactory.Dough;
import me.zhuangjy.factory.absFactory.Sauce;
import me.zhuangjy.factory.absFactory.Veggies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnny on 16/5/17.
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] toppings;

    abstract void prepare();

    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut(){
        System.out.println("Cutting the pizza into diagonal slice");
    }

    void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
