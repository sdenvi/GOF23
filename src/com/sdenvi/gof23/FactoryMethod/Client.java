package com.sdenvi.gof23.FactoryMethod;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 16:40
 * 工厂方法(Factory Method)模式
 * 我们需要增加产品时，只需要增加相应的产品和工厂类，而不需要修改现有的代码。
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new BuldCreator();
        Light light = creator.createLight();
        light.turnOn();
        light.turnOff();

        creator = new TubeCreator();
        light = creator.createLight();
        light.turnOn();
        light.turnOff();
    }
}
