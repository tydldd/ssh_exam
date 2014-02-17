/**
 * 文件名：InputStreamExam.java
 *
 * 版本信息：
 * 日期：2013年10月30日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：字节流实例
 * 创建人：成如
 * 创建时间：2013年10月30日 下午10:53:16
 * 修改人：成如
 * 修改时间：2013年10月30日 下午10:53:16
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
@SuppressWarnings("all")
public class InputStreamExam {

	/**
	 * 
	 * test(不使用缓存)
	 * @throws IOException
	 * @return void
	 */
	//@Test
	public void test() throws IOException{
		
		InputStream is = null;
		OutputStream os = null;
		try {
			File fileIn = new File("G:\\test\\FileNamFileterExam.java");//输入流文件必须存在
			if(!fileIn.exists()){
				fileIn.createNewFile();
			}
			
			is = new FileInputStream(fileIn);
			
			//输出流文件的父目录必须存在，文件本身可以不存在，会在输出时自动创建。但是如果父目录不存在则报错
			os = new FileOutputStream("G:\\test\\test.java");
			int res = 0;
			while((res = is.read()) > 0){
				os.write(res);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os != null){
				os.close();
			}
			if(is != null){
				is.close();
			}
			
		}
	}
	
	@Test
	/**
	 * 
	 * test2(使用缓存)
	 * @throws IOException
	 * @return void
	 */
	public void test2() throws IOException{
		InputStream is = null;
		OutputStream os = null;
		try {
			File fileIn = new File("G:\\test\\FileNamFileterExam.java");//输入流文件必须存在
			if(!fileIn.exists()){
				fileIn.createNewFile();
			}
			
			is = new BufferedInputStream(new FileInputStream(fileIn));
			
			byte[] buffer = new byte[1024];
			
			//输出流文件的父目录必须存在，文件本身可以不存在，会在输出时自动创建。但是如果父目录不存在则报错
			os = new FileOutputStream("G:\\test\\test.java");
			int length = 0;//byte数组长度
			while((length = is.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os != null){
				os.close();
			}
			if(is != null){
				is.close();
			}
			
		}
	}
}
