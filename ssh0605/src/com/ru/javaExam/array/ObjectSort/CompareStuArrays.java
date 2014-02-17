/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.array.ObjectSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 
 *  定义一个学生对象数组Student[] stu = new Student[5]，
 *  每个学生对象中存储着学生名称和学生年龄，
 *  分别根据学生名称和年龄对学生数组进行排序。
 * 
 * 创建人：成如
 * 创建时间：2013-9-4 下午3:24:48
 * 修改人：成如
 * 修改时间：2013-9-4 下午3:24:48
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class CompareStuArrays {

	@Test
	public void test(){
		Student[] stu = new Student[4];
		
		Student s1 = new Student();
		s1.setName("nancr");
		s1.setAge(24);
		s1.setSchooling(10000);
		
		Student s2 = new Student();
		s2.setName("renhui");
		s2.setAge(26);
		s2.setSchooling(5000);
		
		Student s3 = new Student();
		s3.setName("zhangdc");
		s3.setAge(26);
		s3.setSchooling(6000);
		
		Student s4 = new Student();
		s4.setName("guoyj");
		s4.setAge(25);
		s4.setSchooling(7000);
		
		stu[0] = s1;
		stu[1] = s2;
		stu[2] = s3;
		stu[3] = s4;
		
		//对student数组按照不同的要求排序
		
		//1.按照数组
		//[1]、按姓名
		//Arrays.sort(stu, new StudentComparator(StudentComparator.COMPAREWITHNAME));
		//[2]、按年龄
		//Arrays.sort(stu, new StudentComparator(StudentComparator.COMPAREWITHAGE));
		//[3]、按学费
		//Arrays.sort(stu, new StudentComparator(StudentComparator.COMPAREWITHSCHOOLING));
		
		//2.按列表
		List<Student> list = Arrays.asList(stu);
		Collections.sort(list, new StudentComparator(StudentComparator.COMPAREWITHSCHOOLING));
		
		for(Student st : list){
			System.out.println(st.getName() + "   " +st.getAge() + "   " + st.getSchooling());
		}
	}
}
