package com.ru.javaExam.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilNew {

	/**
	 * 时间毫秒数格式化
	 * 
	 * @param millis
	 * @return
	 */
	public static String formatDate(long millis) {
		Date date = new Date(millis);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static String formatDate2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 将字符串转换成java.sql.Timestamp类型
	 */
	public static Timestamp getTimestampByString(String time){
		Date date = getDateByString(time);
		return new Timestamp(date.getTime());
	} 
	
	/**
	 * 时间date转成long
	 * 
	 *@pram Date
	 *@return long
	 * */
	public static long date2Long(Date date){
		if(date == null){
			return 0;
		}
		System.out.println(date.getTime());
		return date.getTime();
	}
	

	/**
	 * 返回毫秒数
	 * 
	 * @param strDate
	 * @return
	 */
	public static long getMillis(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (strDate == null || strDate.trim().length() == 0) {
			return 0;
		}
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}
	
	/**
	 *取得当前时间的年月日字符串
	 * @return  当前时间 <font color="red" >前一天</font>字符串  格式为 yyyy-DD-mm  如 2010-12-12 
	 */
	
	public static String getYesterday(){
		  long time=System.currentTimeMillis();
			 String s =formatDate(time);
			 Calendar cal= getCalendar(s);
			 String  year=Integer.toString(cal.get(Calendar.YEAR)) ;
			 String  mouth=Integer.toString(cal.get(Calendar.MONTH)+1) ;
			 String  day=Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) ;
			 String today=year+"-"+mouth+"-"+day+" 00:00:00";
		return today;
	}
	
	
	/**
	 *取得当前时间的年月日字符串
	 * @return  当前时间字符串  格式为 yyyy-DD-mm  如 2010-12-12 
	 */
	
	public static String getToday(){
		long time=System.currentTimeMillis();
		String s =formatDate(time);
		Calendar cal= getCalendar(s);
		String  year=Integer.toString(cal.get(Calendar.YEAR)) ;
		String  mouth=Integer.toString(cal.get(Calendar.MONTH)+1) ;
		String  day=Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) ;
		String today=year+"-"+mouth+"-"+day+" 23:59:59";
		return today;
	}
	
	
	
	
	/**
	 * 根据标准时间字符串格式返回Date对象
	 * @param str
	 * @return
	 */
	public static Calendar getCalendar(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return 	calendar;
	}
	
	
	/**
	 * 将以秒为单位的时间数据转换成为字符串格式的数据
	 * @param millis
	 * @return
	 */
	public static String  millisToDate(long millis){
		Date date = new Date(millis*1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	//昨天的开始时间毫秒数
	public static long getYestodayBeginMilis(){
		long yestdayBeginDateInLong = 0;
		yestdayBeginDateInLong = getTodayBeginDateInLong() - 24*60*60*1000;
		return yestdayBeginDateInLong;
	}
	
	//昨天的结束时间毫秒数
	public static long getYestodayEndMilis(){
		long yestodayEndDateInLong = 0;
		yestodayEndDateInLong = getTodayBeginDateInLong() - 1*1000;
		return yestodayEndDateInLong;
	}
	
	//得到1小时前的毫秒数
	public static long getOneHourAgoDateInLong(){
		return System.currentTimeMillis() - 60*60*1000;
	}
	
	//今天的开始时间毫秒数
	public static long getTodayBeginDateInLong(){
		String todayBeginDateInString = getTodayBeginDateInString();
		Date todayBeginDate = null;
		try {
			todayBeginDate = getDateByString(todayBeginDateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long todayBeginDateInLong = getDateInLongByDate(todayBeginDate);
		return todayBeginDateInLong;
	}
	
	public static long getDateInLongByDate(Date date){
		long dateInLong = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		dateInLong = cal.getTimeInMillis();
		return dateInLong;
	}
	
	public static Date getDateByString(String dateString){
		Date date = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("字符串转换成时间date异常！", e);
		}
		return date;
	}
	
	public static String getTodayBeginDateInString(){
		Calendar todayCalendar = Calendar.getInstance();
		String year = Integer.toString(todayCalendar.get(Calendar.YEAR));
		String month = Integer.toString(todayCalendar.get(Calendar.MONTH)+1);
		String day = Integer.toString(todayCalendar.get(Calendar.DAY_OF_MONTH));
		String yestodyBeginDateInString = year + "-" + month + "-" + day + " " + "00:00:00";
		return yestodyBeginDateInString;
	}
}
