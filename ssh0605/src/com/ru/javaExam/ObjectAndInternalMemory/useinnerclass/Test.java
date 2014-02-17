/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory.useinnerclass;

import com.ru.javaExam.ObjectAndInternalMemory.innerclass.InnerClassTest;
import com.ru.javaExam.ObjectAndInternalMemory.innerclass.InnerClassTest.CowLeg;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：不加修饰符，默认这个类包内可以访问。
 * 创建人：成如
 * 创建时间：2013-9-5 上午9:44:24
 * 修改人：成如
 * 修改时间：2013-9-5 上午9:44:24
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Test {

	@org.junit.Test
	public void test(){
		//InnerClassTest.CowLeg cl = new InnerClassTest(122).new CowLeg(12, "balck");
		InnerClassTest ict = new InnerClassTest(12.3);
		CowLeg cl = ict.getCowLeg();
	}
	
}
