package com.ru.jvm.loadclass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DnamicLoadJar {

	/**
	 * 动态加载jar文件(加载到classpath中)
	 * @param jarFilePath jar文件路径
	 * @return 返回一个URLClassLoader
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws MalformedURLException
	 */
	public static URLClassLoader loadJar(String jarFilePath) throws NoSuchMethodException, 
		SecurityException, IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, MalformedURLException{
		//得到类加载器
		URLClassLoader urlLoad = (URLClassLoader) Thread.currentThread().getContextClassLoader();
		//创建addurl方法对象
		Method addUrlMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
		addUrlMethod.setAccessible(true);
		//加载指定jar
		addUrlMethod.invoke(urlLoad, new URL(jarFilePath));
		
		return urlLoad;
	}
	
	/**
	 * 动态调用jar中的类方法（适用于动态加载的jar）
	 * @param cl ： 类装载器，如：URLClassLoader
	 * @param classPath ： 类路径，如：com.ru.test.test
	 * @param methodName ： 类的方法名称
	 * @return 返回方法执行结果
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static Object excuteMethod(ClassLoader cl, String classPath, String methodName) throws
		ClassNotFoundException, NoSuchMethodException, SecurityException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
		InstantiationException{
		//使用类加载器，加载类
		Class clazz = cl.loadClass(classPath);
		//得到Test类的test方法对象
		Method method = clazz.getDeclaredMethod(methodName, null);
		//执行方法
		Object obj = method.invoke(clazz.newInstance(), null);
		return obj;
	}
	
	public static void main(String[] args) {
		String filePath = "file://" + DnamicLoadJar.class.getResource("/com/ru/jvm/loadclass/test.jar").
				getPath();
		String classPath = "test.Test";
		String methodName = "test";
		try {
			
			URLClassLoader urlLoad = loadJar(filePath);
			Object obj = excuteMethod(urlLoad, classPath, methodName);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
