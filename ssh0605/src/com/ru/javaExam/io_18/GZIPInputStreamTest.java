package com.ru.javaExam.io_18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.junit.Test;

/**
 * ʹ��GZIP���м�ѹ��
 * @author �ϳ���
 * */
public class GZIPInputStreamTest {
	
	/**
	 * ѹ���ļ�
	 * @param inputPath
	 * @param outputPath
	 * */
	public void GZIP(String inputPath,String outputPath) throws IOException{
		int len;
		BufferedInputStream bis1=null;
		BufferedOutputStream bos1=null;
		try {
			//ѹ���ļ�
			bis1=new BufferedInputStream(new FileInputStream(new File(inputPath)));
			byte[] buffer=new byte[1024];
			//���ѹ����,ѹ���ļ�
			bos1=new BufferedOutputStream(new GZIPOutputStream(
					new FileOutputStream(new File(outputPath))));
			while((len=bis1.read(buffer))>0){
				bos1.write(buffer,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bis1.close();
			bos1.close();
		}
	}
	
	/**
	 * ��ѹ�ļ�
	 * @param inPath
	 * @param outPath
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	public void unGZIP(String inPath,String outPath) throws FileNotFoundException, IOException{
		int len2;
		BufferedInputStream bis2=null;
		BufferedOutputStream bos2=null;
		try {
			//��ѹ�ļ�
			bis2=new BufferedInputStream(new GZIPInputStream(new FileInputStream(new File(inPath))));
			bos2=new BufferedOutputStream(new FileOutputStream(new File(outPath)));
			byte[] buffer2=new byte[1024];
			while((len2=bis2.read(buffer2))>0){
				bos2.write(buffer2, 0, len2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bis2.close();
			bos2.close();
		}
	}
	
	/**
	 * ������
	 * */
	@Test
	public void main() throws IOException{
		String inPath="D:\\���\\ϵͳ��Ӧ��\\Ӧ��\\DTLite4454-0316.exe";
		String outPath="E:\\�����ļ�\\a.gz";
		this.GZIP(inPath,outPath);
	}
	@Test
	public void main2() throws IOException{
		String inPath="E:\\�����ļ�\\a.gz";
		String outPath="E:\\�����ļ�\\a.exe";
		this.unGZIP(inPath, outPath);
	}
}
