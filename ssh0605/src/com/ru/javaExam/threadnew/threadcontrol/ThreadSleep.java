package com.ru.javaExam.threadnew.threadcontrol;

/**
 * 线程休眠
 * Created by 成如 on 13-12-15.
 */
public class ThreadSleep implements Runnable{
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
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "    " + i);
            //sleep()使当前线程变成阻塞装成。休眠1秒
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new Thread(new ThreadSleep(), "休眠线程").start();
    }
}
