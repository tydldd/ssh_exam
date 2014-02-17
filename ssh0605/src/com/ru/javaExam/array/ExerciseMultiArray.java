/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：多维数组练习(屏幕输入)
 * 创建人：成如
 * 创建时间：2013-9-4 下午2:05:54
 * 修改人：成如
 * 修改时间：2013-9-4 下午2:05:54
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class ExerciseMultiArray {

	@Test
	public void test() throws IOException{
		String lineAndLie = null;
		int line = 0;
		int lie = 0;
		
		//获取屏幕输入的类
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//提示输入二维数组的行和列
		System.out.println("请分别输入数组的行和列，使用,分隔：");
		
		//得到数组的行和列
		lineAndLie = br.readLine();
		if(lineAndLie != null || lineAndLie.split(",").length == 2){
			
			String[] ll = lineAndLie.split(","); 
			line = Integer.parseInt(ll[0]);
			lie = Integer.parseInt(ll[1]);
		}else{
			
			System.out.println("输入有误！");
		}
		
		//依次输入数组各元素，并为数组赋值
		System.out.println("请输入数组各元素,回车依次输入:");
		int[][] arr = new int[line][lie];
		
		for(int n = 0; n < line; n++){
			for(int e = 0; e < lie; e++){
				int num = Integer.parseInt(br.readLine());
				arr[n][e] = num;
			}
		}
		
		//展示数组
		System.out.println("*************************数组int["+ line +"]["+ lie +"]展示****************************");
		for(int[] i : arr){
			for(int ii : i){
				System.out.println(ii);
			}
		}
		
	}
}
