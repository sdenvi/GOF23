package com.sdenvi.gof23.Decorator;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 10:44
 * 具体的接口实现类，也就是俗称的原始对象，或者说待装饰对象。
 */
public class ConcreteComponent implements Component {
    @Override
    public void method() {
        System.out.println("原来的方法");
    }
}
