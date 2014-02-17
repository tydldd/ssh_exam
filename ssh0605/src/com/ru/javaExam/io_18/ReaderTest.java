package com.ru.javaExam.io_18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * 南成�?
 * @time 2013-2-9
 * */
public class ReaderTest {

/**
 * Bufferedreader\Writer事例,bufferedReader可以对文件提供缓存，提高传输速度
 * @param inPath
 * @param outPath
 * */
String inPath="D:\\test\\data.txt";
String outPath="D:\\test2\\b.txt";
@Test
public void t1() throws IOException{
	Reader br = null;
	Writer bw = null;
	try {
		File file=new File(inPath);
		br=new BufferedReader(new FileReader(file));//reader是字符流，InputStream是字节流
		char[] c=new char[5];//字符缓冲数组
		File file2=new File(outPath);
		//将文本写入字符输出流，缓冲各个字符，从�?提供单个字符、数组和字符串的高效写入
		bw = new BufferedWriter(new FileWriter(file2));
		int len;
		while((len=br.read(c))>0){
			bw.write(c, 0, len);
			//bw.flush();
		}
	} catch (FileNotFoundException e){
		e.printStackTrace();
	}finally{//�?��要关闭输入输出流，减少系统开�?
		bw.close();
		br.close();
	}
}
/**
 * StringReader\Writer实例
 * 
 * */
@Test
public void t2() throws IOException{
	BufferedReader br = null;
	BufferedWriter bw = null;
	try {
		File file=new File(inPath);
		br=new BufferedReader(new FileReader(file));//reader是字符流，InputStream是字节流
		char[] c=new char[5];//字符缓冲数组
		File file2=new File(outPath);
		//将文本写入字符输出流，缓冲各个字符，从�?提供单个字符、数组和字符串的高效写入
		bw = new BufferedWriter(new FileWriter(file2));
		String line;
		while((line = br.readLine()) != null && (line = br.readLine()) != ""){
			bw.write(line);
			//bw.flush();
		}
	} catch (FileNotFoundException e){
		e.printStackTrace();
	}finally{//�?��要关闭输入输出流，减少系统开�?
		bw.close();
		br.close();
	}
}

}
