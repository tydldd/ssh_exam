/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io_18;

import java.io.File;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-17 上午9:52:48
 * 修改人：成如
 * 修改时间：2013-9-17 上午9:52:48
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class IOTest {

	@Test
	public void test(){
		String path = "D:\\IOTest\\";
		
		File file = new File(path);
		
		System.out.println(file.exists());
		if(!file.exists()){
			file.mkdir();
		}
	}
}
