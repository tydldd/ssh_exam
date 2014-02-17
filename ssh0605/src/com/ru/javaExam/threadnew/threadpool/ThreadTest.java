package com.ru.javaExam.threadnew.threadpool;

/**
 * Created by 成如 on 13-12-22.
 */
public class ThreadTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "*********" + i);
        }
    }
}
