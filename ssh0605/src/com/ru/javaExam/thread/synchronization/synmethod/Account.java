/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization.synmethod;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：账户对象:同步方法
 * 创建人：成如
 * 创建时间：2013-9-2 下午4:47:31
 * 修改人：成如
 * 修改时间：2013-9-2 下午4:47:31
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Account implements Runnable{

	private int id;
	private int deposit;
	private int drawMoney;
	private int balance;
	
	/**
	 * 创建一个新的实例 Account.
	 *
	 * @param id
	 * @param deposit
	 */
	public Account(int id, int deposit, int drawMoney) {
		super(); 
		this.id = id;
		this.deposit = deposit;
		
		this.drawMoney = drawMoney;
	}
	
	/**
	 * 
	 * (取钱操作:方法加synchronized关键字，称为同步方法，同步方法的同步监视器是this，所以执行同步方法会锁定当前对象。)
	 * @param  
	 * @return 
	 * @throws
	 */
	public synchronized void draw(){
		if(getDeposit() >= drawMoney){
			System.out.println(Thread.currentThread().getName() + "取款成功,取款金额： " + drawMoney + " 元");
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//从存款中减去取款
			balance = getDeposit() - drawMoney;
			setDeposit(balance);
			System.out.println(Thread.currentThread().getName() + "余额： " + balance + " 元");
		}else{
			System.out.println("余额不足");
		}
		
	}
	
	/* (方法重写)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		draw();
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
