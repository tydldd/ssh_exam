package com.ru.jvm.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：java堆内存溢出
 * 创建人：nange
 * 创建时间：2014年4月7日 下午8:01:46
 * 修改人：nange
 * 修改时间：2014年4月7日 下午8:01:46
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class HeapOut {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
