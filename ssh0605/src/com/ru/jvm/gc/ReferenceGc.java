package com.ru.jvm.gc;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：手动垃圾回收
 * 创建人：nange
 * 创建时间：2014年4月17日 上午10:52:01
 * 修改人：nange
 * 修改时间：2014年4月17日 上午10:52:01
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class ReferenceGc {
	
	public static void main(String[] args) {
		ReferenceGc rg = new ReferenceGc();
		rg = null;
		
		System.out.println("回收开始");
		//手动垃圾回收
		System.gc();
	}
	
	/**
	 * 1、垃圾收集器在进行垃圾收集的时候会自动呼叫对象的finalize方法，用来进行一些用户自定义的非内存清理工作，
	 * 因为垃圾收集器不会处理内存以外的东西。所以，有的时候用户需要定义一些清理的方法，
	 * 比如说处理文件和端口之类的非内存资源。
	 * 
	 * 2、如果不想被回收这个对象，可以在这里让次对象被重新引用。如果gc执行完成此对象重写的
	 */
	protected void finalize() throws Throwable {
		System.out.println("回收对象！");
	}

}
