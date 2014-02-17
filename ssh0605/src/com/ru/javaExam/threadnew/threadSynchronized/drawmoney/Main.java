package com.ru.javaExam.threadnew.threadSynchronized.drawmoney;

import org.junit.Test;

/**
 * Created by 成如 on 13-12-21.
 */
public class Main {

    /**
     * 线程同步出现问题
     */
    @Test
    public void test1(){
        Account account = new Account("1111111111", 1000);
        Thread t1 = new Thread(new DrawMoney(account, 800), "线程1");
        Thread t2 = new Thread(new DrawMoney(account, 800), "线程2");
        Thread t3 = new Thread(new DrawMoney(account, 800), "线程3");

        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 使用同步代码块，解决线程同步问题
     */
    @Test
    public void test2(){
        Account account = new Account("1111111111", 1000);
        Thread t1 = new Thread(new DrawMoneySynchronized(account, 800), "线程1");
        Thread t2 = new Thread(new DrawMoneySynchronized(account, 800), "线程2");
        Thread t3 = new Thread(new DrawMoneySynchronized(account, 800), "线程3");

        t1.start();
        t2.start();
        t3.start();
    }


}
