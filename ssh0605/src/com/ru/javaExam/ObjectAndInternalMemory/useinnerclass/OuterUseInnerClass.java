/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory.useinnerclass;

import org.antlr.grammar.v3.LeftRecursiveRuleWalker.outerAlternative_return;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：外部类以外的类使用内部类
 * 创建人：成如
 * 创建时间：2013-9-5 下午3:48:29
 * 修改人：成如
 * 修改时间：2013-9-5 下午3:48:29
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class OuterUseInnerClass {

	@Test
	public void test(){
		//1、外部类以外的类使用内部类的方法
		Out.In in = new Out().new In("ru");
		
		//2、上面代码可以分解成下面三行代码
		Out.In in2;
		Out out = new Out();//内部类存在于外部类对象中，所以必须先实例化外部类对象
		in2 = out.new In("ru");
		
		in.test();
	}
	
}

class Out{
	
	class In{
		private String name;
		
		/**
		 * 构造函数  in.
		 *
		 * @param name
		 */
		public In(String name) {
			super();
			this.name = name;
		}

		public void test(){
			System.out.println("姓名：" + name);
		}
		
	}
}
