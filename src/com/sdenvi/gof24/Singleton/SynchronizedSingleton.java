package com.sdenvi.gof24.Singleton;

/**
 * 单例模式
 * 首先要明白在JVM创建新的对象时，主要要经过三步。 1.分配内存 2.初始化构造器 3.将对象指向分配的内存的地址
 * 2和3可能是相反的是因为JVM会针对字节码进行调优，而其中的一项调优便是调整指令的执行顺序
 * 先将分配好的内存地址指给synchronizedSingleton
 * 然后再进行初始化构造器，这时候后面的线程去请求getInstance方法时，会认为synchronizedSingleton对象已经实例化了
 * 直接返回一个引用。如果在初始化构造器之前，这个线程使用了synchronizedSingleton，就会产生莫名的错误。
 * 
 * 解决办法：静态的实例属性加上关键字volatile，标识这个属性是不需要优化的
 * @author someone
 *
 */
public class SynchronizedSingleton {

	/** 一个静态的实例*/
	private static SynchronizedSingleton synchronizedSingleton;

	/** 私有化构造函数*/
	private SynchronizedSingleton() {
	}

	/** 给出一个公共的静态方法返回一个单一实例*/
	public static SynchronizedSingleton getInstance() {
		if (synchronizedSingleton == null) {
			synchronized (SynchronizedSingleton.class) {
				if (synchronizedSingleton == null) {
					synchronizedSingleton = new SynchronizedSingleton();
				}
			}
		}
		return synchronizedSingleton;
	}
}