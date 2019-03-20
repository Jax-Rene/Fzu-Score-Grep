package me.zhuangjy.decorator;

/**
 * Created by johnny on 16/5/16.
 * 具体装饰器
 */

public class Whip extends CondimentDecorator{
    private Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , " + " Mocha ";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
