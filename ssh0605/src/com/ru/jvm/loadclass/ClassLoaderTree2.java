package com.ru.jvm.loadclass;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * classloader树
 * @author nange
 *
 */
public class ClassLoaderTree2 {

	public static void main(String[] args) throws IOException {
		//1、得到系统类加载器
		ClassLoader sysCl = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器：" + sysCl);

		//得到所有给定名称的资源
		Enumeration<URL> sysUrls = sysCl.getResources("com/ru/jvm/");
		while(sysUrls.hasMoreElements()){
			URL e = sysUrls.nextElement();
			System.out.println("资源：" + e);
		}
		
		//1、得到拓展类加载器
		ClassLoader extendCl = sysCl.getParent();
		System.out.println("系统类加载器：" + extendCl);

		//得到所有给定名称的资源
		Enumeration<URL> extendUrl = extendCl.getResources("");
		while(extendUrl.hasMoreElements()){
			URL e = extendUrl.nextElement();
			System.out.println("资源：" + e);
		}

	}
}
