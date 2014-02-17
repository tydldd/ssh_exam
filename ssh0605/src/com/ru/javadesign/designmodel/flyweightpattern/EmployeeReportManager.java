package com.ru.javadesign.designmodel.flyweightpattern;

/**
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：ru
 * 创建时间：2013-8-5 下午03:11:58
 * 修改人：ru
 * 修改时间：2013-8-5 下午03:11:58
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class EmployeeReportManager implements ReportManagerInter{
	private String num;
	
	/**
	 * 创建一个新的实例 EmployeeReportManager.
	 *
	 * @param num
	 */
	public EmployeeReportManager(String num) {
		super();
		this.num = num;
	}

	/* (non-Javadoc)
	 * @see com.ru.javaExam.designmodel.flyweightpattern.ReportManagerInter#createReport()
	 */
	public void createReport() {
		System.out.println("这是一个员工报表");	
	}

}
