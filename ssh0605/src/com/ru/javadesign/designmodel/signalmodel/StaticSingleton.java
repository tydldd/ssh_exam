package com.ru.javadesign.designmodel.signalmodel;

/**
 * 项目名称：ssh0605
 * 类描述：单例模式
 * 创建人：ru
 * 创建时间：2013-8-7 下午03:24:52
 * 修改人：ru
 * 修改时间：2013-8-7 下午03:24:52
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class StaticSingleton {
	//使用private只能在自己内部初始化对象
	private StaticSingleton(){
		System.out.println("构造函数");
	}
	
	public static class SingletonHolder{
		private static StaticSingleton ss = new StaticSingleton();
	}
	
	public static StaticSingleton getInstance(){
		return SingletonHolder.ss;
	}
}

