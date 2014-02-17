/**
 * fileNmae：SetTest.java
 *
 * version：1.0
 * date：2013-7-3
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * project name：ssh0605
 * class description：
 * author：nanchengru
 * create date：2013-7-3 下午04:06:51
 * uploader：nanchengru
 * upload date：2013-7-3 下午04:06:51
 * upload remark：
 * environment：jdk1.7
 */
public class SetTest {
	
	@Test
	public void test(){
		Set<String> set = new HashSet<String>(Arrays.asList("a","b","c","d","e","f","g"));
		set.add("a");
		
		boolean b = set.add("a");
		System.out.println(b);
		for(String s : set){
			System.out.println(s);
		}
		
		System.out.println("****************************");
		Object[] str = set.toArray();
		for(Object ss : str){
			System.out.println(ss.toString());
		}
		
	}
	
	/**
	 * 
	 * hashSetTest(1、如果两个对象使用equals方法返回true,set集合不会存储第二个元素，如果为false，则可以添加成功
	 * 2、对于HashSet而言：两个对象必须在equals和hashCode两个方法都相同的情况下，才不被存储)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void hashSetTest(String s1){
		System.out.println("**************************************************");
		HashSet<String> hs = new HashSet<String>();
		
		String s2 = new String("111111111111");
		System.out.println(s1.hashCode() + "       " + s2.hashCode());
		boolean b = s1.equals(s2);
		System.out.println(b);
		hs.add(s1);
		boolean b2 = hs.add(s2);
		System.out.println(b2);
		if(s1.hashCode() == s2.hashCode() && b == true){
			System.out.println("HashSet不会存储equals和hashCode两个方法都相同的对象");
		}
		System.out.println("**************************************************");
		
		
	}
}
