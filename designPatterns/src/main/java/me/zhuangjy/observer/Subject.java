package me.zhuangjy.observer;

/**
 * Created by johnny on 16/5/16.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
