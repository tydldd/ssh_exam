/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.entity;

import java.io.Serializable;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-8-30 上午10:27:00
 * 修改人：成如
 * 修改时间：2013-8-30 上午10:27:00
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Person implements Serializable{
	
	private String name;
	private int age;
	private String address;
	
	
	
	
	/**
	 * 创建一个新的实例 Person.
	 *
	 */
	public Person() {
		super();
	}

	/**
	 * 创建一个新的实例 Person.
	 *
	 * @param name
	 * @param age
	 * @param address
	 */
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
