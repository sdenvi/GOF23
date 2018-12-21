package com.sdenvi.gof23.Decorator;

public class Main {

    public static void main(String[] args) {
        // 原来的对象
        Component component =new ConcreteComponent();
        System.out.println("------------------------------");
        // 原来的方法
        component.method();
        // 装饰成A
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);
        System.out.println("------------------------------");
        // 原来的方法
        concreteDecoratorA.method();
        // 装饰成A以后新增的方法
        concreteDecoratorA.methodA();
        // 装饰成B
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(component);
        System.out.println("------------------------------");
        // 原来的方法
        concreteDecoratorB.method();
        // 装饰成B以后新增的方法
        concreteDecoratorB.methodB();
        // 装饰成A以后再装饰成B
        concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        System.out.println("------------------------------");
        // 原来的方法
        concreteDecoratorB.method();
        // 装饰成B以后新增的方法
        concreteDecoratorB.methodB();
    }
}
