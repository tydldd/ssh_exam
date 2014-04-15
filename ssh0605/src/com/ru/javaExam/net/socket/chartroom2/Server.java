package com.ru.javaExam.net.socket.chartroom2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月14日 上午9:24:49
 * 修改人：nange
 * 修改时间：2014年3月14日 上午9:24:49
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Server {
	public static RuMap<String, PrintStream> sockMap = new RuMap<String, PrintStream>();
	public void init(){
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(RuParams.PORT);
			System.out.println("等待客户端连接.....");
			while(true){
				Socket soc = ss.accept();
				System.out.println("创建一个连接.....");
				new Thread(new ServerThead(soc)).start();
			}
		} catch (IOException e) {
			System.out.println("创建servercocket失败");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}
}


class ServerThead implements Runnable{
	Socket soc = null;
	public ServerThead(Socket soc){
		this.soc = soc;
	}
	@Override
	public void run() {
		BufferedReader br = null;
		PrintStream ps = null;
		if(soc == null || soc.isClosed()){
			System.out.println("socket已经关闭");
		}else{
			System.out.println("开启一个线程处理连接...");
			try {
				br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				ps = new PrintStream(soc.getOutputStream());
				String con = null;
				while((con = br.readLine()) != null){
					//处理用户名输入
					if(con.startsWith(RuParams.USERNAME_PRE)){
						String res = RuParams.LOG_SUC;
						if(con.trim().equals(RuParams.USERNAME_PRE)){
							System.out.println("用户名不正确");
							ps.print(RuParams.LOG_FAIL);
						}else{
							String userName = con.split(RuParams.USERNAME_PRE)[1];
							for(String name : Server.sockMap.keySet()){
								if(name.equals(userName)){
									res = RuParams.LOG_FAIL;
								}
							}
							//将验证信息返回个客户端
							ps.println(res);
							//将用户名和输出流放入map
							if(res.equals(RuParams.LOG_SUC)){
								System.out.println(userName + "  登录成功");
								Server.sockMap.put(userName, ps);
							}
						}
					//处理群聊信息
					}else if(con.startsWith(RuParams.CONTENT)){
						String commonStr = null;
						if(con.trim().equals(RuParams.CONTENT)){
							commonStr = "";
						}else{
							commonStr = con.split(RuParams.CONTENT)[1];
						}
						//将信息发送到其他客户端
						for(PrintStream psOther : Server.sockMap.valueSet()){
							if(psOther != ps){
								psOther.println(Server.sockMap.getKeyByValue(ps) + "说：" + commonStr);
								System.out.println(Server.sockMap.getKeyByValue(ps) + "说：" + commonStr);
							}
						}
					}
				}
			} catch (IOException e) {
				try {
					if(br != null){
						br.close();
					}else if(ps != null){
						ps.close();
					}else if(soc != null){
						soc.close();
						System.out.println("服务器关闭");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("客户端关闭");
				e.printStackTrace();
			}
		}
	}
	
}
