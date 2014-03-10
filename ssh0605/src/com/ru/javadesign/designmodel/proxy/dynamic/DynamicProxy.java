package com.ru.javadesign.designmodel.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月10日 上午11:02:52
 * 修改人：nange
 * 修改时间：2014年3月10日 上午11:02:52
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class DynamicProxy {
	public static void main(String[] args) {
		Hello helloImp = new HelloImp();
		InvocationHandler helloHandler = new HelloHandler(helloImp);
		Hello hello = (Hello) Proxy.newProxyInstance(helloImp.getClass().getClassLoader(), 
				helloImp.getClass().getInterfaces(), helloHandler);
		hello.sayHello("hello!!");
		hello.sayGoodBye("goodbye!!");
	}
}

//真实接口hello
interface Hello{
	void sayHello(String hello);
	void sayGoodBye(String goodBye);
}

//接口实现类
class HelloImp implements Hello{

	@Override
	public void sayHello(String hello) {
		System.out.println("say:" + hello);
	}

	@Override
	public void sayGoodBye(String goodBye) {
		System.out.println("say:" + goodBye);
	}
}

//实现调用处理接口
class HelloHandler implements InvocationHandler{

	private Object obj;
	public HelloHandler(Object obj){
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		//执行方法时，做一些操作
		System.out.println("start");
		//执行方法实现
		result = method.invoke(obj, args);
		//执行完方法，做一些操作
		System.out.println("end");
		return result;
	}
	
}