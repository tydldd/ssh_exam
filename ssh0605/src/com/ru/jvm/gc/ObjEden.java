package com.ru.jvm.gc;

/**
 * 
 * 类描述：对象优先在eden分配，以及minor gc垃圾清理
 * jvm:-XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * @since  jdk1.7
 * @version 1.0
 */
public class ObjEden {

	private static int _1M = 1024 * 1024;
	
	public static void main(String[] args) {
		byte[] b1, b2, b3, b4;
		b1 = new byte[2 * _1M];
		b2 = new byte[2 * _1M];
		b3 = new byte[2 * _1M];
		b4 = new byte[3 * _1M];
	}
}
