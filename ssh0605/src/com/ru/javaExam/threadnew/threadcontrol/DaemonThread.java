package com.ru.javaExam.threadnew.threadcontrol;

/**
 *
 * 后台线程
 * Created by 成如 on 13-12-15.
 */
public class DaemonThread implements Runnable{
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
        for (int i = 0; i < 1000; i++){
            System.out.println(Thread.currentThread().getName() + "  " + i + "  是否后台线程：" + Thread.currentThread().isDaemon());
        }
    }

    public static void main(String[] args){
        Thread subThread = new Thread(new DaemonThread(), "后台进程");
        //注：当前台线程（这里是main线程）死亡时，后台线程随之死亡，java虚拟机随之退出。因为只有后台线程存活没有意义。
        //注：前台线程中创建的线程默认是前台线程，后台线程中创建的默认是后台线程
        //将线程设置成后台线程
        subThread.setDaemon(true);
        subThread.start();

        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
        System.out.println("主线程main结束");
    }
}
