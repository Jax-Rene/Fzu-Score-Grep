package me.zhuangjy.decorator;

/**
 * Created by johnny on 16/5/16.
 */
public class Main {
    public static void main(String[] args) {
        //先来一杯普通的咖啡
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() +  " " + beverage.cost());

        //加入两份摩卡
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " " + beverage.cost());
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " " + beverage.cost());

        //加入一份奶泡
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + " " + beverage.cost());
    }
}
