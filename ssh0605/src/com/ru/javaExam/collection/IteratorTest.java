/**
 * fileNmae：IteratorTest.java
 *
 * version：1.0
 * date：2013-7-3
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * project name：ssh0605
 * class description：
 * author：nanchengru
 * create date：2013-7-3 下午05:45:38
 * uploader：nanchengru
 * upload date：2013-7-3 下午05:45:38
 * upload remark：
 * environment：jdk1.7
 */
public class IteratorTest {
	
	@Test
	public void test(){
		Set set = new HashSet();
		set.add("qweasd");
		set.add(123);
		set.add("555");
		Iterator it = set.iterator();
		while(it.hasNext()){
			it.next();
		}
	}
}
