/**
 * 文件名：switchTest.java
 *
 * 版本信息：1.0
 * 日期：2013-6-25
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.processcontrol;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：switch流程控制（switch后面的表达式的5种数据类型：byte、short、int、char、enum）
 * 创建人：nanchengru
 * 创建时间：2013-6-25 上午11:39:37
 * 修改人：nanchengru
 * 修改时间：2013-6-25 上午11:39:37
 * 修改备注：
 * 环境：  jdk1.7
 */
public class SwitchTest {
	
	/**
	 * 
	 * defaultTest(default分支的潜在条件是：表达式的值和前面分支的值都不相等。也就是说只有在前面的分支没有执行时，
	 * default分支才会执行)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void defaultTest(){
		char score = 'c';
		switch (score) {
		case 'a':
			System.out.println("优秀");
			break;
		case 'b':
			System.out.println("良好");
			break;
		case 'c':
			System.out.println("中");
			break;
		case 'd':
			System.out.println("及格");
			break;
		case 'e':
			System.out.println("不及格");
			break;

		default:
			System.out.println("成绩输入错误");
			break;
		}
	}
	
	/**
	 * 
	 * breakTest(break作用是跳出当前流程控制（switch），一旦找到对应的分支，程序将一直执行到最后，
	 * 	不再与各分支的比较值进行比较。
	 * 下面程序的执行结果是：
	 * 	中
		及格
		不及格
		成绩输入错误)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void breakTest(){
		char score = 'c';
		switch (score) {
		case 'a':
			System.out.println("优秀");
		case 'b':
			System.out.println("良好");
		case 'c':
			System.out.println("中");
		case 'd':
			System.out.println("及格");
		case 'e':
			System.out.println("不及格");

		default:
			System.out.println("成绩输入错误");
		}
	}
}
