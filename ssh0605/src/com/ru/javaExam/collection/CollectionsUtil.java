/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-10-3 下午8:03:42
 * 修改人：成如
 * 修改时间：2013-10-3 下午8:03:42
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class CollectionsUtil {
	
	/**
	 * 
	 * (创建线程同步的集合)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void synchronizeForC(){
		Collection c = Collections.synchronizedCollection(new ArrayList());//线程安全的数组列表
		List<String> list = Collections.synchronizedList(new ArrayList<String>());//
		Set<String> set = Collections.synchronizedSet(new HashSet<String>());
		Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
		
	}
	
	/**
	 * 
	 * (不可变集合)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void unmodifiableTest(){
		Set<String> set = new HashSet<String>();
		set.add("123");
		set.add("456");
		set.add("789");
		Set<String> set2 = Collections.emptySet();//空的不可变set
		//set2.add("ddd");抛出异常
		System.out.println(set2);
		
		Set<String> set3 = Collections.singleton("rushen");//只用一个元素的不可变set
		//set3.add("wss");抛出异常
		System.out.println(set3);
		
		Set<String> set4 = Collections.unmodifiableSet(set);//指定set元素的不可变set
		//set4.add("qaz");异常
		System.out.println(set4);
		System.out.println("set = " + set);
	}
}
