/**
 * 文件名：Music.java
 *
 * 版本信息：1.0
 * 日期：2013-6-26
 * Copyright ru Corporation 2013 版权所有
 *
 */
package com.ru.javaExam.polymorphism;


/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nanchengru
 * 创建时间：2013-6-26 下午06:16:16
 * 修改人：nanchengru
 * 修改时间：2013-6-26 下午06:16:16
 * 修改备注：
 * 环境：  jdk1.7
 */
class Instrument{
	public String ss = "乐器";
	public void play(Note n){
		System.out.println("instrument.play()");
	}
}

class Wind extends Instrument{
	public String s = "钢琴";
	public void play(Note n){
		System.out.println("wind.play()");
	}
}

public class Music {
	public static void tune(Instrument i){
		System.out.println(i.ss);
		i.play(Note.middle_c);
	}
	
	public static void main(String[] args){
		Wind w = new Wind();
		tune(w);
	}
}
