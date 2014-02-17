package com.ru.ssh.hibernate.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;
import com.ru.ssh.base.page.PageBean;
import com.ru.ssh.hibernate.entity.Address;
import com.ru.ssh.hibernate.entity.Person;
import com.ru.ssh.hibernate.service.HibernateServiceInter;

/**
 * Hibernate Action
 * @author NanChengRu
 * @lastModify 2013-6-7
 * @since jdk1.7
 * */
public class HibernateAction extends ActionSupport{
	Logger log = Logger.getLogger(HibernateAction.class);
	private String message;
	private HibernateServiceInter hibernateService;
	private PageBean<Person> pageBean;
	private int currentPage = 1;
	private int pageSize = 10;
	private Map cacheEntries;


	//插入数据
	public String save(){
		try {
			Address address = new Address();
			address.setAddressdetail("shenzhen");
			for(int i = 0; i < 10; i++){
				Person person = new Person();
				person.setName("ru" + i);
				person.setAge("24");
				person.setAddress(address);
				hibernateService.save(person);
			}
			
		} catch (HibernateException e) {
			String errorMessage = "插入数据，数据库操作失败！";
			operateExceptionAndLog(e,errorMessage);
			return "sucess";
		}
		message = "0";
		return "sucess";
	}
	
	
	
	//N-1 得到person列表（address的id存在）
	public String getPersonListByAddressid(){
		try {
			int totalCount = hibernateService.getPersonTotalCount();
			System.out.println("action   totalCount = " + totalCount);
			List<Person> personList = hibernateService.getPersonList(currentPage, pageSize);
			pageBean = new PageBean<Person>(totalCount, currentPage, personList);
		} catch (Exception e) {
			String errorMessage = "得到person列表（address的id存在），数据库操作失败";
			operateExceptionAndLog(e, errorMessage);
			return "error";
		}
		return "personlist";
	}
	
	//1-N从Address表取数据
	public String getAddressPersonList(){
		try {
			int totalCount = hibernateService.getPersonTotalCountInshanghai("zhejiang");
			List<Person> personList = hibernateService.getAddressList(currentPage, pageSize,"zhejiang");
			pageBean = new PageBean<Person>(totalCount, currentPage, personList);
		} catch (Exception e) {
			String errorMessage = "1-N从Address表取数据，数据库操作失败";
			operateExceptionAndLog(e, errorMessage);
			return "error";
		}
		return "addressPersonList";
	}
	
	//统计二级缓存
	public String statisticsSecondCache(){
		try {
			cacheEntries = hibernateService.statisticsSecondCache();
		} catch (Exception e) {
			String errorMessage = "统计二级缓存失败！";
			operateExceptionAndLog(e,errorMessage);
			return "error";
		} 
		
		return "secondCache";
	}
	
	//懒加载测试
	public String lazyTest(){
		try {
			hibernateService.lazyTest();
		} catch (Exception e) {
			String errorMessage = "懒加载测试，数据库操作失败！";
			operateExceptionAndLog(e,errorMessage);
			return "error";
		}
		return "lazyTest";
	}
	
	
	//弹出层
	public String alertPage(){
		message = "1234qwer";
		log.info("弹出曾：message = 1234qwer");
		return "alertPage";
	}
	
	//日志记录
	public void operateExceptionAndLog(Exception e,String errorMessage){
		message = errorMessage + "\n错误信息：" + e.getMessage() + "\n错误原因：" + e.getCause();
		log.error(message);
		e.printStackTrace();
	}
	
	
	public HibernateServiceInter getHibernateService() {
		return hibernateService;
	}
	public void setHibernateService(HibernateServiceInter hibernateService) {
		this.hibernateService = hibernateService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PageBean<Person> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Person> pageBean) {
		this.pageBean = pageBean;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map getCacheEntries() {
		return cacheEntries;
	}

	public void setCacheEntries(Map cacheEntries) {
		this.cacheEntries = cacheEntries;
	}
}
