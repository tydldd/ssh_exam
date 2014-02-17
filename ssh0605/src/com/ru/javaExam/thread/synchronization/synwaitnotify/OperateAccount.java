/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread.synchronization.synwaitnotify;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：操作账户，存款取款
 * 创建人：成如
 * 创建时间：2013-9-3 下午3:29:00
 * 修改人：成如
 * 修改时间：2013-9-3 下午3:29:00
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class OperateAccount implements Runnable{
	
	private Account ac;
	private String operateType = null;
	
	
	
	
	/**
	 * 创建一个新的实例 OperateAccount.
	 *
	 * @param ac
	 * @param operateType
	 */
	public OperateAccount(Account ac, String operateType) {
		super();
		this.ac = ac;
		this.operateType = operateType;
	}


	/* (方法重写)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		if(operateType.equals("save")){
			try {
				for(int i = 0; i < 100; i++){
					ac.save();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(operateType.equals("draw")){
			try {
				for(int i = 0; i < 100; i++){
					ac.draw();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	public Account getAc() {
		return ac;
	}

	public void setAc(Account ac) {
		this.ac = ac;
	}


	public String getOperateType() {
		return operateType;
	}


	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
}
