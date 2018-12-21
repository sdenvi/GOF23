package com.sdenvi.gof23.FactoryMethod;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class TubeLight implements Light {
    @Override
    public void turnOn() {
        System.out.println("TubeLight On");
    }

    @Override
    public void turnOff() {
        System.out.println("TubeLight Off");

    }
}
