package com.ru.javaExam.net.socket;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月11日 下午5:33:43
 * 修改人：nange
 * 修改时间：2014年3月11日 下午5:33:43
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class SocketTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			socket = new Socket("127.0.0.1", 12345);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String con = null;
			StringBuilder sb = new StringBuilder();
			while((con = br.readLine()) != null){
				sb.append(con);
			}
			System.out.println("客户端得到的反馈信息：" + sb.toString());
			fw = new FileWriter("H:/test/socket2.txt");
			fw.write(sb.toString());
			fw.close();
			br.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
