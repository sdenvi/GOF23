package com.sdenvi.gof24.Observer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 16:09
 * 一个是为了改变自己的同时通知观察者们，一个是为了给客户端一个添加观察者的公共接口
 * 有一个观察者的列表，并且有一个通知所有观察者的方法，通知的方式就是调用观察者通用的接口行为update方法
 */
public class Observable {
    List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void changed(){
        System.out.println("我是被观察者，我已经发生变化了！");
        notifyObservables();
    }

    public void notifyObservables(){
        observers.forEach(observer -> observer.update(this));
        /*for (Observer observer : observers){
            observer.update(this);
        }*/
    }
}
