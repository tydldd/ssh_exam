package com.ru.javaExam.utilofcmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * 
 * 项目名称：ssh0605
 * 类描述：java执行指令
 * 创建人：成如
 * 创建时间：2013年10月26日 下午1:29:43
 * 修改人：成如
 * 修改时间：2013年10月26日 下午1:29:43
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class CmdExecutor {


	/**
	 * 执行外部命令，返回是否执行成功
	 * 
	 * @param cmd
	 * @return 返回结果
	 */
	public static int exeCmdIsOK(String cmd) {

		int result = 0;
		try {
			Runtime.getRuntime().exec(cmd);
			result = 1;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return result;

	}

	/**
	 * 执行外部命令，返回外部命令执行结果
	 * 
	 * @param cmd
	 *            外部命令的字符串
	 * @return 
	 * 			返回外部命令执行结果,返回的字符串结果是按照UTF-8格式编码的。
	 * 			如果返回的结果包含几行，则用"\n"分割。
	 */
	public static String exeCmdResultUTF8(String cmd) {

		String result = null;
		StringBuffer strbuffer = null;
		Process process = null;
		BufferedReader bufferReader = null;
		try {
			
			process = Runtime.getRuntime().exec(cmd);//执行指令
			
			bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
			
			strbuffer = new StringBuffer();
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				strbuffer.append(line).append("\n");
			}
			result = strbuffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferReader != null){
				try {
					bufferReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (process != null){
				process.destroy();
			}	
		}
		return result;

	}
	
	public static void main(String[] args) {
		String result = CmdExecutor.exeCmdResultUTF8("sh /topapp/topwalk/cpu.sh");
		System.out.println("sh /topapp/topwalk/cpu.sh========================"+result);
	}

}
