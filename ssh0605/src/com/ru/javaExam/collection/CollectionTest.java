/**
 * fileNmae：CollectionTest.java
 *
 * version：1.0
 * date：2013-7-3
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

/**
 * 
 * project name：ssh0605
 * class description：
 * author：nanchengru
 * create date：2013-7-3 下午04:32:34
 * uploader：nanchengru
 * upload date：2013-7-3 下午04:32:34
 * upload remark：
 * environment：jdk1.7
 */
public class CollectionTest {
	
	@Test
	public void test(){
		
		Collection arraylistCollection = new ArrayList();
		arraylistCollection.add("大师兄");
		arraylistCollection.add(6);
		System.out.println("arraylistCollection 集合长度是：" + arraylistCollection.size());
		arraylistCollection.remove(6);
		System.out.println("arraylistCollection 集合长度是：" + arraylistCollection.size());
		System.out.println("arraylistCollection 集合是否包含   大师兄    元素：" + arraylistCollection.contains("大师兄"));
		arraylistCollection.add("疯狂java讲义");
		System.out.println("arraylistCollection 集合:" + arraylistCollection);
		
		Collection hashsetCollection = new HashSet();
		hashsetCollection.add("疯狂java讲义");
		System.out.println("arraylistCollection是否包含hashsetCollection集合： " + 
				arraylistCollection.contains(hashsetCollection));
		hashsetCollection.add("轻量级javaEE企业应用实战");
		System.out.println("arraylistCollection是否包含hashsetCollection集合： " + 
				arraylistCollection.contains(hashsetCollection));
		arraylistCollection.removeAll(hashsetCollection);
		System.out.println("arraylistCollection 集合：" + arraylistCollection);
		arraylistCollection.clear();
		System.out.println("arraylistCollection 集合：" + arraylistCollection);
		arraylistCollection.retainAll(hashsetCollection);
		System.out.println("arraylistCollection 集合：" + arraylistCollection);
	}
}
