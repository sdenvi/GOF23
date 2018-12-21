package com.sdenvi.gof24.Creator;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 15:32
 * 工厂类
 */
public class Creator {
    private Creator(){};

    public static IProduct createProduct(String productName){
        if (productName == null) {
            return null;
        }
        if ("A".equals(productName)) {
            return new ProductA();
        } else if ("B".equals(productName)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}
