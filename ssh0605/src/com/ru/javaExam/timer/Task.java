/**
 * 文件名：Task.java
 *
 * 版本信息：
 * 日期：2013年11月8日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.timer;

import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013年11月8日 下午6:10:57
 * 修改人：成如
 * 修改时间：2013年11月8日 下午6:10:57
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Task extends TimerTask{
	Logger log = Logger.getLogger(TimerExam.class);
	private static int i = 0;

    @Override
    public void run() {
        log.debug("这个I = " + i++);
    }

}


