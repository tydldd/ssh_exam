/**
 * 文件名：Test.java
 *
 * 版本信息：
 * 日期：2013年10月30日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;

import com.ru.ssh.JSOperate.entity.Student;


/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013年10月30日 下午10:37:51
 * 修改人：成如
 * 修改时间：2013年10月30日 下午10:37:51
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Test {

	@org.junit.Test
	public void test(){
		/*String[] ss = new File("G:\\test\\ru123").list();
		System.out.println(ss);
		
		String[] sss = {"1","2"};
		
		File file = new File("G:/test/ru.java");
		System.out.println(file.getParent());*/
		
		Student stu = new Student();
		System.out.println(stu.getAge() + "    " + stu.getName() + stu.getMajor());
	}
}
