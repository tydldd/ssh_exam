package com.ru.javadesign.designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 项目名称：ssh0605
 * 类描述：这个JDK动态代理类会代理HelloImp这个真实类
 * 创建人：ru
 * 创建时间：2013-8-5 上午11:21:22
 * 修改人：ru
 * 修改时间：2013-8-5 上午11:21:22
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class JdkDynamicProxy implements InvocationHandler{

	public Object obj;
	public JdkDynamicProxy(Object obj){
		this.obj = obj;
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		before();
		
		//这一行可以没有，但是没有则不能调用真实类的方法
		Object result = method.invoke(obj, args);  
		
		after();
		
		return null;
	}
	
	/**
	 * 
	 * ( 可以在代理方法执行前，执行这个方法 )
	 * @param  
	 * @return 
	 * @throws
	 */
	public void before(){
		System.out.println("before.....................");
	}
	
	/**
	 * 
	 * ( 可以在代理方法之后，执行这个方法 )
	 * @param  
	 * @return 
	 * @throws
	 */
	public void after(){
		System.out.println("after......................");
	}
	
}
