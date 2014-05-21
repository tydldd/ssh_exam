package com.ru.javaExam.threadnew.waitnotify;

import java.util.List;

import javassist.compiler.NoFieldException;

/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序
 * @author nange
 *
 */
public class Exam1 {

	private static boolean flag = false;
	private static int key = 0;
	public static void main(String[] args) {
		
		final Exam1 exam = new Exam1();
		
		//子线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 50; i++){
					synchronized (exam) {
						//如果flag为true，进入等待状态
						if(flag){
							try {
								exam.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						
						for(int j = 0; j < 10; j++){
							System.out.println("子key = " + (++key));
						}
						key = 0;
						flag = true;
						//唤醒线程
						exam.notify();
					}
				}
			}
		}).start();
		
		//主线程
		for(int i = 0; i < 50; i++){
			synchronized (exam) {
				if(!flag){
					try {
						exam.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				for(int j = 0; j < 100; j++){
					System.out.println("主线程key = " + (++key));
				}
				key = 0;
				flag = false;
				exam.notify();
			}
		}
	}
}
