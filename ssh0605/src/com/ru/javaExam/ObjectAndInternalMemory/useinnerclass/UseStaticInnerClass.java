/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory.useinnerclass;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-6 下午6:07:34
 * 修改人：成如
 * 修改时间：2013-9-6 下午6:07:34
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class UseStaticInnerClass {

	@Test
	public void test(){
		StaticOut.StaticIn in = new StaticOut.StaticIn();
	}
}

class StaticOut{
	
	static class StaticIn{
		
		public StaticIn(){
			System.out.println("静态内部类!");
		}
	}
}
