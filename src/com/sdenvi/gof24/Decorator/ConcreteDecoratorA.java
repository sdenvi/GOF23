package com.sdenvi.gof24.Decorator;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 11:17
 * 装饰器A
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void methodA() {
        System.out.println("被装饰器A扩展的功能");
    }

    @Override
    public void method() {
        System.out.println("针对该方法加一层A包装");
        super.method();
        System.out.println("A包装结束");
    }
}
