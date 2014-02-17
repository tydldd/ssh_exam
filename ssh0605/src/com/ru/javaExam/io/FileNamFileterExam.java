/**
 * 文件名：FileNamFileterExam.java
 *
 * 版本信息：
 * 日期：2013年10月30日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：文件名过滤实例
 * 创建人：成如
 * 创建时间：2013年10月30日 下午10:06:08
 * 修改人：成如
 * 修改时间：2013年10月30日 下午10:06:08
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class FileNamFileterExam {
	
	@Test
	public void test(){
		String path = "G:\\test\\";
		
		String[] files = (new File(path)).list(new MyFileNameFilter());
		
		for(String file : files){
			System.out.println("文件名：" + file);
		}
	}
}

//定义文件名过滤类
class MyFileNameFilter implements FilenameFilter{

	//dir表示源目录（G:\test）  name表示文件或目录名（test目录下的文件或目录）
	public boolean accept(File dir, String name) {
		System.out.println("文件路径：" + dir);
		
		if(name.endsWith(".java") || new File(dir.getPath() + "\\" +name).isDirectory()){
			return true;
		}
		return false;
	}
	
}
