package com.ru.javaExam.utilip;
/**
 *  
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 工程�?�?VPSer
 * <p>
 * 授权 : (C) Copyright topwalk Corporation 2006-2009
 * <p>
 * 公司 : 北京天行网安信息�?��有限责任公司
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 修改历史
 * <p>
 * 
 * <table width="432" border="1">
 * <tr>
 * <td>版本</td>
 * <td>时间</td>
 * <td>作�?</td>
 * <td>改变</td>
 * </tr>
 * <tr>
 * <td>2.0</td>
 * <td>Jan 28, 2010</td>
 * <td>tanglei</td>
 * <td>创建</td>
 * </tr>
 * </table>
 * <p>
 * <font color="#FF0000">注意: 本内容仅限于北京天行网安公司内部使用，禁止转�?/font>
 * <p>
 * 
 * @version 2.0
 * 
 * @author tanglei
 * @since JDK1.6
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Ip2Long {
	//实现 ip�?int 


	/**
	* @author wenc
	* 
	*/

	/**
	* @param ip
	* @return 有符号的整形数；当ip>128.0.0.0时为负数�?
	* @throws UnknownHostException
	* @author wenc
	*/
	public static int ip2Int(String ip) throws UnknownHostException {
	InetAddress address = InetAddress.getByName(ip);// 在给定主机名的情况下确定主机�?IP �??
	byte[] bytes = address.getAddress();// 返回�?InetAddress 对象的原�?IP 地址
	int a, b, c, d;
	a = byte2int(bytes[0]);
	b = byte2int(bytes[1]);
	c = byte2int(bytes[2]);
	d = byte2int(bytes[3]);
	int result = (a << 24) | (b << 16) | (c << 8) | d;
	return result;
	}

	public static int byte2int(byte b) {
	int l = b & 0x07f;
	if (b < 0) {
	l |= 0x80;
	}
	return l;
	}

	/**
	* @param ip
	* @return IP转化为长整形数�?
	* @throws UnknownHostException
	* @author wenc 
	*/
	public static long ip2long(String ip) throws UnknownHostException {
	int ipNum = ip2Int(ip);
	return int2long(ipNum);
	}

	public static long int2long(int i) {
	long l = i & 0x7fffffffL;
	if (i < 0) {
	l |= 0x080000000L;
	}
	return l;
	}

	/**
	* @param ip
	* @return 长整形数值转化为ip地址
	* @author wenc
	*/
	@SuppressWarnings("static-access")
	public static String long2ip(long ip) {
	int[] b = new int[4];
	b[0] = (int) ((ip >> 24) & 0xff);
	b[1] = (int) ((ip >> 16) & 0xff);
	b[2] = (int) ((ip >> 8) & 0xff);
	b[3] = (int) (ip & 0xff);
	String x;
	Integer p;
	p = new Integer(0);
	x = p.toString(b[0]) + "." + p.toString(b[1]) + "." + p.toString(b[2])
	+ "." + p.toString(b[3]);

	return x;

	}

	// 测试函数
	public static void main(String[] args) throws Exception {
		System.out.println(ip2long("192.168.0.250"));
		System.out.println(long2ip(ip2long("192.168.0.250")));

	}
}
 