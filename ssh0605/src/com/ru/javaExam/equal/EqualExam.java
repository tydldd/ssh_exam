package com.ru.javaExam.equal;

import com.ru.javaExam.io.Test;

/**
 * equals 和  ==的区别
 * @author nange
 *
 */
public class EqualExam{

	public static void main(String[] args) {
		
		EqualExam ee = new EqualExam();
		ee.t1();
		ee.t2();
	}
	
	/**
	 * equals 和 ==
	 * 
	 * ==比较两个对象的地址
	 */
	public void t1(){
		String a = "123";
		String b = "123";
		System.out.println("a == b:" + (a == b));
	}
	
	/**
	 * equals 和 ==
	 * 
	 * equals比较地址和值
	 */
	public void t2(){
		A a1 = new A();
		A a2 = a1;
		a1.equals(a2);
		a2.setA(123);
		System.out.println("a1.a = " + a1.getA() + "a2.a =" + a2.getA() + 
				"a1 == a2:" + (a1 == a2));
	}
}

class A{
	private int a = 0;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}