package com.ru.javaExam.io_18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * 读取二进制文�?
 * @author 南成�?
 * @param readPath
 * @return byte[] b
 * */
public class BinaryFile {
	String readPath="D:\\测试文件\\CerManageAction.class";
	@Test
	public void readBinaryFile() throws IOException{
		try {
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(new File(readPath)));
			byte[] b=new byte[bis.available()];//bis.available()用来产生适当的数组长�?
			bis.read(b);
			System.out.println(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//return b;
	}
}
