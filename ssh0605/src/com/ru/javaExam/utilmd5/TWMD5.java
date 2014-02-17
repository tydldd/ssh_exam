package com.ru.javaExam.utilmd5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密 .
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 工程名 ： FGapTac
 * <p>
 * 授权 : (C) Copyright topwalk Corporation 2006-2011
 * <p>
 * 公司 : 北京天行网安信息技术有限责任公司
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * <font color="#FF0000">注意: 本内容仅限于北京天行网安公司内部使用，禁止转发</font>
 * <p>
 * 
 * @version 1.0
 * @author zhanggang
 * @lastMonify 2011-7-24
 * @since JDK1.6
 */
public class TWMD5 {

	/**
	 * MD5加码。32位
	 * 
	 * @param inStr
	 * @return
	 */
	public static String getMD5Two(String inStr) {
		inStr += "TW";
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	public static String getMD5(String inStr) {
		inStr += "TW";
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		byte[] strTemp = inStr.getBytes();
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		String s = new String("123");
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + getMD5(s));
		System.out.println("MD5后：" + getMD5Two(s));
	}

}
