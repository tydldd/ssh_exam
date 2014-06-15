package com.ru.javaExam.threadnew.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExam {
	private final int nThreads = 10;
	private final ExecutorService pool = Executors.newFixedThreadPool(nThreads);
	
	/**
	 * 启动多线线程任务
	 */
	public void start() {
		int count = 0;
		while(!pool.isShutdown()){
			pool.execute(new Task(++count));
		}
	}
	
	/**
	 * 停止多线程任务
	 */
	public void stop() {
		pool.shutdown(); // Disable new tasks from being submitted
		   try {
		     // Wait a while for existing tasks to terminate
		     if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
		       pool.shutdownNow(); // Cancel currently executing tasks
		       // Wait a while for tasks to respond to being cancelled
		       if (!pool.awaitTermination(60, TimeUnit.SECONDS))
		           System.err.println("Pool did not terminate");
		     }
		   } catch (InterruptedException ie) {
		     // (Re-)Cancel if current thread also interrupted
		     pool.shutdownNow();
		     // Preserve interrupt status
		     Thread.currentThread().interrupt();
		   }
	}

	public static void main(String[] args) {
		ExecutorExam ee = new ExecutorExam();
		ee.start();
	}
}

class Task implements Runnable {
	private int count = 0;
	public Task(int count){
		this.count = count;
	}
	@Override
	public void run() {
		System.out.println("当前线程[" + Thread.currentThread().getName() + "]    第" + count + "个任务");
	}

}
