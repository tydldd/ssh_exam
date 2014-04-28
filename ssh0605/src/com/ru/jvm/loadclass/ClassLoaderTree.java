package com.ru.jvm.loadclass;

/**
 * 返回类加载器树
 * @author nange
 *
 */
public class ClassLoaderTree { 

    public static void main(String[] args) { 
    	//得到ClassLoaderTree的类加载器
        ClassLoader loader = ClassLoaderTree.class.getClassLoader(); 
        while (loader != null) { 
            System.out.println(loader.toString()); 
            loader = loader.getParent(); 
        } 
    } 
}