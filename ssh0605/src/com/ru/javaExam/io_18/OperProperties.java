package com.ru.javaExam.io_18;
	import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

	/**
	 * @author nancr
	 * @lastModeify 2013-2-19
	 */
	public class OperProperties {
		
		/**
		 * 读取properties或者ini配置文件
		 * @param key 属性键值 
		 * @param filePath 文件路径
		 * @return value
		 */
		public static String readData(String key,String filePath) {
			
			
			Properties props = new Properties();
			try {
				InputStream in = new BufferedInputStream(new FileInputStream(filePath));
				props.load(in);
				in.close();
				String value = props.getProperty(key);
				return value;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		
		/**
		 * 
		 * writeData(写入properties或者ini文件：这个操作会先删除源文件内容，重新)
		 * @param key 键值
		 * @param value
		 * @param filePath
		 * @return void
		 */
		public static void writeData(Map<String, String> map,String filePath) {
			Properties prop = new Properties();
			try {
				File file = new File(filePath);
				if (!file.exists())
					file.createNewFile();
				InputStream fis = new FileInputStream(file);
				prop.load(fis);
				fis.close();
				OutputStream fos = new FileOutputStream(filePath);
				for(Iterator it = map.keySet().iterator(); it.hasNext();){
					String key = (String) it.next();
					String value = map.get(key);
					prop.setProperty(key, value);
				}
				
				prop.store(fos, "OGG config file ,replicat is a number");
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * writeData(写入属性)
		 * @param key
		 * @param value
		 * @param filePath
		 * @return void
		 */
		public static void writeData(String key, String value, String filePath) {
			Properties prop = new Properties();
			try {
				File file = new File(filePath);
				if (!file.exists())
					file.createNewFile();
				InputStream fis = new FileInputStream(file);
				prop.load(fis);
				fis.close();
				OutputStream fos = new FileOutputStream(filePath);
					
				prop.setProperty(key, value);
				
				prop.store(fos, "OGG config file ,replicat is a number");
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void test(){
			String path = "F:\\testSpace\\task_src.ini";
			String key ="task_name2";
			String value = "ru";
		}
	}
