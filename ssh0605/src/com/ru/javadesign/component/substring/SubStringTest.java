package com.ru.javadesign.component.substring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-7 下午05:56:48
 * 修改人：ru
 * 修改时间：2013-8-7 下午05:56:48
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class SubStringTest {
	
	@Test
	public void test(){
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 1000; i++){
			//HugeString hs = new HugeString();
			ImproveHugeString hs = new ImproveHugeString();
			list.add(hs.getSubString(0, 5));
		}
	}
}

/**
 * subString()方法，截取的字符串中会包含原字符串所有内容。当原字符串很大时，可能早成内存溢出
 */
class HugeString{
	private String str = new String(new char[10000000]);//一个很长的字符串
	public String getSubString(int begin, int end){//截取字符串，可能有溢出
		return str.substring(begin,end);
	}
}

/**
 * 这个类有对截取的字符串，使用没有内存泄漏的string构造函数重新生成字符串 
 */
class ImproveHugeString{
	private String str = new String(new char[100000]);
	public String getSubString(int begin, int end){
		return new String(str.substring(begin,end));
	}
}
