package com.ru.javaExam.threadnew.threadSynchronized.drawmoney;

/**
 * Created by 成如 on 13-12-21.
 */
public class Account {
    //账号
    private String accountId;
    //余额
    private double balance;

    public Account(String accountId, double balance){
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
