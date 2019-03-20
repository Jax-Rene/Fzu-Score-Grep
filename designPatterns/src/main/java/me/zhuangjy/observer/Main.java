package me.zhuangjy.observer;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * Created by johnny on 16/5/16.
 */
public class Main {
    public static void main(String[] args) {
        WeatherData subject = new WeatherData();
        new CurrentConditionsDisplay(subject);
        System.out.println("first time: ");
        subject.setMeasurements(1.0f,1.1f,1.2f);
        System.out.println("second time: ");
        subject.setMeasurements(2.0f,2.1f,2.2f);
    }
}
