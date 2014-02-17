package com.ru.javaExam.threadnew.threadcommunication;

/**
 * Created by 成如 on 13-12-22.
 */
public class Account {

    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    /**
     *  取钱操作
     */
    //synchronized同步方法，在线程执行此方法时，会锁定当前对象及this，直到线程执行完成
    public synchronized void drawMoney(double drawAmount){

        try {
            //如果flag为false，表明没人存钱。则取钱方法阻塞
            if (!flag){
                //使当前线程等待，直到其他线程调用该同步监视器的notify或nofyall方法来唤醒该线程
                wait();
            }else{
                if (balance > drawAmount) {
                    balance = balance - drawAmount;
                    System.out.println(Thread.currentThread().getName() + "取款" + drawAmount + "元");
                    System.out.println(Thread.currentThread().getName() + "余额：" + balance);
                    flag = false;
                    //唤醒该同步监视器上的其他线程
                    notifyAll();
                }else {
                    System.out.println(Thread.currentThread().getName() + "余额不足");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 存钱操作
     */
    public synchronized void saveMoney(double saMoney){

        try {
            //假如flag为false。表示没有存款。可以存款操作
            if (!flag){
                balance = balance + saMoney;
                System.out.println(Thread.currentThread().getName() + "存款" + saMoney + "元");
                System.out.println(Thread.currentThread().getName() + "余额" + balance + "元");
                flag = true;
                //唤醒该同步监视器上的其他线程
                notifyAll();
            }else {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }
}
