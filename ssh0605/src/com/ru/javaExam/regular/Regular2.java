package com.ru.javaExam.regular;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-5 上午09:44:20
 * 修改人：ru
 * 修改时间：2013-8-5 上午09:44:20
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Regular2 {
	public Logger log = Logger.getLogger(Regular2.class);
	
	@Test
	public void test(){
		String reg = "^\\w{5,15}";
		
		String str = "nan_chengru";
		System.out.println(str.matches(reg));
	};
}
