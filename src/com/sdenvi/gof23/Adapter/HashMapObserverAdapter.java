package com.sdenvi.gof23.Adapter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 9:34
 * 类适配器（定制适配器）
 * 继承我们希望复用其功能的类，并且实现我们想适配的接口，在这里就是Observer，那么就会产生一个适配器，
 * 这个适配器具有原有类（即HashMap）的功能，又具有观察者接口，所以这个适配器现在可以加入到观察者列表了。
 */
public class HashMapObserverAdapter<k, v> extends HashMap<k, v> implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        /** 被观察者变化时，清空Map */
        super.clear();
    }
}
