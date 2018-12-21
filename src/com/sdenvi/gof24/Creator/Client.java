package com.sdenvi.gof24.Creator;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 15:36
 * 简单工程模式
 */
public class Client {
    public static void main(String[] args) {
        IProduct product1 = Creator.createProduct("A");
        product1.method();

        IProduct product2 = Creator.createProduct("B");
        product2.method();
    }
}
