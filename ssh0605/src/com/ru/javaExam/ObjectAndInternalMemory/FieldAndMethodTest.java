/**
 * 文件名：FieldAndMethodTest.java
 *
 * 版本信息：
 * 日期：2013-6-19
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：继承成员变量和继承方法的区别
 * 创建人：nanchengru
 * 创建时间：2013-6-19 下午04:35:11
 * 修改人：nanchengru
 * 修改时间：2013-6-19 下午04:35:11
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
class Base{
	int count = 2;
	public void display(){
		System.out.println(this.count);
	}
} 

class Derived extends Base{
	int count = 20;
	/* (non-Javadoc)
	 * @see com.ru.javaExam.ObjectAndInternalMemory.Base#display()
	 */
	@Override
	public void display() {
		System.out.println(this.count);
	}
}

public class FieldAndMethodTest {

	//不管是变量d，还是变量bd、d2b，只要他们实际指向一个derived对象，不管声明他们时用什么类型。
	//当通过这些变量调用方法时，方法的行为总是表现出他们实际类型的行为。
	//当通过变量（bd）访问他们所指对象（Base）的变量时，这些实例变量的值总是表现出声明这些变量所用类型的行为。
	public static void main(String[] args){
		
		//生命并创建一个base对象
		Base b = new Base();
		System.out.println(b.count);
		b.display();
		System.out.println("---------------------------------------------------");
		//声明并创建一个derived对象
		Derived d = new Derived();
		System.out.println(d.count);
		d.display();
		System.out.println("---------------------------------------------------");
		
		//声明一个base变量，并将derived对象赋给该变量
		Base bd = new Derived();
		System.out.println(bd.count);
		bd.display();
		System.out.println("---------------------------------------------------");
		
		//让d2b指向d变量指向的derived对象
		Base d2b = d;
		System.out.println(d2b.count);
		d2b.display();
	}
}
