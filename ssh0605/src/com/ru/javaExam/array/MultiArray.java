package com.ru.javaExam.array;

import org.junit.Test;

/**
 * 
 * 
 * 项目名称：ssh0605
 * 类描述：多维数组(实质上是一个特殊的一维数组)
 * 创建人：nanchengru
 * 创建时间：2013-6-19 上午10:56:24
 * 修改人：nanchengru
 * 修改时间：2013-6-19 上午10:56:24
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class MultiArray {
	
	private String str;
	
	/**
	 * 
	 * int[]:表示int类型的一维数组，int[][]表示int[]类型的一维数组，int[][][]:表示int[][]类型的一维数组
	 * 
	 */
	public void multiArray() throws Exception{
		
		//定义一个二维数组,a存储在栈中。
		int[][] a;
		//把a当作一位数组动态初始化，初始化a为一个长度为4的数组
		a = new int[4][];
		System.out.println("a的长度：" + a.length + "   a[0]的长度：");
		for(int i = 0; i < a.length; i++){
			System.out.println("a:" + a[i]);
		}
		//初始化数组的第一个元素
		a[0] = new int[2];
		a[0][1] = 8;
		//遍历数组a的第一个元素
		for(int i = 0; i < a[0].length; i++){
			System.out.println("a[0] :" + a[0][i]);
		}
	}
	
	@Test
	public void test(){
		int[][][] arr = new int[3][2][4];
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[1].length);
	}
}
