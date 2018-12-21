package com.sdenvi.gof24.Observer.simple;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public interface Observer{
    /**
     * 这个接口是为了提供一个统一的观察者做出相应行为的方法
     * @param o
     */
    void update(Observable o);
}
