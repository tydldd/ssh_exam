package com.ru.javadesign.designmodel.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-5 上午11:38:39
 * 修改人：ru
 * 修改时间：2013-8-5 上午11:38:39
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class RunProxyTest {

	/**
	 * 
	 * ( 通过接口调用代理执行方法 )
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test(){
		
		HelloImp helloImp = new HelloImp();
		JdkDynamicProxy proxy = new JdkDynamicProxy(helloImp);
		
		//使用proxy代理helloImp，并使用接口调用helloImp的方法
		HelloInter hello = (HelloInter) Proxy.newProxyInstance(helloImp.getClass().getClassLoader(), 
				helloImp.getClass().getInterfaces(), proxy);
		
		hello.sayHello("ruye");
		hello.print("hello");
	}
}
