package com.ru.ssh.hibernate.service.imp;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.ru.ssh.hibernate.dao.HibernateDaoInter;
import com.ru.ssh.hibernate.entity.Address;
import com.ru.ssh.hibernate.entity.Person;
import com.ru.ssh.hibernate.service.HibernateServiceInter;

public class HibernateServiceImp implements HibernateServiceInter{
	Logger log = Logger.getLogger(HibernateServiceImp.class);
	private HibernateDaoInter hibernateDao;

	public HibernateDaoInter getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateDaoInter hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

	public void save(Person person) throws HibernateException {
		hibernateDao.save(person);
	}

	public List<Person> getPersonList(int currentPage, int pageSize) {
		List<Person> personList = hibernateDao.getPersonList(currentPage, pageSize);
		return personList;
	}

	public int getPersonTotalCount() {
		int totalCount = hibernateDao.getPersonTotalCount();
		return totalCount;
	}

	public List<Person> getAddressList(int currentPage, int pageSize,String address) {
		List<Person> addressList = hibernateDao.getAddressList(currentPage, pageSize,address);
		return addressList;
	}

	public int getPersonTotalCountInshanghai(String addressdetail) {
		int totalCount = hibernateDao.getPersonTotalCountInshanghai(addressdetail);
		return totalCount;
	}

	public void update(Person p) throws HibernateException {
		
		hibernateDao.save(p);
	}

	//统计二级缓存
	@SuppressWarnings("unchecked")
	public Map statisticsSecondCache() throws Exception{
		Map cacheEntries = hibernateDao.statisticsSecondCache();
		return cacheEntries;
	}

	//懒加载测试
	public void lazyTest() throws Exception{
		hibernateDao.lazyTest();
	}
	

}
