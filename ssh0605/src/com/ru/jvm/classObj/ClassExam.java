package com.ru.jvm.classObj;

import java.lang.reflect.Constructor;

/**
 * class类对象实例
 * @author nange
 *
 */
public class ClassExam {
	private String s1;
	private String s2;
	public ClassExam(){
		
	}
	public ClassExam(String s1){
		this.s1 = s1;
	}
	
	public static void main(String[] args) {
		//得到ClassExam类对象
		Class<ClassExam> clazz = ClassExam.class;
		Constructor<?>[] cons = clazz.getConstructors();
		for(int i = 0; i < cons.length; i++){
			System.out.println(cons[i].getName());
		}
	}
}
