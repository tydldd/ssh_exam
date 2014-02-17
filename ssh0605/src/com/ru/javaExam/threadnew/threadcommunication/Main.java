package com.ru.javaExam.threadnew.threadcommunication;

import org.junit.Test;

/**
 * 线程通信
 * Created by 成如 on 13-12-22.
 */
public class Main {
    @Test
    public void test(){
        Account account = new Account("1111111", 0);
        //存款线程
        new Thread(new SaveMoneyThread(account,1000),"存款线程").start();
        //取款线程
        new Thread(new DrawMoneyThread(account,900),"取款线程1").start();
        new Thread(new DrawMoneyThread(account,900),"取款线程2").start();
    }

}
