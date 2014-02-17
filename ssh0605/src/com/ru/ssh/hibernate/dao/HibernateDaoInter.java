package com.ru.ssh.hibernate.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.ru.ssh.hibernate.entity.Address;
import com.ru.ssh.hibernate.entity.Person;

public interface HibernateDaoInter {

	//向person和address表插入数据
	public void save(Person person) throws HibernateException;
	
	//update方法
	public void update(Person p) throws HibernateException;
	
	//从person表取数据
	public List<Person> getPersonList(int currentPage, int pageSize) throws HibernateException;
	
	//得到person表数据总条数
	public int getPersonTotalCount() throws HibernateException;
	
	//1-N从Address表取数据
	public List<Person> getAddressList(int currentPage,int pageSize,String address) throws HibernateException;
	
	//addressid="shanghai"的person表数据总条数
	public int getPersonTotalCountInshanghai(String addressdetail) throws HibernateException;
	
	//统计二级缓存
	public Map statisticsSecondCache() throws Exception;
	
	//懒加载测试
	public void lazyTest() throws Exception;
}
