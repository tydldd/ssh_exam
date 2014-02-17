package com.ru.javaExam.thread;

/**
 * Description:如果使用线程的run()方法启动线程则系统会把线程对象当成普通对象，run方法只是普通方法
 * User: NanChengRu
 * Date: 13-11-13
 * Time: 下午11:16
 * JDK: 1.6
 * version: 1.0
 */
public class ThreadRunMethod implements Runnable{

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
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        System.out.println("main线程名称：" + Thread.currentThread().getName());
        //使用run启动线程，相当于调用对象的run方法=this.run();
        new Thread(new ThreadRunMethod(),"新线程").run();
    }
}
