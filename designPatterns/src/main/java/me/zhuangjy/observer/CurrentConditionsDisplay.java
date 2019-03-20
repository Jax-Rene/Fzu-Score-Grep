package me.zhuangjy.observer;

/**
 * Created by johnny on 16/5/16.
 * 观察者
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;

    //保留引用自主注册以及删除
    private Subject weatherDate;

    public CurrentConditionsDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        weatherDate.registerObserver(this);
    }

    public void display() {
        System.out.println("current: temperature: " + temperature + " humidity: " + humidity + " pressure: " +  pressure);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
