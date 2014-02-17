/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.util;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-8-30 下午5:46:06
 * 修改人：成如
 * 修改时间：2013-8-30 下午5:46:06
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Test {

	@org.junit.Test
	public void test(){
		String sFRONT = "0.00" + "\n" + "0.00" + "\n" + "0.00" + "\n";
		System.out.println(sFRONT.split("\n").length);
	}
	
	public static boolean isNull(String s){
		return true;
	}
}
