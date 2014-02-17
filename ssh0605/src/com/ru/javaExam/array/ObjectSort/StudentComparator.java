/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.array.ObjectSort;

import java.util.Comparator;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：student对象的比较类(实现comparator或者comparable)
 * 创建人：成如
 * 创建时间：2013-9-4 下午2:59:57
 * 修改人：成如
 * 修改时间：2013-9-4 下午2:59:57
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class StudentComparator implements Comparator<Student>{

	private int compareWith = 0;
	public static int COMPAREWITHNAME = 0;
	public static int COMPAREWITHAGE = 1;
	public static int COMPAREWITHSCHOOLING = 2;
	
	/**
	 * 创建一个新的实例 StrudentComparator.
	 *
	 * @param compareWith
	 */
	public StudentComparator(int compareWith) {
		super();
		this.compareWith = compareWith;
	}

	/* (方法重写)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Student o1, Student o2) {
		
		int result = 0;
		switch(compareWith){
		case 0:
			result = compareWithName(o1,o2);
			break;
		case 1:
			result = compareWithAge(o1,o2);
			break;
		case 2:
			result = compareWithASchooling(o1,o2);
			break;
		default:
			break;
		}
		return result;
	}
	
	//使用姓名比较时
	public int compareWithName(Student s1,Student s2){
		return s1.getName().compareTo(s2.getName());
	}
	
	//使用年龄比较
	public int compareWithAge(Student s1,Student s2){
		return s1.getAge() - s2.getAge();
	}
	
	//使用学费比较
	public int compareWithASchooling(Student s1,Student s2){
		return (int) (s1.getSchooling() - s2.getSchooling());
	}
}
