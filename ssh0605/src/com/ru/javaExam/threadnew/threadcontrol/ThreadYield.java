package com.ru.javaExam.threadnew.threadcontrol;

/**
 *
 * 线程让步
 * Created by 成如 on 13-12-15.
 */
public class ThreadYield implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "   " + i);
            if (i == 20){
                //线程让步,yield的作用不是阻塞当前线程，而是将线程转为就绪状态
                Thread.currentThread().yield();
            }
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new ThreadYield(), "让步线程1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        Thread thread2 = new Thread(new ThreadYield(), "线程让步2");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
}
