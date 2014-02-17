package com.ru.javaExam.string;

import java.util.Random;

/**
 * .
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 工程名 ： dtiutil
 * <p>
 * 授权 : (C) Copyright topwalk Corporation 2006-2009
 * <p>
 * 公司 : 北京天行网安信息技术有限责任公司
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * <font color="#FF0000">注意: 本内容仅限于北京天行网安公司内部使用，禁止转发</font>
 * <p>
 * 
 * @version 1.0
 * @author 罗超伟
 * @lastMonify 2011-9-9
 * @since JDK1.6
 */
public class StringUtil {

	private static long seq = 11110;
	/**
	 * 判断字符串是否为空（null，""和只有空格的字符串，都视为空）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || str.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否为空（null，""和只有空格的字符串，都视为空）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object str) {
		if (null == str || str.toString().trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 生成18位字符串主键
	 * @return
	 */
	public synchronized static String getSequences() {
		long millis = System.currentTimeMillis();
		String sequences = millis + "" + (++StringUtil.seq);
		if (StringUtil.seq >= 99999) {
			StringUtil.seq = 11110;
		}
		return sequences;
	}
	
	/**
	 * 生成15位字符串主键
	 * @return
	 */
	public synchronized static String getSequences2() {
		Random ran = new Random();
		double i1 = ran.nextDouble();
		
		String s1 = (i1 * 100 + "").substring(0, 2);
		long millis = System.currentTimeMillis();
		String sequences = millis + "" + s1;
		
		return sequences;
	}

	/**
	 * 去除字符串右边空格
	 * 
	 * @param source
	 *            源字符串
	 * @return 去掉右边空格后的新字符串
	 */
	public static String rightTrim(String source) {
		return source.replaceAll(" *$", "");
	}
	
	/** The random. */
	final static Random random = new Random();

	/** 随机生成字符串 */
	public static String getRandomValue(int len) {
		StringBuffer key = new StringBuffer();
		for (int i = key.length(); i < len; i++) {
			key.append(random.nextInt(10));
		}
		return key.toString();
	}

	public static void main(String[] args) {
		System.out.println(StringUtil.getRandomValue(3));
	}
	
	
	/**
	 * 随机创建数据库9位ID
	 * 
	 * @return String 9位随机数ID
	 */
	public synchronized static String generate9() {
		int   n   =   (int)   (Math.random()   *   900000000)   +   100000000;
		return n+"";
	}
	

}
