package com.ru.javaExam.threadnew.threadcommunication;

/**
 * Created by 成如 on 13-12-22.
 */
public class DrawMoneyThread implements Runnable{
    private Account account;
    private double drawMoney;

    public DrawMoneyThread(Account account, double drawMoney) {
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.drawMoney(drawMoney);
        }
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setDrawMoney(double drawMoney) {
        this.drawMoney = drawMoney;
    }
}
