/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.test;

import java.io.UnsupportedEncodingException;

import com.ru.javaExam.string.StringUtil;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-9-24 下午4:09:29
 * 修改人：成如
 * 修改时间：2013-9-24 下午4:09:29
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Test implements TestInter{
	
	/*public static void main(String[] args){
		String s = StringUtil.getSequences2();
		System.out.println(s);
		String[] ss = new String[12];
	}*/
	
	/**
	 * 
	 * getStr()
	 * @param ss
	 * @param ii
	 * @return String
	 */
	@org.junit.Test
	public void getStr(){
		/*String configPath = Test.class.getResource("/com/ru/javaExam/test/").getPath();
		System.out.println(configPath);*/
		String[] str = new String[5];
//        System.out.println(a);
	}
	
	@org.junit.Test
	public void byteTest() throws UnsupportedEncodingException{
		String ss = "wo爱1";
		byte[] strByte = ss.getBytes("GBK");
		for(byte b : strByte){
			System.out.println("  " + b);
		}
	}
	
//	@org.junit.Test
	public void charTest(){
		int intCount = 0;
		int chCount = 0;
		int enCount = 0;
		String str = "中国hello123";
		int len = str.length();
		for(int i = 0; i < len; i++){
			char ca = str.charAt(i);
			System.out.println(ca);
			if(ca >= '0' && ca <= '9'){
				intCount++;
			}else if((ca >= 'a' && ca <= 'z') || (ca >= 'A' && ca <= 'Z')){
				enCount++;
			}else{
				chCount++;
			}
		}
		
		System.out.println("中文字符个数：" + chCount + "   英文字符个数：" + 
				enCount + "  数字个数：" + intCount);
	}
}
