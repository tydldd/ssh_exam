package com.ru.javaExam.threadnew.threadcontrol;

/**
 *
 * join线程
 * Created by 成如 on 13-12-15.
 */
public class JoinThread implements Runnable{

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
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "     " + i);
        }
    }

    public static  void main(String[] args) throws InterruptedException {

        //启动第一个子线程
        new Thread(new JoinThread(), "子线程1").start();

        for(int i= 0; i < 100; i++){
            if (i == 30){
                Thread thread = new Thread(new JoinThread(), "子线程2");
                thread.start();

                //注：join方法通常由使用线程的程序调用，如这里是main线程使用thread线程，所以在main方法中：thread.join()
                //注：thread.join(2000)表示main线程阻塞2秒后执行，期间thread线程一直运行
                //main主线程调用子线程thread的join，则main线程处于阻塞状态，只有子线程执行完毕，main线程才会执行
                thread.join();
            }

            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
    }
}
