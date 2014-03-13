package com.ru.javaExam.net.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月12日 下午10:43:24
 * 修改人：nange
 * 修改时间：2014年3月12日 下午10:43:24
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Client {
	Logger log = LogManager.getLogger(Client.class);
	static PrintStream ps = null;
	static Socket soc = null;
	public static void main(String[] args) throws IOException {
		try {
			Socket soc = new Socket("127.0.0.1", 12345);
			//启动一个线程读取服务器传递来的信息
			new Thread(new clientThread(soc)).start();
			//客户端输出信息
			ps = new PrintStream(soc.getOutputStream());
			Scanner sca = new Scanner(System.in);
			while(sca.hasNext()){
				String con = sca.next();
//				System.out.println("client输入信息：" + con);
				ps.println(con);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

/**
 * 
 * 接收服务器端传递的信息
 * 创建时间：2014年3月13日 上午11:07:00
 * 修改时间：2014年3月13日 上午11:07:00
 * @since  jdk1.7
 * @version 1.0
 */
class clientThread implements Runnable{
	Logger log = LogManager.getLogger(clientThread.class);
	private Socket soc = null;
	BufferedReader br = null;
	public clientThread(Socket soc) throws IOException{
		this.soc = soc;
		br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
	}
	@Override
	public void run() {
		String con = null;
		try {
			while((con = br.readLine()) != null){
				System.out.println("别人说：" + con);
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("客户端接收信息失败", e);
		}
	}
	
}
