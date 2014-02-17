/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.genericity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：不使用泛型，集合不知道元素类型，可能造成类型转换异常
 * 创建人：成如
 * 创建时间：2013-10-4 上午11:31:05
 * 修改人：成如
 * 修改时间：2013-10-4 上午11:31:05
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class ListError {
	
	/**
	 * 
	 * (不使用泛型)
	 * @param  
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("all")
	public void main(String[] args){
		
		List list = new ArrayList();
		list.add("ru");
		list.add("ruge");
		list.add("ruye");
		list.add(123);//保存进一个int类型的元素,进行类型转换时，抛出异常
		
		for(int i = 0; i < list.size(); i++){
			System.out.println((String)list.get(i));
		}
	}
	
	/** (使用泛型)
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void useGeneric(){
		List<String> list = new ArrayList<String>();
		list.add("ru");
		list.add("ruge");
		list.add("ruye");
//		list.add(123);//编译时出错
		
		for(String s : list){
			System.out.println(s);
		}
	}
}
