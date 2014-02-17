/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization.synwaitnotify;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：账户对象,提供取钱和
 * 创建人：成如
 * 创建时间：2013-9-3 下午4:47:31
 * 修改人：成如
 * 修改时间：2013-9-3 下午4:47:31
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Account{

	private int id;
	private int deposit = 0;//存钱数
	private int drawMoney = 0;//取钱数
	private int balance = 0;//余额
	boolean flag = false;//false：没有存款。true：有存款
	
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
	 * @throws InterruptedException 
	 * 
	 * (取钱操作:使用同步方法.wait()暂停当前线程，释放同步锁供其他线程使用。notify()唤醒此同步监视器上的线程)
	 * @param  
	 * @return 
	 * @throws
	 */
	public synchronized void draw() throws InterruptedException{
			if(flag == false){
				System.out.println("余额不足，等待存款.......");
				wait();
			}else{
				if(balance >= drawMoney){
					balance = balance - drawMoney;
					System.out.println(Thread.currentThread().getName() + 
							"取款成功，取款金额：" + drawMoney + "账户余额："  + balance);
				}else{
					System.out.println("余额不足");
				}
				
				//没有存款flag则为false
				if(balance <= 0){
					flag = false;
				}
				
				//唤醒其他线程
				notifyAll();
			}
	}
	
	/**
	 * @throws InterruptedException 
	 * 
	 * (存钱操作)
	 * @param  
	 * @return 
	 * @throws
	 */
	public synchronized void save() throws InterruptedException{
		
		if(flag == true){
			System.out.println("账户尚有存款，无需存钱。等待取款......");
			wait();
		}else{
			balance = balance + deposit;
			System.out.println(Thread.currentThread().getName() + "存款成功，账户余额：" + balance);
			
			//如果有存款，flag=true
			if(balance > 0){
				flag = true;
			}
			
			//唤醒其他线程
			notifyAll();
		}
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
