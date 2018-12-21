package com.sdenvi.gof24.Observer.simple;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void update(Observable o) {
        System.out.println("观察者2观察到" + o.getClass().getSimpleName() + "发生变化");
        System.out.println("观察者2做出响应");
    }
}
