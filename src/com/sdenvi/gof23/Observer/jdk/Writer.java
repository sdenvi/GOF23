package com.sdenvi.gof23.Observer.jdk;

import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 16:47
 * //作者类，要继承自被观察者类
 */
public class Writer extends Observable{

    /**
     * 作者的，名称
     */
    private String name;
    /**
     * 记录作者最新发布的小说
     */
    private String lastNovel;

    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public Writer(String name){
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    /**
     * 作者发布新小说时要通知所有关注自己的读者
     * @param novel
     */
    public void addNovel(String novel){
        System.out.println(name + "发布了新书《" + novel + "》！");
        lastNovel = novel;
        setChanged();
        notifyObservers();
    }
}
