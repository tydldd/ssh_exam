package com.ru.javaExam.threadnew;

/**
 * Description:实现线程的两种方式
 * User: NanChengRu
 * Date: 13-11-19
 * Time: 下午2:24
 * JDK: 1.6
 * version: 1.0
 */
public class TraditionalThread {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());

        //1创建新线程，线程执行run方法体
        Thread thread1 = new Thread();
        thread1.start();//run方法使用的runnable对象不存在，run方法不执行任务东西

        //2创建新线程，覆盖run方法
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                int i = 0;
                while (true){//永不停止的线程
                    System.out.println(Thread.currentThread().getName() + ":    " + i++);
                }
            }
        };
        thread2.start();

        //3创建一个线程，线程执行runnable对象的run方法
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){//永不停止的线程
                    System.out.println(Thread.currentThread().getName() + ":    " + i++);
                }
            }
        });
        thread3.start();

    }
}
