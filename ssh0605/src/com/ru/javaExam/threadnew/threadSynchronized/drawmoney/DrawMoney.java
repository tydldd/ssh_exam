package com.ru.javaExam.threadnew.threadSynchronized.drawmoney;

/**
 * Created by 成如 on 13-12-21.
 */
public class DrawMoney implements Runnable{
    private Account account;
    //取钱数
    private double drawAmount;

    public DrawMoney(Account account, double drawAmount){
        this.account = account;
        this.drawAmount = drawAmount;
    }
    /**
     * 取钱操作
     * @see Thread#run()
     */
    @Override
    public void run() {
        if(account.getBalance() >= drawAmount){
            System.out.println("线程" + Thread.currentThread().getName() + "取走" + drawAmount + "元");


           /* try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("余额:" + account.getBalance());
        }else {
            System.out.println("余额不足");
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
