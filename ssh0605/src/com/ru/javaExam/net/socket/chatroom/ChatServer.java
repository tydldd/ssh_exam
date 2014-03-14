package com.ru.javaExam.net.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月12日 上午10:36:38
 * 修改人：nange
 * 修改时间：2014年3月12日 上午10:36:38
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class ChatServer {
	public static List<Socket> socketList = new ArrayList<Socket>();
	final static Logger log = LogManager.getLogger("ChatServer");
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(12345);
			System.out.println("创建serverSocket");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			log.error("没有找到主机", e);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("IO异常", e);
		}
		while(true){
			try {
				//接收socket连接，接收到连接服务器创建一个socket
				Socket soc = ss.accept();
				System.out.println("接收到客户端连接....");
				//将创建的socket放到列表
				socketList.add(soc);
				System.out.println("服务器生成socket与客户端建立连接");
				//为每个连接开启一个线程
				System.out.println("服务器开启线程处理客户端信息.....");
				new Thread(new socThread(soc)).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 
 * 
 * 类描述：负责读取客户端发过来的数据，并将数据发送到其他客户端
 * 创建时间：2014年3月12日 下午2:20:05
 * 修改人：nange
 * 修改时间：2014年3月12日 下午2:20:05
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
class socThread implements Runnable{
	final Logger log = LogManager.getLogger("socThread");
	BufferedReader br = null;
	Socket soc = null;
	public socThread(Socket soc) throws IOException{
		this.soc = soc;
		//得到服务器端。注：只要socket存在，这个socket的输入输出流一直存在
		InputStream is = soc.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
	}
	@Override
	public void run() {
		try {
			
			String con = null;
			while((con = readMsg()) != null){
//				System.out.println("接收到的信息:" + con);
				//将客户端传递的信息广播到其他客户端
				for(Socket soc : ChatServer.socketList){
					if(soc != this.soc){
						PrintStream ps = new PrintStream(soc.getOutputStream());
						ps.println(con);
						System.out.println("向客户端发送信息：" + con);
					}
				}
			}
			System.out.println("服务器socket关闭?  " + soc.isClosed());
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error("socket线程错误", e);
		}
	}
	
	/**
	 * 读取信息
	 * @return String
	 * @throws IOException 
	 */
	public String readMsg() throws IOException{
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端关闭...");
			//将服务器端对应的socket删除
			ChatServer.socketList.remove(soc);
			if(br != null){
				br.close();
			}
		}
		return null;
	}
	
}
