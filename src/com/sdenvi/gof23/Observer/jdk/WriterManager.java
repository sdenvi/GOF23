package com.sdenvi.gof23.Observer.jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/20
 * Time: 16:42
 * 管理器，保持一份独有的作者列表
 */
public class WriterManager {

    private Map<String, Writer> writerMap = new HashMap<String, Writer>();

    /**
     * 添加作者
     * @param writer
     */
    public void add(Writer writer){
        writerMap.put(writer.getName(), writer);
    }

    /**
     * 根据作者名字获取作者
     * @param name
     * @return
     */
    public Writer getWriter(String name){
        return writerMap.get(name);
    }

    /**
     * 单例
     */
    private WriterManager(){}

    public static WriterManager getInstance(){
        return WriterManagerInstance.instance;
    }

    public static class WriterManagerInstance{
        private static WriterManager instance = new WriterManager();
    }

}
