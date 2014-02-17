package com.ru.javaExam.io_18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 创建系统进程
 * @author 南成�?
 * */
public class ProcessTest {
	
	/**
	 * 使用ProcessBuilder创建进程
	 * @param list
	 * @param String...
	 * */
	public void processExam(String... args) throws IOException{
		String s1;
		String s2;
		BufferedReader result1 = null;
		BufferedWriter bwr = null;
		BufferedReader result2 = null;
		BufferedWriter bww = null;
		try {
			//执行指令创建进程:new ProcessBuilder("myCommand", "myArg1", "myArg2"),指令
			Process proce=new ProcessBuilder(args).start();//创建进程执行指令
			//标准输入流，正确执行返回的结�?proce.getInputStream()会返回进程的标准输出
			result1=new BufferedReader(new InputStreamReader(proce.getInputStream()));
			bwr=new BufferedWriter(new FileWriter(new File("E:\\测试文件\\peocess1.txt")));
			while((s1=result1.readLine())!=null){
				bwr.write(s1+"\n");
			}
			//错误输入流，执行错误返回的结�?proce.getInputStream()会返回进程的错误输出
			result2=new BufferedReader(new InputStreamReader(proce.getErrorStream()));
			bww=new BufferedWriter(new FileWriter(new File("E:\\测试文件\\peocess2.txt")));
			while((s2=result2.readLine())!=null){
				bww.write(s2+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			result1.close();
			bwr.close();
			result2.close();
			bww.close();
		}
	}
	
	/**
	 * 使用RunTime创建进程
	 * @param String...
	 * @throws IOException 
	 * */
	public void runTimeExam(String command,String... args) throws IOException{
		String s1;
		String s2;
		BufferedReader br1=null;
		BufferedReader br2=null;
		String cmd="";
		cmd=command;
		if(args!=null){
			for(String arg:args){
				cmd=cmd+" "+arg;
			}
		}
		try {
			Process proce=Runtime.getRuntime().exec(cmd);//创建进程
			br1=new BufferedReader(new InputStreamReader(proce.getInputStream()));
			while((s1=br1.readLine())!=null){
				System.out.println(s1);
			}
			br2=new BufferedReader(new InputStreamReader(proce.getErrorStream()));
			while((s2=br2.readLine())!=null){
				System.out.println(s2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			br1.close();
			br2.close();
		}
	}
	
	/**
	 * 调用方法
	 * @param String...
	 * @throws IOException 
	 * */
	@Test
	public void run() throws IOException{
		//使用RunTime创建进程
		String command="ipconfig";
		String arg="/all";
		this.runTimeExam(command, arg);
		
		//使用ProcessBuilder创建进程
		//command指令
		String comand2="net";
		String arg2="start";
		String arg3="mysql";
		this.processExam(comand2,arg2,arg3);
	}
}
