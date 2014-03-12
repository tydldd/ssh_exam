package com.ru.javaExam.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月10日 下午2:49:10
 * 修改人：nange
 * 修改时间：2014年3月10日 下午2:49:10
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class InetAddressTest {
	@Test
	public void test() throws IOException{
		//通过域名得到InetAddress实例
		InetAddress address = InetAddress.getByName("www.baidu.com");
		byte[] ip1 = address.getAddress();
		String ip2 = address.getHostAddress();
		System.out.println("通过域名得到IP地址：" + new String(ip1).toString() + "   " + ip2);
		System.out.println("是否可以连通：" + address.isReachable(2000));
		
		//通过IP得到InetAddress
		InetAddress addr = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
		String hostName = addr.getCanonicalHostName();
		System.out.println("主机名：" + hostName + "  是否能到达主机：" + addr.isReachable(2000));
	}
}
