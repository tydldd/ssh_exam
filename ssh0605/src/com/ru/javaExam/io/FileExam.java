/**
 * 文件名：FileExam.java
 *
 * 版本信息：
 * 日期：2013年10月29日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：File类方法操作
 * 创建人：成如
 * 创建时间：2013年10月29日 下午6:40:59
 * 修改人：成如
 * 修改时间：2013年10月29日 下午6:40:59
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class FileExam {
	Logger log = Logger.getLogger(FileExam.class);
	
	String basePath = "G:\\test";
	File file = new File(basePath + "\\123.txt");
	File file2 = new File("filetest.xml");
	File file3 = new File(basePath + "\\ru1");
	@Test
	public void file1() throws IOException{
		log.debug("******文件名相关方法******");
		//得到文件名称，如果是文件返回文件名，如果是路径返回最后以及子路径名称
		System.out.println("文件名：" + file.getName());
		System.out.println("父目录(完整路径)：" + (new File("G:/test/ru")).getParent());
		System.out.println("file对应文件路径：" + file.getPath());
		System.out.println("file的绝对路径:" + file2.getAbsolutePath());
		//得到当前file的绝对路径file
		//file2.createNewFile();
		File fileAbsolute = file2.getAbsoluteFile();
		System.out.println("通过绝对路径file得到的是绝对路径而不是原来的相对路径：" + fileAbsolute.getPath());
		System.out.println("得到父目录的完整路径： " + file3.getParent());
		System.out.println("重命名文件或路径名称：" + file.renameTo(new File("F:\\test")));
		
		
		log.info("******文件检测相关方法******");
		System.out.println("判断file对应的文件或目录是否存在: " + file.exists());
		System.out.println("判断file对应的文件或目录是否可写：" + file.canWrite() + " 是否可执行："
				+ file.canExecute() + " 是否可读：" + file.canRead());
		System.out.println("判断file是否是文件(不存在或不是文件时返回false)：" + (new File("oooooooo")).isFile() + " 是否是目录：" + file.isDirectory());
		System.out.println("判断file对应文件或目录是否是绝对路径：" + file.isAbsolute());
		
		
		log.info("******获取文件信息相关方法******");
		System.out.println("返回文件的最后修改时间（毫秒）：" + file.lastModified());
		System.out.println("返回文件内容长度(字节)：" + file.length());
		
		
		log.info("******文件操作相关方法******");
		System.out.println("创建新文件(1不存在文件时创建新文件返回true2存在文件时不创建文件返回false3只创建文件不创建目录"
				+ "4如果文件所在目录不存在要先创建目录然后创建文件（否则报错）)："
				+ (new File("G:\\test\\ru.java")).createNewFile());
		System.out.println("删除文件或目录(删除目录时如果目录下有其他文件要先删除文件然后删除目录，否则返回false不报错)："
				+ (new File("G:\\test")).delete());
		System.out.println("创建临时文件(file必须制定一个存在的目录否则报错)：" + File.createTempFile("ruye", ".tmp",new File("G:\\test")));
		
		
		log.info("******目录操作相关方法******");
		System.out.println("创建新目录(mkdir只能生成存在目录的下级目录不能生成多层目录)：" + new File("G:\\test\\ru\\ru1\\ru2").mkdir());
		System.out.println("创建新目录(mkdirs可以生成多层目录，如果目录存在返回false)：" + new File("G:\\test\\ru2\\ru3\\ru4\\").mkdirs());
		
		//得到文件和文件夹名数组
		String[] fileList = new File(basePath).list();
		for(String file : fileList){
			System.out.println("文件名：" + file);
		}
		
		//得到所有文件File对象
		File[] files = new File(basePath).listFiles();
		for(File file : files){
			System.out.println("file对象的绝对路径：" + file.getPath());
		}
		
		//得到所有的根目录file
		File[] rootFils = File.listRoots();
		for(File file : rootFils){
			System.out.println("根目录：" + file.getPath());
		}
		
	}
}
