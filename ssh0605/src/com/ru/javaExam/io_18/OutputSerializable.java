/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.ru.javaExam.entity.Person;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：序列化对象的输入输出
 * 创建人：成如
 * 创建时间：2013-8-30 上午10:32:27
 * 修改人：成如
 * 修改时间：2013-8-30 上午10:32:27
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class OutputSerializable {

	/**
	 * 
	 * (将序列化对象的二进制流输出到文件)
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void output(){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(OutputSerializable.class.getResource("/").getPath() +
							"com/ru/javaExam/util/PersonOutput.txt"));
			
			Person person = new Person("nan", 24, "北京");
			oos.writeObject(person);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * (从文件里得到对象)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void input(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					OutputSerializable.class.getResource("/").getPath() +
							"com/ru/javaExam/util/PersonOutput.txt"));
			
			Person person = (Person) ois.readObject();
			
			System.out.println("姓名：" + person.getName() + " age:" + person.getAge() +
					" address:" + person.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
