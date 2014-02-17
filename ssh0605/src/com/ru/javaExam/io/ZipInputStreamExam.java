/**
 * 文件名：ZipInputStreamExam.java
 *
 * 版本信息：
 * 日期：2013年10月31日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;
import org.apache.tools.ant.types.ZipFileSet;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：压缩解压文件和目录
 * 创建人：成如
 * 创建时间：2013年10月31日 下午10:25:51
 * 修改人：成如
 * 修改时间：2013年10月31日 下午10:25:51
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
@SuppressWarnings("all")
public class ZipInputStreamExam {
	static Logger log = Logger.getLogger(ZipInputStream.class);
	
	/**
	 * 
	 * compressFiles(1、压缩多个文件)
	 * @param destPath
	 * @param files
	 * @return void
	 * @throws IOException 
	 */
	public static boolean compressFiles(String destPath, String... files) throws IOException{
		int flag = 0;
		ZipOutputStream zos = null;
		InputStream is = null;
		byte[] buffer = new byte[1024];//缓冲数组
		try {
			//创建zip流，并使用CRC32设置冗余校验码
			zos = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(destPath), new CRC32()));
			
			for(String file : files){
				File newFile = new File(file);
				if(!newFile.exists()){
					break;
				}
				//将需要压缩的文件entry放入zos中
				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);
				
				//写入文件
				is = new FileInputStream(newFile);
				int length = 0;
				while((length = is.read(buffer)) != -1){
					zos.write(buffer, 0, length);
				}
				flag++;
			}
			
			if(flag == files.length){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(zos != null){
				zos.close();
			}
			if(is != null){
				is.close();
			}
			
		}
		return false;
	}
	
	/**
	 * 
	 * zipFileAndDir(2、压缩文件和目录)
	 * @param zipFile 压缩成的zip文件
	 * @param files 被压缩的文件或目录的绝对路径
	 * @return void
	 * @throws IOException 
	 */
	public static boolean zipFileAndDir(String zipFile, String... files) throws IOException{
		int flag = 0;
		ZipOutputStream zos = null;
		try {
			//zip文件输出流
			zos = new ZipOutputStream(new FileOutputStream(zipFile));
			for(String file : files){
				File newFile = new File(file);
				if(!newFile.exists()){
					break;
				}
				String basePath = newFile.getParent() + "\\" + newFile.getName();//设置压缩文件里面的根目录
				
				//压缩文件
				compress(newFile, basePath, zos);
				
				flag++;
			}
			
			if(flag == files.length){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(zos != null){
				zos.close();
			}
		}
		
		return false;
	}
	
	
	
	/**
	 * 
	 * compress(压缩文件和目录注：中文目录为空时，生成文件)
	 * @param file 被压缩的目录
	 * @param basePath 压缩文件里的路径（""）
	 * @param zos zip输出流
	 * @throws IOException
	 * @return void
	 */
	private static void compress(File file,  String basePath, ZipOutputStream zos) throws IOException{
		
		InputStream is = null;
		ZipEntry ze = null;
		byte[] buffer = new byte[1024];
		int length = 0;
		
		if(file.isDirectory()){//假如file是目录：1、添加entry，不写入zip文件2、循环遍历目录下的所有文件或文件夹
			ze = new ZipEntry(basePath + "\\");
			zos.putNextEntry(ze);
			
			//遍历目录
			File[] files = file.listFiles();
			for(File fl : files){
				compress(fl, basePath + "\\" + fl.getName(), zos);
			}
		}else if(file.isFile()){//如果是文件，添加entry并写入zip文件
			ze = new ZipEntry(basePath);
			zos.putNextEntry(ze);
			
			is = new FileInputStream(file);
			while((length = is.read(buffer)) > 0){
				zos.write(buffer, 0, length);
			}
			
			if(is != null){
				is.close();
			}
		}
		
		
	}
	
		
	/**
	 * 
	 * uncompress(3、解压文件或目录到源目录)
	 * @param zipFile zip文件
	 * @param destPath 解压缩到的目的目录
	 * @return void
	 * @throws IOException 
	 */
	public static void uncompressFilesAndDirs(String zipFileStr) throws IOException{
		//zip文件不存在跳出
		File zipFile = new File(zipFileStr);
		if(!zipFile.exists()){
			return;
		}
		
		uncom(zipFile);
	}
	
	/**
	 * 
	 * uncom(解压entry)
	 * @param zipFile 压缩文件
	 * @param destPath 解压缩到的目的目录
	 * @throws IOException
	 * @return void
	 */
	public static void uncom(File zipFile) throws IOException{
		ZipInputStream zis = null;
		try {
			zis = new ZipInputStream(new CheckedInputStream(new FileInputStream(zipFile), new CRC32()));
			
			java.util.zip.ZipEntry ze = null;
			while((ze = zis.getNextEntry()) != null){
				uncompress(zis, ze.getName());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			zis.close();
		}
	}
	
	/**
	 * 
	 * uncompress(解压一个文件或目录entry)
	 * @param zis
	 * * @param destPath 解压缩到的目的目录
	 * @return void
	 * @throws IOException 
	 */
	public static void uncompress(ZipInputStream zis, String unZipFile) throws IOException{
		//路径分隔符（,windowns：\\,linux :/）
		String seperatot = "\\";
		OutputStream os = null;
		byte[] buffer = new byte[1024];
		int length = 0;
		
	/*	//处理解压到的目录
		String destPathStr = "";
		if(destPath == null || destPath.equals("")){
			destPathStr = "";
		}else{
			File destFile = new File(destPath);
			if(!destFile.exists()){
				destFile.mkdirs();
			}
			destPathStr = destFile.getParent()+  seperatot + destFile.getName() + seperatot;
		}*/
		
		
		try {
			if(unZipFile.endsWith(seperatot)){//假如entry是文件夹
				File dir = new File(unZipFile);
				boolean isCreate = false;
				if(!dir.exists()){
					isCreate = dir.mkdirs();//创建目录
				}
				
				System.out.println("创建结果：" + isCreate);
			}else{//假如entry是文件，输出文件到制定目录
				os = new FileOutputStream(unZipFile);
				while((length = zis.read(buffer)) != -1){
					os.write(buffer, 0, length);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(os != null){
				os.close();
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		String basePath = "G:/test/uncompress";
		//生成压缩文件
		String destPath = "G:/test/compress-1.zip";
		String sourpath1 = "G:/test/music.mp3";
		String sourpath2 = "G:/test/ru1.java";
		String sourpath3 = "G:/test/music.zip";
		String sourpath4 = "G:/test/ru/";
		String sourpath5 = "G:/test/ruye/";
		//compressFiles(destPath, sourpath1, sourpath2, sourpath3, sourpath4);
		//zipFileAndDir(destPath, sourpath1,sourpath2, sourpath4, sourpath5);
		
		//解压文件
		uncompressFilesAndDirs(destPath);
	}
}
