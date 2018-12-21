package com.sdenvi.gof23.Observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 16:39
 * 读者类，实现观察者接口
 */
public class Reader implements Observer{

    private String name;
    public Reader(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 读者可以关注某一位作者，关注则代表把自己加到作者的观察者列表里
     * @param writerName
     */
    public void subscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    /**
     * 读者可以取消关注某一位作者，取消关注则代表把自己从作者的观察者列表里删除
     * @param writerName
     */
    public void unsubscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Writer) {
            Writer writer = (Writer) o;
            System.out.println(name+"知道" + writer.getName() + "发布了新书《" + writer.getLastNovel() + "》，非要去看！");
        }
    }
}
