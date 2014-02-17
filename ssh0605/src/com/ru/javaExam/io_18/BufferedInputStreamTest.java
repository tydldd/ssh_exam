package com.ru.javaExam.io_18;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class BufferedInputStreamTest {

	@Test
	public void test() throws IOException{
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file=new File("D:\\dfdf.txt");
			InputStream in=new FileInputStream(file);
			//bufferedInputStream鍙互涓鸿緭鍏ユ祦鎻愪緵缂撳啿鍖�?
			bis=new BufferedInputStream(in);
			byte[] buffer=new byte[1024];
			int length;
			bos=new BufferedOutputStream(new FileOutputStream(new File("E:\\test.java")));
			while((length=bis.read(buffer))>0){
				bos.write(buffer,0,length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			bos.close();
			bis.close();
		}
	}

}
