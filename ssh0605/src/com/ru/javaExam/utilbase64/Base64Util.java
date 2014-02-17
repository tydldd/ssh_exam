package com.ru.javaExam.utilbase64;

import com.jit.util.Base64;


public class Base64Util {
	
	/**
	 * Base64����
	 * @param str
	 * @return
	 */
	public static String encode(String val) {
		return Base64.encode(val.getBytes());
	}
	
	/**
	 * Base64����
	 * @param str
	 * @return
	 */
	public static byte[] decode(String val) {
		try {
			return Base64.decode(val.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
