/**
 * 文件名：HashMapTest.java
 *
 * 版本信息：
 * 日期：2013-6-21
 * Copyright 足下 Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：HashMap类
 * 创建人：nanchengru
 * 创建时间：2013-6-21 下午02:19:50
 * 修改人：nanchengru
 * 修改时间：2013-6-21 下午02:19:50
 * 修改备注：
 * 环境：  jdk1.7
 * 版本：    1.0
 */
public class HashMapTest {
	
	/**
	 * 
	 * 对hashMap初始化时，数组会创建一个长度为capacity的Entry的数组，这个数组用来存储value
	
	 * @param  
	
	 * @return 
	
	 * @throws
	 */
	public static void main(String[] args){
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("语文", 99.9);
		map.put("数学", 99.0);
		map.put("英语", 99.7);
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object obj = it.next();
			System.out.println("hash码：" + obj.hashCode());
			System.out.println(map.get(obj));
		}
		System.out.println(map.get("语文").equals(map.get("数学")));
		System.out.println(map.get("语文").equals(map.get("英语")));
		
	}
}
