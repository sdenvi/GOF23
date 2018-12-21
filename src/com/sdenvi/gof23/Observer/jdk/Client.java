package com.sdenvi.gof23.Observer.jdk;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 17:06
 * 观察者模式 客户端调用
 */
public class Client {

    public static void main(String[] args) {
        /** 假设四个读者，两个作者 */
        Reader r1 = new Reader("读者1");
        Reader r2 = new Reader("读者2");
        Reader r3 = new Reader("读者3");
        Reader r4 = new Reader("读者4");
        Writer w1 = new Writer("作者1");
        Writer w2 = new Writer("作者2");

        r1.subscribe("作者1");
        r2.subscribe("作者1");
        r3.subscribe("作者1");
        r4.subscribe("作者1");
        r3.subscribe("作者2");
        r4.subscribe("作者2");

        /** 作者发布新书就会通知关注的读者 */
        w1.addNovel("设计模式");
        w2.addNovel("JAVA编程思想");
        r1.unsubscribe("作者1");
        w1.addNovel("观察者模式");
    }

}