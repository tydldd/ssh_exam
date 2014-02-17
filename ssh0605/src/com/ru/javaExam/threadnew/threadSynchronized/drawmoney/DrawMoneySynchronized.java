package com.ru.javaExam.threadnew.threadSynchronized.drawmoney;

/**
 * Created by 成如 on 13-12-22.
 */
public class DrawMoneySynchronized implements Runnable{

    private Account account;
    //取钱数
    private double drawAmount;

    public DrawMoneySynchronized(Account account, double drawAmount){
        this.account = account;
        this.drawAmount = drawAmount;
    }
    /**
     * 取钱操作
     * @see Thread#run()
     */
    @Override
    public void run() {
        //线程代码块
        //使用account作为同步监视器，任何线程进入下面同步代码块之前，必选先获得对account的锁定。
        //其他线程无法获得锁也就无法修改他
        synchronized (account){
            if(account.getBalance() >= drawAmount){
                System.out.println(Thread.currentThread().getName() + "取走" + drawAmount + "元");
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println(Thread.currentThread().getName() + "余额:" + account.getBalance());
            }else {
                System.out.println(Thread.currentThread().getName() + "余额不足");
            }
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(double drawAmount) {
        this.drawAmount = drawAmount;
    }
}
