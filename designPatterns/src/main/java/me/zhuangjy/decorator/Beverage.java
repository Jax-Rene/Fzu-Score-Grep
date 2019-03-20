package me.zhuangjy.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by johnny on 16/5/16.
 * 饮料 —— 抽象类 所有类的基类
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";
    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
