/**
 * 文件名：ReaderWriterExam.java
 *
 * 版本信息：
 * 日期：2013年10月31日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：字符刘实例
 * 创建人：成如
 * 创建时间：2013年10月31日 下午2:41:28
 * 修改人：成如
 * 修改时间：2013年10月31日 下午2:41:28
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class ReaderWriterExam {

	
	/**
	 * 
	 * test1(无缓冲字符流)
	 * @return void
	 * @throws IOException 
	 */
	//@Test
	public void test1() throws IOException{
		Reader read = null;
		Writer write = null; 
		try {
			File file = new File("G:\\test\\FileNamFileterExam.java");
			if(!file.exists()){
				file.createNewFile();
			}
		
			read = new FileReader(file);
			write = new FileWriter("G:\\test\\write.java");
			int chars = 0;
			while((chars = read.read()) > 0){
				write.write(chars);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(write != null){
				write.close();
			}
			if(read != null){
				read.close();
			}
		}
	}
	
	/**
	 * 
	 * test2(使用缓冲字符流)
	 * @return void
	 * @throws IOException 
	 */
	//@Test
	public void test2() throws IOException{
		Reader fr = null;
		Writer fw = null; 
		try {
			File file = new File("G:\\test\\FileNamFileterExam.java");
			if(!file.exists()){
				file.createNewFile();
			}
		
			fr = new FileReader(file);
			fw = new FileWriter("G:\\test\\write.java");
			
			char[] chars = new char[1024];
			int length = 0;//char数组长度
			while((length = fr.read(chars)) > 0){
				fw.write(chars, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				fw.close();
			}
			if(fr != null){
				fr.close();
			}
		}
	}
	
	/**
	 * 
	 * bufferedReaderTest(使用BufferedReader类的readLine()方法:只用BufferedReader有这个方法)
	 * @return void
	 * @throws IOException 
	 */
	@Test
	public void bufferedReaderTest() throws IOException{
		
		BufferedReader br = null;
		
		try {
			File file = new File("G:\\test\\FileNamFileterExam.java");
			if(!file.exists()){
				file.createNewFile();
			}
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuilder sb = new StringBuilder();
			String str = null;
			while((str = br.readLine()) != null){
				sb.append("--" + str + "--" + "\n");
			}
            if(new String("    ").trim().equals("")){
                System.out.println("----))))))-");
            }
//            System.out.println(":::::" + new String("     ").trim());

			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
		}
	}
	
	/**
	 * 
	 * fileWriterTest(使用FileWriter类的write(String)方法将字符串写入文件)
	 * @throws IOException
	 * @return void
	 */
	public void fileWriterTest() throws IOException{
		
		String str = "这个字符串将写入文件";
		FileWriter fw = null;
		
		try {
			File file = new File("G:\\test\\filewrite.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			
			fw = new FileWriter(file);
			fw.write(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				fw.close();
			}
		}
	}
	
	/**
	 * 
	 * subStrings(截取文件里的一个字符串)
	 * @param beginStr 开始标识字符串（不包含在截取字符串里）
	 * @param endStr 结束标识字符串（不包含在截取字符串里）
	 * flag :false标识没有找到开始标识之前 true找到开始标识之后
	 * @return void
	 */
	public static String subStrings(String beginStr, String endStr){
		BufferedReader bf = null;
		String flag = "false";
		StringBuilder sb = new StringBuilder();
		try {
			bf = new BufferedReader(new FileReader("G:/test/topgap.conf"));
			
			String content = null;
			while((content = bf.readLine()) != null){
				//包含开始标识，将flag置为tue
				if(content.equals(beginStr)){
					flag = "true";
					continue;//跳出当前循环
				}
				//假如flag 是true开始拼接字符串
				if(flag.equals("true")){
					//不是结束标识则拼接字符串
					if(!content.equals(endStr)){
						sb.append(content + "\n");
					}else{//如果是结束标识的话将
						return sb.toString();
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	/*public static void main(String[] args){
		System.out.println(subStrings("[tcp_base]", "[/tcp_base]"));
	}*/
	
}
