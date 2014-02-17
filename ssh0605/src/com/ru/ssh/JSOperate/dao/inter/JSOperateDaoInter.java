package com.ru.ssh.JSOperate.dao.inter;

import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.base.page.PageBean;
import org.hibernate.HibernateException;

import java.util.List;

public interface JSOperateDaoInter {
	
	public boolean saveStuData(String name, String age, String major) throws HibernateException;
	public List<Student> getStuDataByDatabase() throws HibernateException;
    public List<Object[]> getUser(String message) throws HibernateException;
    public List<Object[]> datalogList(String sql, PageBean pageBean)  throws  Exception;
    public int getDatalogCount(String sql) throws  Exception;
    public List<Object> getTaskName() throws Exception;
    public List getRelateList();
}
