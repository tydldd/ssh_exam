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
 * 类描述：静态内部类
 * 创建人：成如
 * 创建时间：2013-9-5 下午2:13:45
 * 修改人：成如
 * 修改时间：2013-9-5 下午2:13:45
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class StaticInnClass {

	private double weight;

	
	/**
	 * 构造函数  StaticInnClass.
	 *
	 * @param weight
	 */
	public StaticInnClass(double weight) {
		super();
		this.weight = weight;
	}
	
	public static class CowLeg{
		private int length;
		
		
		/**
		 * 构造函数  CowLeg.
		 *
		 * @param length
		 */
		public CowLeg(){
			
		}
		
		public CowLeg(int length) {
			super();
			this.length = length;
		}

		public void info(){
			//静态成员不能直接访问非静态成员,但可以通过实例化对象，间接调用
			StaticInnClass sic = new StaticInnClass(120.1);
			//System.out.println("牛的重量：" + weight);
			System.out.println("牛的重量：" + sic.weight);
		}
	}
	
	@Test
	public void test(){
		CowLeg cl = new CowLeg(80);
		System.out.println(cl.length);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
