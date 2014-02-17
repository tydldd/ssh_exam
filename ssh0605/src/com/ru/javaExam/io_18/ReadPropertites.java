package com.ru.javaExam.io_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * @author南成�?
 * */
public class ReadPropertites {
	/**
	 * 根据key读取属�?文件
	 * @param key
	 * */
	@Test
	public void readProperties() throws IOException{
		try {
			//文件字节输入�?
			FileInputStream fis=new FileInputStream(new File("D:\\测试文件\\conf.properties"));
			
			//property文件,表示�?��键�?对集�?
			Properties p=new Properties();
			//装载输入流，得到properties的键值对列表
			p.load(fis);
			fis.close();
			//通过key取value
			String path=p.getProperty("logPath");
			System.out.println("logPath="+path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 向properties写入键�?,key、value
	 * @param key
	 * @param value
	 * */
	@Test
	public void writeProperties() throws IOException{
		try {
			FileInputStream fis=new FileInputStream(new File("D:\\测试文件\\conf.properties"));
			Properties p=new Properties();
			p.load(fis);
			fis.close();//�?��要在修改值之前关闭fis
			FileOutputStream fos=new FileOutputStream(new File("E:\\test5.txt"));//文件字节输出�?
			p.setProperty("ru", "that is a test cases!");//设置属�?
			p.store(fos, "添加属�?");//将此 Properties 表中的属性列表（键和元素对）写入输出�?
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
