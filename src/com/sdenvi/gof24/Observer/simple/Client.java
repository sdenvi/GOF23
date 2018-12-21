package com.sdenvi.gof24.Observer.simple;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Observable observable = new Observable();
        observable.addObserver(new ConcreteObserver1());
        observable.addObserver(new ConcreteObserver2());
        observable.changed();
    }
}
