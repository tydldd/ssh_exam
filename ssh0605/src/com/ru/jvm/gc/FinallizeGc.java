package com.ru.jvm.gc;

/**
 * 
 * 类描述：jvm判断对象生死
 * @since  jdk1.7
 * @version 1.0
 */
public class FinallizeGc {
	
	private static FinallizeGc fg = null;

	public void isActive(){
		System.out.println("我还活着");
	}
	
	/**
	 * 一个对象只会执行一次finallize方法
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("第一次标记：执行finallize方法。进行自救，使fg指向当前对象。");
		fg = this;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		fg = new FinallizeGc();
		
		//测试第一次垃圾回收
		fg = null;
		//手动垃圾回收
		System.gc();
		//判断对象受否存货
		System.out.println("第一次垃圾回收自救结果：");
		//因为finallizer线程优先级较低，当前线程暂停1秒，等待finallizer执行
		Thread.currentThread().sleep(1000);
		if(fg != null){
			fg.isActive();
		}else{
			System.out.println("I am die!");
		}
		
		//测试第二次垃圾回收
		fg = null;
		//手动垃圾回收
		System.gc();
		//判断对象受否存货
		System.out.println("第二次垃圾回收自救结果：");
		Thread.currentThread().sleep(1000);
		if(fg != null){
			fg.isActive();
		}else{
			System.out.println("I am die!");
		}
	}
}
