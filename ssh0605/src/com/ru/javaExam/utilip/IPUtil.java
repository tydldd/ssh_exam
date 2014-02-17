package com.ru.javaExam.utilip;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

/**
 * ��ȡ����IPԶ��IP�Լ���IP���бȽϵķ���
 * @author 
 * @lastmodify 2013-3-3
 * */
public class IPUtil {
	
	/**
	 * �õ�����IP�ķ���
	 * @return ip
	 * @throws UnknownHostException 
	 * */
	public static String getLocalIP() throws UnknownHostException{
		InetAddress address = InetAddress.getLocalHost(); 
		return address.getHostAddress();
	}
	
	/**
	 * �õ�Զ������IP
	 * @return string
	 * */
	public static String getRemoteIP(HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");  
	    if (!checkIP(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (!checkIP(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (!checkIP(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	}  
	private static boolean checkIP(String ip) {  
	    if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)  
	            || ip.split(".").length != 4) {  
	        return false;  
	    }  
	    return true;  
	}  
	
	@Test
	public void run() throws UnknownHostException{
		System.out.println(getLocalIP());
		
		String s = "";
		System.out.println("s���ȣ�"+s.length());
		
	}
}
