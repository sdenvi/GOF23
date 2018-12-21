package com.sdenvi.gof23.Singleton;

public class Singleton {
    
	/**
     * 单例模式
	 * 一个类的静态属性只会在第一次加载类时初始化，这是JVM帮我们保证的，所以我们无需担心并发访问的问题。
	 * 所以在初始化进行一半的时候，别的线程是无法使用的，因为JVM会帮我们强行同步这个过程。
	 * 另外由于静态变量只初始化一次，所以singleton仍然是单例的。
	 */
    private Singleton(){}
    
    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }
    
    private static class SingletonInstance{
        static Singleton instance = new Singleton();
    }
}