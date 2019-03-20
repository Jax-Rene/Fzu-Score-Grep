package me.zhuangjy.decorator;

/**
 * Created by johnny on 16/5/16.
 * 具体装饰器
 */

public class Mocha extends CondimentDecorator{
    private Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , " + " Mocha ";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
