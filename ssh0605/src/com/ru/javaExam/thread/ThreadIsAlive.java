package com.ru.javaExam.thread;

/**
 * Description:判断线程是否存活
 * User: NanChengRu
 * Date: 13-11-14
 * Time: 下午10:20
 * JDK: 1.6
 * version: 1.0
 */
public class ThreadIsAlive implements Runnable{
    private int i = 0;
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
        for (; i < 100; i++){
            System.out.println("线程：" + Thread.currentThread().getName() + "    " + i);
        }
    }

    public static void main(String[] args){
        Thread thread = null;
        for (int i = 0; i < 100; i++){
            if (i ==20){
                thread = new Thread(new ThreadIsAlive(),"新线程");
                thread.start();
                System.out.println("启动线程：" + thread.isAlive());
            }

            //这是线程肯定已经启动，线程死亡时执行
            //只有当线程新建和死亡时返回false，运行时返回true
            if (i > 20 && !thread.isAlive()){
                System.out.println("线程是否存活：" + thread.isAlive());
                //thread.start();
            }
        }

    }
}
