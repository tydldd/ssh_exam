package com.ru.javaExam.io_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class NameFileter implements FilenameFilter{
	//
	Pattern pattern;
	public	NameFileter(String reg){
		//将字符串类型的正则表达式实例�?
		pattern=Pattern.compile(reg);
	}
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}
