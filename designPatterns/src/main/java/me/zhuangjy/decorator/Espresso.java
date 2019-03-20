package me.zhuangjy.decorator;

/**
 * Created by johnny on 16/5/16.
 * 具体饮料 —— 被装饰类
 */
public class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }

    /**
     * 返回具体饮料价格
     * @return
     */
    public double cost(){
        return 1.99;
    }
}
