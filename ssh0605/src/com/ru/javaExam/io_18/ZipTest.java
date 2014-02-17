package com.ru.javaExam.io_18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

/**
 * 使用Zip实现多文件保�?
 * @author 南成�?
 * */
public class ZipTest {
	
	/**
	 * 压缩文件
	 * @param String String...
	 * @throws IOException 
	 * */
	public void zipCompress(String outPath,String... inPaths) throws IOException{
		int len;
		//压缩输出�?
		try {
			FileOutputStream fos=new FileOutputStream(outPath);
			CheckedOutputStream cos=new CheckedOutputStream(fos, new Adler32());//返回文件校验�?
			ZipOutputStream zos=new ZipOutputStream(cos);
			BufferedOutputStream bos=new BufferedOutputStream(zos);
			if(inPaths!=null){
				for(String s:inPaths){
					BufferedInputStream bis=new BufferedInputStream(new FileInputStream(s));
					//每一个输出文件都必须调用putNextEntry，并将其放入ZipEntry�?
					zos.putNextEntry(new ZipEntry(s));
					byte[] buffer=new byte[1024];
					while((len=bis.read(buffer))>0){
						bos.write(buffer,0,len);
					}
					 bis.close();
					 bos.flush();
				}
			}
			//校验�?
			System.out.println("校验�?"+cos.getChecksum().getValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解压文件??
	 * @throws IOException 
	 * */
	public void zipUnCompress(String inPath) throws IOException{
		int len;
		try {
			FileInputStream fis=new FileInputStream(inPath);
			CheckedInputStream cis=new CheckedInputStream(fis, new Adler32());
			ZipInputStream zis=new ZipInputStream(cis);
			BufferedInputStream bis=new BufferedInputStream(zis);
			ZipEntry ze;//文件实体
			while((ze=zis.getNextEntry())!=null){
				byte[] buffer=new byte[1024];
				//BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(outPath)));
				while((len=bis.read(buffer))>0){
					//bos.write(buffer,0,len);
					System.out.println("dfd");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void run1() throws IOException{
		String outPath="E:\\测试文件\\zipcompress.zip";
		String inPath1="D:\\测试文件\\a.txt";
		String inPath2="D:\\测试文件\\b.txt";
		//String inPath3="D:\\软件\\学习和编程\\dwcs6\\Dreamweaver_12_LS3.exe";
		this.zipCompress(outPath, inPath1,inPath2);
	}
	
	@Test
	public void run2() throws IOException{
		//String outPath="E:\\测试文件\\compress\\a";
		String inPath="E:\\测试文件\\zipcompress.zip";
		this.zipCompress(inPath);
	}
}
