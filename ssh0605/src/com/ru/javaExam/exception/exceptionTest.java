/**
 * 文件名：exceptionTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-25
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.exception;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-25 下午05:32:10
 * 修改人：nanchengru
 * 修改时间：2013-6-25 下午05:32:10
 * 修改备注：
 * 环境：  jdk1.7
 */
public class exceptionTest {
	
	Logger log = Logger.getLogger(exceptionTest.class);
	
	/**
	 * 
	 * test(资源关闭的实例，一般使用finally关闭物理资源)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test(){
		log.info("异常实例-开始");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("D:\\a.txt"));
			bos = new BufferedOutputStream(new FileOutputStream(":\\b.txt"));
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = bis.read(buffer)) > 0){
				bos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			log.error("出错了！");
			e.printStackTrace();
		}finally{//下面关闭资源是比较安全的方法
			
			if(bos != null){
				try {
					bos.close();
					System.out.println("关闭输出流");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(bis != null){
				try {
					bis.close();
					System.out.println("关闭输入流");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
