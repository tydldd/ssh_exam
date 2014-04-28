package com.ru.jvm.jvm_class;

public class Test2 {

	public static void main(String[] args) {
		AA b = new AA();
		Class clzz = b.getClass();
		System.out.println("a = " + b.a);
	}
}
