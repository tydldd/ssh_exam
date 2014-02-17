/**
 * 文件名：PushbackInputstreamExam.java
 *
 * 版本信息：
 * 日期：2013年11月4日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：推回输入流
 * 创建人：成如
 * 创建时间：2013年11月4日 下午9:17:27
 * 修改人：成如
 * 修改时间：2013年11月4日 下午9:17:27
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class PushbackInputstreamExam {

	/**
	 * 
	 * pushbackIn(过滤掉制定字符串)
	 * @return
	 * @throws IOException
	 * @return boolean
	 */
	public static boolean pushbackIn() throws IOException{
		PushbackReader pr = null;
		FileWriter fw = null;
		char[] buffer = new char[32];//字符缓冲区
		int length = 0;
		//上一次读取的内容
		String lastContent = "";
		try {
			//创建一个推回缓冲区长度为64的推回输入流,推回缓冲区长度要大于字符缓冲区，这里要是2倍或以上
			pr = new PushbackReader(new FileReader("G:/test/ReaderWriterExam.java"),64);
			fw = new FileWriter("G:/test/reader.java");
			while((length = pr.read(buffer)) != -1){
				//得到读取的字符串
				String currentContent = new String(buffer, 0, length);
				//将上次和本次字符串组成一个字符串
				String content =lastContent + currentContent;
				//制定字符串的索引值
				int targetIndex = 0;
				
				//假如包含ssh0605则将字符串推回缓冲区，然后从推回缓冲区读取到字符缓冲区
				if((targetIndex = content.indexOf("ssh0605")) != -1){
					
					//去掉需要过滤字符串后的字符串
					content = content.substring(0,targetIndex) + content.substring(targetIndex + 7, content.length());

					//将剩下的字符串推回缓冲区
					pr.unread(content.toCharArray());
					//从推回缓冲区读取数据到字符缓冲区，32是字符数组长度
					if(content.length() > 32){
						pr.read(buffer, 0, 32);
						fw.write(buffer, 0, 32);
						pr.read(buffer, 0, content.length() - 32);
						fw.write(buffer, 0, content.length() - 32);
					}else if(content.length() == 32){
						pr.read(buffer, 0, 32);
						fw.write(buffer, 0, 32);
					}else{
						pr.read(buffer, 0, content.length());
						fw.write(buffer, 0, content.length());
					}
					
				}else{
					//将本次读取的内容设为上次的内容
					lastContent = currentContent;
					fw.write(buffer, 0, length);
				}
				
			}
			
			if(length == -1){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				fw.close();
			}
			if(pr != null){
				pr.close();
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		System.out.println(pushbackIn());//过滤指定字符串
	}
}
