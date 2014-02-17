/**
 * 文件名：TimerExam.java
 *
 * 版本信息：
 * 日期：2013年11月8日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.timer;

import java.util.Timer;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：Timer定时器和TimerTask定时任务
 * 创建人：成如
 * 创建时间：2013年11月8日 下午5:35:43
 * 修改人：成如
 * 修改时间：2013年11月8日 下午5:35:43
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class TimerExam {
	
	public static void main(String[] args){
		Timer timer = new Timer();
		timer.schedule(new Task(), 1000, 2000);
	}
}

