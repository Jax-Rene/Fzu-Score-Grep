package me.zhuangjy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnny on 16/5/16.
 */
public class WeatherData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for(Observer o:observers){
            o.update(temperature,humidity,pressure);
        }
    }

    /**
     * 收到改变时通知观察者
     */
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
