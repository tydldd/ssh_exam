/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.ObjectAndInternalMemory.useinnerclass;

import org.apache.log4j.Logger;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：外部类内部使用内部类
 * 创建人：成如
 * 创建时间：2013-9-5 上午9:44:48
 * 修改人：成如
 * 修改时间：2013-9-5 上午9:44:48
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Cow {

	Logger log = Logger.getLogger(Cow.class);
	private double weight;

	
	/**
	 * 构造函数 Cow.
	 *
	 * @param weight
	 */
	public Cow(double weight) {
		super();
		this.weight = weight;
	}
	
	/**
	 * 
	 * 类描述：非静态内部类
	 * @since jdk1.7
	 * @version 1.0
	 */
	public class CowLeg{
		private int length;
		private String color;
		
		/**
		 * 构造函数  CowLeg.
		 *
		 * @param length
		 * @param color
		 */
		public CowLeg(int length, String color) {
			super();
			this.length = length;
			this.color = color;
		}
		
		public void info(){
			log.info("牛信息:1体重：" + weight + "斤   2牛腿长：" + length + "厘米    3牛腿颜色：" + color + "色");
		}
		
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	}
	
	
	/**
	 * 
	 * (外部类内部使用内部类，与平常使用类方法没有区别)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void cow(){
		
		CowLeg cl = new CowLeg(110, "white");
		cl.info();
		
		//如果外部类需要使用内部类的属性，需要实例化内部类，通过内部类对象调用属性
		System.out.println("牛腿的长度：" + cl.length);
	}
	
	/**
	 * 
	 * (外部类不能直接使用内部类的属性，内部类可以直接使用外部类的属性。
	 * 其他类不能使用这个类的内部类属性
	 * )
	 * @param  
	 * @return 
	 * @throws
	 */
	public static void main(String[] args){
		Cow ict = new Cow(200.25);
		ict.cow();
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
