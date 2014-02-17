/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread;

import java.util.Date;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：实现runnable接口的线程
 * 创建人：成如
 * 创建时间：2013-8-30 下午3:26:03
 * 修改人：成如
 * 修改时间：2013-8-30 下午3:26:03
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class ThreadTest2 implements Runnable{

	/* (方法重写)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println("----线程名称：" + Thread.currentThread().getName() + "        当前第？个：" + i);
		}
	}
	
	/*public static void main(String[] args){
		
		for(int i = 0; i < 100; i++){
			System.out.println(Thread.currentThread().getName());
			if(i == 20){
				ThreadTest2 tt2 = new ThreadTest2();
				//新建线程1
				new Thread(tt2, "新线程1").start();
				
				//新建线程2
				new Thread(tt2, "新线程2").start();
			}
		}
	}*/
	
	/**
	 * 
	 * (后台线程)
	 * @param  
	 * @return 
	 * @throws
	 */
	public void test1(){
		ThreadTest2 tt = new ThreadTest2();
		Thread th = new Thread(tt,"后台线程");
		th.setDaemon(true);//将线程设置成后台线程，当所有前台线程死亡时，后台线程随之死亡。
		th.start();
		
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	/**
	 * @throws InterruptedException 
	 * 
	 * (线程休眠)
	 * @param  
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("static-access")
	//@Test
	public void sleep() throws InterruptedException{
		
		ThreadTest2 tt = new ThreadTest2();
		Thread th = new Thread(tt,"线程");
		th.start();
		th.sleep(1000);
		
		for(int i = 0; i < 10; i++){
			System.out.println("当前线程:" + Thread.currentThread().getName() + "  当前时间：" + new Date());
			//Thread.sleep(1000);//休眠1000毫秒
		}
	}
	
	/**
	 * 
	 * (线程优先级---优先级越高会获得更多的执行机会)
	 * 线程等级是1-10之间的整数，MAX_PRIORITY:10,MIN_PRIORITY:1,NORM_PRIORITY:5
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void priority(){
		
		//每个线程的默认优先级都与创建它的父线程有相同的优先级。这里父线程设置优先级为6，这创建的子线程初始优先级也是6
		Thread.currentThread().setPriority(6);
		for(int i = 0; i < 30; i++){
			
			if(i == 10){
				ThreadTest2 tt = new ThreadTest2();
				Thread th = new Thread(tt,"线程");
				System.out.println("初始优先级：" + th.getPriority());
				th.setPriority(Thread.MAX_PRIORITY);
				System.out.println("当前优先级：" + th.getPriority());
				th.start();
			}
		}
	}

}
