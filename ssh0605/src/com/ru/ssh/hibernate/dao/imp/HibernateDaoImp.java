package com.ru.ssh.hibernate.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ru.ssh.base.hibernateUtil;
import com.ru.ssh.hibernate.dao.HibernateDaoInter;
import com.ru.ssh.hibernate.entity.Address;
import com.ru.ssh.hibernate.entity.Person;

/**
 * hibernate Dao
 * 
 * @author NanChengRu
 * @since jdk1.7
 * @lastModify 2013-6-7
 * */
public class HibernateDaoImp extends hibernateUtil implements HibernateDaoInter{
	Logger log = Logger.getLogger(HibernateDaoImp.class);
	//向person和address表插入数据
	public void save(Person person) throws HibernateException{
		getHibernateTemplate().save(person);
	}

	//update方法
	public void update(Person p) throws HibernateException{
		getHibernateTemplate().update(p);
	}
	
	//得到person表数据总条数
	public int getPersonTotalCount() throws HibernateException{
		String hql = "select count(*) from Person";
		int totalCount = Integer.parseInt(createQuery(hql).uniqueResult().toString());
		return totalCount;
	}
	
	//addressid="shanghai"的person表数据总条数
	public int getPersonTotalCountInshanghai(String addressdetail) throws HibernateException{
		String hql = "select count(p.id) from Person p,Address a where p.address.addressid=a.addressid and a.addressdetail=?";
		int totalCount = Integer.parseInt(createQuery(hql,addressdetail).uniqueResult().toString());
		log.info("dao   totalCount = " + totalCount);
		return totalCount;
	}
	
	//N-1从person表取数据
	//注：1.查询某个字段使用new Person(p.name,p.age)  2.查询person表全部字段：select p，p是别名。
	@SuppressWarnings("unchecked")
	public List<Person> getPersonList(int currentPage, int pageSize) throws HibernateException{
		List<Person> personList = null;
		String hql = "select p from Person p,Address a where p.address.addressid=a.addressid ";
		personList = createQueryByPage(hql, currentPage, pageSize);
		System.out.println("dao------personList = " + personList.size());
		return personList;
	}
	
	//1-N从Address表取数据
	@SuppressWarnings("unchecked")
	public List<Person> getAddressList(int currentPage,int pageSize,String address) throws HibernateException{
		List<Person> addressList = null;
		String hql = "select p from Person p join p.address a where p.address.addressid=a.addressid and a.addressdetail=?";
		addressList = createQueryByPage(hql, currentPage, pageSize,address);
		log.info("dao   addressList.size() = " + addressList.size());
		return addressList;
	}
	
	//统计二级缓存
	public Map statisticsSecondCache() throws Exception{
		Map cacheEntries = super.getSessionFactory().getStatistics().
			getSecondLevelCacheStatistics("com.ru.ssh.hibernate.entity.Person").getEntries();
		return cacheEntries;
	}
	
	//懒加载测试
	@SuppressWarnings("unchecked")
	public void lazyTest() throws Exception{
		String hql = "from Person";
		Query query = createQuery(hql);
		List<Person> personList = query.list();
		@SuppressWarnings("unused")
		String address = personList.get(0).getAddress().getAddressdetail();
	}
}
