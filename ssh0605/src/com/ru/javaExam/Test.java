package com.ru.javaExam;

import java.util.HashSet;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年4月22日 上午10:39:23
 * 修改人：nange
 * 修改时间：2014年4月22日 上午10:39:23
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public abstract class Test {
	
	public int meth(int x){
		return x++;
	}

	final int i = 0;
    public void doSomething() {
        System.out.println("i = " + i);
    }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0;i<5;i++)
		{
			System.out.println(i);
		}
		//假设程序不小心多了一句--i;
		--i;
		assert i==5;		
	}

}
