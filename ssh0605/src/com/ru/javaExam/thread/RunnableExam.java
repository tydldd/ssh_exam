package com.ru.javaExam.thread;

/**
 * Description: 实现runnable接口创建线程，多个线程可以使用一个线程类实例，所以多个线程可以共享一个实例target
 * User: NanChengRu
 * Date: 13-11-12
 * Time: 下午11:14
 * JDK: 1.6
 * version: 1.0
 */
public class RunnableExam implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " --- " + i);
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            if (i == 20){
                RunnableExam re = new RunnableExam();
                new Thread(re, "线程1").start();
                new Thread(re, "线程2").start();
            }
        }
    }
}
