package me.zhuangjy.factory;

/**
 * Created by johnny on 16/5/17.
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("We are ordering a " + pizza.getName());

        System.out.println("\n");

//        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
//        pizza = chicagoStore.orderPizza("cheese");
//        System.out.println("We are ordering a " + pizza.getName());
    }
}
