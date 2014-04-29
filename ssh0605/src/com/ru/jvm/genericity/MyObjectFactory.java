package com.ru.jvm.genericity;


/**
 * 使用泛型创建一个对象工厂
 * @author nange
 *
 */
public class MyObjectFactory {

	/**
	 * 通过class路径得到类的实例(得到泛型对象)
	 * @param classPath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String classPath){
		Class<?> clazz;
		T instance = null;
		try {
			clazz = Class.forName(classPath);
			instance = (T) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return instance;
	}
	
	public void test(){
		System.out.println("执行test方法");
	}
	
	public static void main(String[] args) {
		MyObjectFactory mof = getInstance("com.ru.jvm.genericity.MyObjectFactory");
		mof.test();
	}
}
