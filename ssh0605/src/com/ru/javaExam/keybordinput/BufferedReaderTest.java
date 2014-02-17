/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.keybordinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-10-6 下午12:14:20
 * 修改人：成如
 * 修改时间：2013-10-6 下午12:14:20
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class BufferedReaderTest {

	@Test
	public void test1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*//输入两行
		String line1 = br.readLine();
		String line2 = br.readLine();
		
		System.out.println(line1 + "      " + line2);*/
		
		//逐行读取键盘输入
		String bufferStr = null;
		while((bufferStr = br.readLine()) != null){
			System.out.println("键盘输入：" + bufferStr);
		}
	}
}
