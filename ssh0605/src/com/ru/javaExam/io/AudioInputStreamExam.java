/**
 * 文件名：AudioInputStreamExam.java
 *
 * 版本信息：
 * 日期：2013年10月31日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013年10月31日 下午4:00:09
 * 修改人：成如
 * 修改时间：2013年10月31日 下午4:00:09
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class AudioInputStreamExam {
	
	@Test
	public void audioTest1(){
		File file = new File("G:\\test\\Don`t Lie On Me.mp3");
		if(!file.exists()){
			return;
		}
		
		//AudioInputStream ais = new AudioInputStream(new FileInputStream(file), format, length);
	}
}
