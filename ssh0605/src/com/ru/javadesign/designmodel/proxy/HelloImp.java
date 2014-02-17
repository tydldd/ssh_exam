package com.ru.javadesign.designmodel.proxy;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-5 上午11:23:02
 * 修改人：ru
 * 修改时间：2013-8-5 上午11:23:02
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class HelloImp implements HelloInter{

	/* (non-Javadoc)
	 * @see com.ru.javaExam.designmodel.proxy.HelloInter#print(java.lang.String)
	 */
	public void print(String p) {
		 System.out.println("print : " + p);  
	}

	/* (non-Javadoc)
	 * @see com.ru.javaExam.designmodel.proxy.HelloInter#sayHello(java.lang.String)
	 */
	public void sayHello(String to) {
		System.out.println("Say hello to " + to);
	}
	
}
