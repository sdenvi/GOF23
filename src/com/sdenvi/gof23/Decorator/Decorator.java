package com.sdenvi.gof23.Decorator;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 10:47
 * 抽象装饰器父类，它主要是为装饰器定义了我们需要装饰的目标是什么，并对Component进行了基础的装饰。
 */
public class Decorator implements Component {

    protected Component component;

    public Decorator(Component component){
        super();
        this.component = component;
    }

    @Override
    public void method() {
        component.method();
    }
}
