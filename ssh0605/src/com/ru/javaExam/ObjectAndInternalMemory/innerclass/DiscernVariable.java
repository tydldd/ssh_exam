/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory.innerclass;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：内部类和外部类变量
 * 创建人：成如
 * 创建时间：2013-9-5 上午10:47:10
 * 修改人：成如
 * 修改时间：2013-9-5 上午10:47:10
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class DiscernVariable {

	//如果外部类属性、内部类属性与内部类方法里的局部属性同名，可以使用this和外部类类名.this.属性名 区分
	private String prop = "*外部类属性*";
	
	public class InnerClass{
		private String prop = "*内部类属性*";
		
		public void info(){
			String prop = "*内部类局部变量*";
			System.out.println("内部类局部变量：" + prop + "\n内部类属性：" + this.prop +
					"\n外部类属性： " + DiscernVariable.this.prop);
		}
	}
	
	@Test
	public void main(){
		InnerClass ic = new InnerClass();
		ic.info();
		System.out.println("-----" + ic.prop);
	}
}
