package com.ru.javaExam.net.socket.chartroom2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：nange
 * 创建时间：2014年3月14日 上午11:07:48
 * 修改人：nange
 * 修改时间：2014年3月14日 上午11:07:48
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class Client {
	
	public void init(){
		Socket soc = null;
		PrintStream ps = null;
		BufferedReader br = null;
		try {
			soc = new Socket("127.0.0.1", RuParams.PORT);
			ps = new PrintStream(soc.getOutputStream());
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			//输入用户名并验证
			String tip = "";
			while(true){
				String userName = JOptionPane.showInputDialog(tip + "输入用户名");
				ps.println(RuParams.USERNAME_PRE + userName);
				String res = br.readLine();
				if(res.equals(RuParams.LOG_SUC)){
					System.out.println("登录成功");
					break;
				}else{
					tip = "用户名不正确,请重新";
					continue;
				}
			}
			//启动线程读取服务器发送的信息
			new Thread(new ClientThread(br)).start();
			
			//发送群信息
			Scanner sca = new Scanner(System.in);
			while(sca.hasNext()){
				ps.println(RuParams.CONTENT + sca.next());
			}
		} catch (Exception e) {
			try {
				if(ps != null){
					ps.close();
				}else if(br != null){
					br.close();
				}else if(soc != null){
					soc.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.init();
	}
}

/**
 * 
 * 
 * 类描述：读取客户端信息
 * 创建人：nange
 * 创建时间：2014年3月14日 下午2:37:45
 * 修改人：nange
 * 修改时间：2014年3月14日 下午2:37:45
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
class ClientThread implements Runnable{
	private BufferedReader br = null;
	public ClientThread(BufferedReader br){
		this.br = br;
	}
	@Override
	public void run() {
		String con = null;
		try {
			while((con = br.readLine()) != null){
				System.out.println(con);
			}
		} catch (IOException e) {
			if(br != null){
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
	
}
