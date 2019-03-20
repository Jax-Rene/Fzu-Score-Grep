package me.zhuangjy.factory;

/**
 * Created by johnny on 16/5/17.
 * 抽象工厂类
 */
public abstract class PizzaStore {
    //这个方法可以保证所有的子类工厂都一致
    public final Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    //抽象方法: 把具体工厂获取实例实现交给子类
    protected abstract Pizza createPizza(String type);
}
