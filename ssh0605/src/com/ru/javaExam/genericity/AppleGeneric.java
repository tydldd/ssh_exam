/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.genericity;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：类中包含泛型声明
 * 创建人：成如
 * 创建时间：2013-10-4 下午6:35:45
 * 修改人：成如
 * 修改时间：2013-10-4 下午6:35:45
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class AppleGeneric<T> {
	private T info;
	private String name;
	
	/**
	 * 构造函数  AppleGeneric.
	 *
	 */
	public AppleGeneric() {
		super();
	}

	/**
	 * 构造函数  AppleGeneric.
	 *
	 * @param info
	 */
	public AppleGeneric(T info) {
		this.info = info;
	}


	public T getInfo() {
		return info;
	}

	/*public static void main(String[] args){
		AppleGeneric<String> apple = new AppleGeneric<String>("富士");
		System.out.println(apple.getInfo());
	}*/
}


class FuShi extends AppleGeneric<String>{
	
	AppleGeneric<String> apple = new AppleGeneric<String>("红富士");
	
	/* (方法重写)
	 * @see com.ru.javaExam.genericity.AppleGeneric#getInfo()
	 */
	@Override
	public String getInfo() {
		return super.getInfo();
	}
}
