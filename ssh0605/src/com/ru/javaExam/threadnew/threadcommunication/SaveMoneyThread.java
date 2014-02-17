package com.ru.javaExam.threadnew.threadcommunication;

/**
 * Created by 成如 on 13-12-22.
 */
public class SaveMoneyThread implements Runnable{
    private Account account;
    private double saveMoney;

    public SaveMoneyThread(Account account, double saveMoney) {
        this.account = account;
        this.saveMoney = saveMoney;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.saveMoney(saveMoney);
        }
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }
}
