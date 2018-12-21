package com.sdenvi.gof23.FactoryMethod;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 16:39
 * 创建指定产品的具体工厂
 */
public class TubeCreator implements Creator {
    @Override
    public Light createLight() {
        return new TubeLight();
    }
}
