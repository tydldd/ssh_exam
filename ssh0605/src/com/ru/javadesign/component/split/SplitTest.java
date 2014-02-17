package com.ru.javadesign.component.split;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-7 下午06:24:42
 * 修改人：ru
 * 修改时间：2013-8-7 下午06:24:42
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class SplitTest {
	
	/**
	 * 
	 * (  )
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test(){
		String str = "qwe;123;edf'90*fdfdf;--i";
		StringTokenizer st = new StringTokenizer(str, ";");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		System.out.println(str.split(";"));
	}
}
