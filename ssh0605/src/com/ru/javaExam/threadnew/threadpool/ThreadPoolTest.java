package com.ru.javaExam.threadnew.threadpool;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 成如 on 13-12-22.
 */
public class ThreadPoolTest {
    @Test
    public void test(){
        //创建一个可重用的具有固定线程数的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(6);
        //向线程池中提交两个线程
        Thread thread1 = new Thread(new ThreadTest(), "线程1");
        Thread thread2 = new Thread(new ThreadTest(), "线程2");

        threadPool.submit(thread1);
        threadPool.submit(thread2);

        //关闭线程池
        threadPool.shutdown();
    }
}
