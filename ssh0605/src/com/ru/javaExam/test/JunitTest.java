package com.ru.javaExam.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.ru.javaExam.utilofcmd.CmdExecutor;


/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-6 下午05:04:06
 * 修改人：ru
 * 修改时间：2013-8-6 下午05:04:06
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class JunitTest {
	//@Test
	public void test() throws ParseException{
		long currentTime = System.currentTimeMillis();
		String time = "2013-08-06 17:20:12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(time);
		System.out.println(date);
	}
	
	//@Test
	public void test2(){
		for(int i = 0; i < 10; i++){
			System.out.println(i);
			if(i == 5){
				break;
			}
		}
	}
	
	//@Test
	public void test3(){
		String cmd1 = "hostname";
		String cmd = "snmpwalk -v 3 -u snmptopwalkv3 -a MD5 -A 1qa2ws3ed4rf5tgtopwalk " +
				"-l authPriv -x DES -X snmptopwalk 192.168.16.100 .1.3.6.1.4.1.2021.4.6.0";
		System.out.println(CmdExecutor.exeCmdResultUTF8(cmd1));
	}
	
	@Test
	public void test4(){
		TreeMap<String, String> map = new TreeMap<String, String>();
		TreeMap<String, String> map2 = new TreeMap<String, String>();

		map.put("01", "ru");
		map.put("02", "ruge");
		System.out.println("map1 = " + map.size());
		for(Iterator it = map.keySet().iterator();it.hasNext();){
			String key = (String) it.next(); 
			if(key.equals("02")){
				String value = map.get(key);
				map2.put(key, value);
			}
		}
		
		/*while(it.hasNext()){
			System.out.println(map.remove(it.next()));
			it.next();
		}*/
		System.out.println("map2 = " + map2);
	}
}
