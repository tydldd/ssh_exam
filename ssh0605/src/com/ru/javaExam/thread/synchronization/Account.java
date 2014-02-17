/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：账户对象
 * 创建人：成如
 * 创建时间：2013-9-2 下午4:47:31
 * 修改人：成如
 * 修改时间：2013-9-2 下午4:47:31
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Account {

	private int id;
	private int deposit;
	
	
	/**
	 * 创建一个新的实例 Account.
	 *
	 * @param id
	 * @param deposit
	 */
	public Account(int id, int deposit) {
		super();
		this.id = id;
		this.deposit = deposit;
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
}
