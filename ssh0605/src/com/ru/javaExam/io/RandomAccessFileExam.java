/**
 * 文件名：RandomAccessFileExam.java
 *
 * 版本信息：
 * 日期：2013年11月5日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：任意访问 流
 * 创建人：成如
 * 创建时间：2013年11月5日 下午2:57:18
 * 修改人：成如
 * 修改时间：2013年11月5日 下午2:57:18
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class RandomAccessFileExam {

	/**
	 * 
	 * pointRanAc(使用RandomAccessFile定位访问)
	 * @return void
	 * @throws IOException 
	 */
	public static void pointRanAc() throws IOException{
		RandomAccessFile raf = null;
		byte[] buffer = new byte[1024];
		try {
			raf = new RandomAccessFile("G:/test/InetAddressTest.java", "rw");
			System.out.println("当前指针：" + raf.getFilePointer());
			//移动当前指针到300字节处
			raf.seek(10);
			int len = 0;
			while((len = raf.read(buffer)) != -1){
				System.out.println(new String(buffer, 0, len));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			raf.close();
		}
	}
	
	/**
	 * 
	 * appendContent(使用RandomAccessFile类向文件末尾追加内容)
	 * @param content
	 * @return void
	 * @throws IOException 
	 */
	public static void appendContent(String content) throws IOException{
		
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("G:/test/InetAddressTest.java", "rw");
			
			//将指针移动到文件末尾
			raf.seek(raf.length());
			System.out.println(raf.length());
			
			raf.write((content + "\n").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(raf !=null){
				raf.close();
			}
		}
	}
	
	/**
	 * 
	 * appendContentInside(向文件中间添加内容)
	 * @param file 操作文件
	 * @param pos 插入点（10的话 表示第10个字符的位置为插入点，汉字算两个字符）
	 * @param content 插入内容
	 * @throws IOException
	 * @return void
	 */
	public static void appendContentInside(String file, long pos, String content) throws IOException{
		RandomAccessFile raf = null;
		//生成临时文件
		File tmpFile = File.createTempFile("randomAccess_", null, new File("G:/test"));
		FileOutputStream fos = null;
		FileInputStream fis = null;
		System.out.println(tmpFile.getAbsolutePath());
		tmpFile.deleteOnExit();
		byte[] buffer = new byte[128];
		try {
			fos = new FileOutputStream(tmpFile);
			fis = new FileInputStream(tmpFile);
			raf = new RandomAccessFile(file, "rw");
			
			raf.seek(pos);//将raf指针指向pos
			int len = 0;
			
			//将插入点后的文件保存到临时文件中
			while((len = raf.read(buffer)) != -1){
				fos.write(buffer, 0, len);
			}
			
			//向插入点插入字符串
			raf.seek(pos);
			raf.write((content).getBytes());
			
			//将插入点后的内容从临时文件拷贝回来
			while((len = fis.read(buffer)) != -1){
				raf.write(buffer, 0, len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			if(fos != null){
				fos.close();
			}
			if(fis != null){
				fis.close();
			}
			if(raf !=null){
				raf.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		String str = "按那你";
		String file = "G:/test/ru.java";
		appendContent(str);
//		appendContentInside(file, 10, str);
//        pointRanAc();
    }
}
