package com.ru.javaExam.net.multidown;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月10日 下午3:47:44
 * 修改人：nange
 * 修改时间：2014年3月10日 下午3:47:44
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class MultiDownload {
	public static void main(String[] args) throws IOException {
		//下载的线程数
		final int DOWN_THREAD_NUM = 5;
		//输入输出流数组
		InputStream[] inArr = new InputStream[DOWN_THREAD_NUM];
		//下载的文件路径
		String filePath = "H:/test/youdaoDict.exe";
		RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];
		URL url = new URL("http://dlsw.baidu.com/sw-search-sp/soft/37/11063/7z932.1886736134.exe");
		//打开第一个输入流才可以得到文件大小
		inArr[0] = url.openStream();
		URLConnection uc = url.openConnection();
		int fileLength = uc.getContentLength();
		System.out.println("文件大小：" +  fileLength);
		//创建一个临时文件
		outArr[0] = new RandomAccessFile(new File(filePath), "rw");
		for(int i = 0; i < fileLength; i++){
			outArr[0].write(0);
		}
		System.out.println("创建空文件完成，准备下载......");
		//每个输入流读取的文件大小
		long avgLen = fileLength / DOWN_THREAD_NUM;
		long remainder = fileLength % DOWN_THREAD_NUM;
		for(int i = 0; i < DOWN_THREAD_NUM; i++){
			if(i == 0){
				new Thread(new DownThread(i * avgLen, (i + 1) * avgLen, inArr[i], outArr[i])).start();
			}else if(i + 1 == DOWN_THREAD_NUM){
				inArr[i] = url.openStream();
				outArr[i] = new RandomAccessFile(new File(filePath), "rw");
				new Thread(new DownThread(i * avgLen, (i + 1) * avgLen + remainder, inArr[i], outArr[i])).start();
			}else{
				inArr[i] = url.openStream();
				outArr[i] = new RandomAccessFile(new File(filePath), "rw");
				new Thread(new DownThread(i * avgLen, (i + 1) * avgLen, inArr[i], outArr[i])).start();
			}
		}
		System.out.println("下载完成!");
	}
}

/**
 * 
 * 文件线程
 * @since  jdk1.7
 * @version 1.0
 */
class DownThread implements Runnable{
	long start = 0;
	long end = 0;
	InputStream in = null;
	RandomAccessFile out = null;
	int bufferLen = 4096;
	byte[] buffer = new byte[bufferLen];
	public DownThread(long start, long end, InputStream in, RandomAccessFile out){
		this.start = start;
		this.end = end;
		this.in = in;
		this.out = out;
	}
	@Override
	public void run() {
		try {
			System.out.println("文件起始位置：" + start + "   结束位置：" + end);
			in.skip(start);
			out.seek(start);
			//计算输入流读取的次数
			long conLen = end - start;
			
			long times = conLen / bufferLen + 4;
			System.out.println("读取次数：" + times + "     是否能整除：" + ((conLen % bufferLen) > 0) + "   次数：" + conLen / bufferLen);
			int byteLen = 0;
			for(int i = 0; i < times; i++){
				byteLen = in.read(buffer);
				if(byteLen == -1){
					break;
				}
				out.write(buffer, 0, byteLen);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}