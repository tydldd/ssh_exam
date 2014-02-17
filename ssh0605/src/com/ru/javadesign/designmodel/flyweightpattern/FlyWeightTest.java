package com.ru.javadesign.designmodel.flyweightpattern;

import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-5 下午03:41:05
 * 修改人：ru
 * 修改时间：2013-8-5 下午03:41:05
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class FlyWeightTest {

	/**
	 * 
	 * ( 执行享元代码 )
	 * @param  
	 * @return 
	 * @throws
	 */
	@Test
	public void test(){
		ReportManagerFactory rmf = new ReportManagerFactory();
		ReportManagerInter rmi = rmf.getFinancialReportManager("a");
		rmi.createReport();
	}
}
