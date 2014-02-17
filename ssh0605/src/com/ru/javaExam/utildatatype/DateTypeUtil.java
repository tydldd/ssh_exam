package com.ru.javaExam.utildatatype;

import java.text.DecimalFormat;

/**
 * 数据类型转换帮助类
 * 
 * @author 南成如
 * @since jdk7.0
 * @lastModify 2013-3-26
 * */
public class DateTypeUtil {
	
	
	//通过float值，返回流量信息
	public static String getFileFlowByFloatValue(float f){
		float maxFloat = 1024*1024*1024*1023.9999f;
		float K = 1024f;
		float M = 1024*1024f;
		float G = 1024 * 1024 * 1024f;
		float T = 1024*1024*1024*1024f;
		String fileFlowResult = null;
		float fileFlowInFloat = f;
		
		if(maxFloat < f){
			return "数值超出限定范围";
		}
		
		if(fileFlowInFloat < K){
			fileFlowResult =  formatFloat(fileFlowInFloat) + "B";
		}else if (fileFlowInFloat < M){
			fileFlowResult = formatFloat(fileFlowInFloat/K) + "K";
		}else if (fileFlowInFloat < G){
			fileFlowResult = formatFloat(fileFlowInFloat/M) + "M";
		}else if (fileFlowInFloat < T){
			fileFlowResult =formatFloat(fileFlowInFloat/G) + "G";
		}
		return fileFlowResult;
	}
	

	//将字符串准换成float
	public static float getFloatByString(String s){
		Float f = new Float(s);
		return f;
	}
	
	/**
	 * 设置float类型小数点位数
	 * */
	public static String formatFloat(float f){
		DecimalFormat df = new DecimalFormat( "0.00");
		String s = df.format(f);
		return s;
	}
	
	/**
	 * 将一个long值的object转成浮点型
	 * */
	public static String long2Float(Object obj){
		float f = 0;
		long l = Long.parseLong(obj.toString());
		Long lo = new Long(l);
		f = lo.floatValue();
		return formatFloat(f);
	}
	
	/**
	 * 将字节long值转换成float
	 * */
	public static String byte2M(Object obj){
		float f = 0;
		long l = Long.parseLong(obj.toString());
		Long lo = new Long(l);
		f = lo.floatValue();
		return formatFloat(f/(1042*1024));
	}
}
