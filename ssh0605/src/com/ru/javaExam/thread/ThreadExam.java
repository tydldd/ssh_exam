package com.ru.javaExam.thread;

/**
 * Description:实现Thead的线程
 * User: NanChengRu
 * Date: 13-11-12
 * Time: 下午10:08
 * JDK: 1.6
 * version: 1.0
 */
public class ThreadExam extends Thread{

    @Override
    public void run() {
       for (int i = 0; i < 100; i++){
           System.out.println(getName() + "  --  " + i);
       }
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " -- " + i);

            if (i == 20){
                //启动第一个线程
                Thread th1 = new ThreadExam();
                th1.setName("线程1");//设置线程名称
                th1.start();//启动线程

                //启动第二个线程
                Thread th2 = new ThreadExam();
                th2.setName("线程2");
                th2.start();
            }

        }
    }
}
