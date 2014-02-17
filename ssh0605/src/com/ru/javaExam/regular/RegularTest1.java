package com.ru.javaExam.regular;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-7-29 下午02:41:34
 * 修改人：ru
 * 修改时间：2013-7-29 下午02:41:34
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class RegularTest1 {
	Logger log = Logger.getLogger(RegularTest1.class);
	
	/**
	 * 
	 * (* 	匹配前面元字符0次或多次
	 *   \ 的使用，可以是去掉字符的原意，变成一个普通字符 )
	 * @param  
	 * @return 
	 * @throws
	 */
	public void test(){
		//"\"
		log.info("'\\'的使用，可以是去掉字符的愿意，变成一个普通字符");
		
		String s1 = "aaa";
		String s2 = "aaaaaaa";
		String s3 = "a*";
		String s4 = "";
		String reg1 = "a*";
		String reg2 = "a\\*";
		
		log.info("reg1 = " + reg1) ;
		log.info("aas匹配：" + Pattern.matches(reg1,s1) + "   aasqqqq匹配：" + Pattern.matches(reg1,s2)
				+ "  a*匹配：" + Pattern.matches(reg1,s3));
		log.info("reg2 = " + reg2) ;
		log.info("aas匹配：" + reg2.matches(s1) + "   aasqqqq匹配：" + reg2.matches(s2)
				+ "  a*匹配：" + s3.matches(reg2) + " ‘’匹配" + s4.matches(reg2));
		
	}
	
	/**
	 * 
	 * ( ^ 匹配输入字符串的开始位置 )
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void test2(){
		log.info(" ^ 匹配输入字符串的开始位置");
		
		String s1 = "aaa";
		String s2 = "Aaa";
		String reg = "^a*";
		
		log.info("reg : " + reg);
		log.info("aaa匹配：" + s1.matches(reg) + "    Aaa匹配  ：" + s2.matches(reg));
	}
	
	/**
	 * 
	 * ( $ 匹配一个输入或一行的结尾 )
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void test3(){
		log.info(" $ 匹配一个输入或一行的结尾，/a$/匹配'An a'，而不匹配'an A' ");
		
		String s1 = "gergrttttttta";
		String s2 = "Aa各方共同付";
		String reg = "[a-zA-Z]*a$";
		
		log.info("reg : " + reg);
		log.info("gergrttttttta匹配：" + s1.matches(reg) + "    Aa各方共同付   匹配  ：" + s2.matches(reg));
	}
	
	/**
	 * 
	 * ( + 匹配前面的子表达式一次或多次  :+ 和 * 的区别是+至少有一个子表达式)
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void test4(){
		log.info(" $ 匹配一个输入或一行的结尾，/a$/匹配'An a'，而不匹配'an A' ");
		
		String str[] = {"gouououooooooo","gou","g"};
		
		String reg = "^g[ou]+";
		
		log.info("reg : " + reg);
		for(String s : str){
			log.info(s + " 的匹配结果： " + s.matches(reg));
		}
	}
	
	//@Test
	public void test5(){
		log.info("{m,n}匹配自表达式n-m次");
		String reg = "^fo{0,1}d$";
		String[] str = {"fd","fod","food",};
		
		for(String s : str){
			log.info(s + "  :" + s.matches(reg));
		}
	}
	
	/**
	 * 
	 * ( .的使用。匹配除“\n”之外的任何单个字符。要匹配包括“\n”在内的任何字符，请使用像“(.|\n)”的模式 )
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void test6(){
		log.info(".的使用");
		
		String reg = "(.|\n)ru";
		String[] str = {"1ru","2ru","3","\nru"};
		
		for(String s : str){
			log.info(s + " : " + s.matches(reg));
		}
		
	}
	
	/**
	 * 
	 * ( (?:pattern)使用方法：匹配pattern但不获取匹配结果，也就是说这是一个非获取匹配，不进行存储供以后使用。 )
	 * @param  
	 * @return 
	 * @throws
	 */
	//@Test
	public void test7(){
		log.info("(?:pattern)的使用");
		String reg = "todayis(?:a|aa)sunnyday";
		String[] str = {"todayisasunnyday","todayisaasunnyday","todayisa","asunnyday"};
		
		for(String s : str){
			log.info(s + " : " + s.matches(reg));
		}
	}
	
	@Test
	public void test8(){
		String reg = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		String ip = "";
		System.out.println(ip.matches(reg));
	}
	
}
