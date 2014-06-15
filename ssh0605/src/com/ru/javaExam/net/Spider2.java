package com.ru.javaExam.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Spider2 {

	//1创建url
	//2得到输入流
	//3读取每行数据、获取需要的信息
	//4保存数据
	public static void main(String[] args) {
		//需要爬取的地址
		String urlStr = "http://www.cnblogs.com/ywl925/p/3270875.html";
		//web页面内容
		String webContent = null;
		//保存内容的文件路径
		String filePath = "H:/test/datatang.html";
		//模拟浏览器
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) "
				+ "Chrome/29.0.1547.66 Safari/537.36";//模拟浏览器
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		    connection.setReadTimeout(30000);
		    connection.setConnectTimeout(30000);
		    connection.setRequestProperty("User-agent",userAgent);
		    connection.connect();
		    //web页面内容
		    webContent = getWebContent(connection.getInputStream());
		    System.out.println("内容：" + webContent);
		    //写入文件
		    saveContentToFile(webContent, filePath);
		} catch (MalformedURLException e) {
			//url异常
			e.printStackTrace();
		} catch (IOException e) {
			//HttpURLConnection异常
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过url得到网页内容
	 * @return 网页内容
	 */
	public static String getWebContent(InputStream is){
		String line = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		try {
			while((line = br.readLine()) != null){
				sb.append(line).append("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 保存页面内容到文件
	 */
	public static void saveContentToFile(String content, String filePath){
		FileWriter fw = null;
		File file = new File(filePath);
		try {
			//如果文件不存在创建文件
			if(!file.exists()){
				file.createNewFile();
			}
			fw = new FileWriter(file);
			fw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
