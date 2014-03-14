package com.ru.javaExam.net.socket.sockettest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月11日 下午5:09:47
 * 修改人：nange
 * 修改时间：2014年3月11日 下午5:09:47
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class ServerSocketTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		ServerSocket socket = null;
		Socket resScoket = null;
		PrintStream ps = null;
		try {
			//创建一个服务器段socket
			socket = new ServerSocket(12345);
//			socket.setSoTimeout(5000);
			while(true){
				System.out.println("等待客户端连接....");
				//监听并接受到此socket连接,接受连接生成一个socket与客户端socket通信
				resScoket = socket.accept();
				System.out.println("接受客户端连接");
				ps = new PrintStream(resScoket.getOutputStream());
				ps.print("连接服务器成功..OK");
				System.out.println("socket是否连接：" + resScoket.isConnected());
				if (ps != null) {
					ps.close();
				}else if(resScoket != null){
					try {
						resScoket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
