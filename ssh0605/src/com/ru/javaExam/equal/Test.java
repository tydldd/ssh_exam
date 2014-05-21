package com.ru.javaExam.equal;

import java.util.HashSet;
import java.util.Set;

public class Test {
	/**
	 * @param args add by zxx ,Dec 9, 2008
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Test().test());;
	}

	static int test()
	{
		int x = 1;
		try
		{
			System.out.println("test...");
			return x;
		}
		finally
		{
			System.out.println("finally...");
			++x;
			System.out.println("x = " + x + "!!");
			return x;
		}
	}

}
