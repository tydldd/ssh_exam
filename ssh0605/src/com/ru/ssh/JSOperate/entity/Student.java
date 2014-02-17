/**
 * 文件名：Student.java
 *
 * 版本信息：
 * 日期：2013年10月26日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.ssh.JSOperate.entity;

import java.io.Serializable;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013年10月26日 下午7:22:36
 * 修改人：成如
 * 修改时间：2013年10月26日 下午7:22:36
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Student implements Serializable{
	
	private int id;
	private String name;
	private int age;
	private String major;
	public String getName() {
		return name;
	}
	
	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
