package com.ru.javaExam.io_18;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileInputStreamTest {

	@Test
	public void test() throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			int len;
			//字节输入�?
			fis=new FileInputStream(new File("D:\\a.txt"));
			//字节缓冲数组
			byte[] buffer=new byte[1024];
			fos=new FileOutputStream(new File("E:\\test2.txt"));
			while((len=fis.read(buffer))>0){
					fos.write(buffer,0,len);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			fis.close();
			fos.close();
		}
	}

}
