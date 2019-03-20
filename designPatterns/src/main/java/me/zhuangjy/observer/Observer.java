package me.zhuangjy.observer;

/**
 * Created by johnny on 16/5/16.
 */
public interface Observer {
    /**
     *  观察者接口根据具体需求实现。这里需要时要监测温度、湿度、气压
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void update(float temp,float humidity,float pressure);
}
