package com.ru.ssh.JSOperate.dao.imp;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.base.hibernateUtil;
import com.ru.ssh.base.page.PageBean;
import com.ru.ssh.hibernate.entity.Person;
import org.hibernate.HibernateException;

import java.util.List;

public class JSOperateDaoImp extends hibernateUtil implements JSOperateDaoInter{
	
	/**
	 * 
	 * saveStuData(2通过数据库保存学生信息)
	 * @return boolean
	 */
	public boolean saveStuData(String name, String age, String major) throws HibernateException{
		String sql = "insert into student(name,age,major) values (?,?,?)";
		boolean bl = super.saveUpOrDelSqlOper(sql, name,age,major);
		
		if(bl == true){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * getStuDataByDatabase(2通过数据库获取学生信息)
	 * @return
	 * @throws HibernateException
	 * @return List<Student>
	 */
	public List<Student> getStuDataByDatabase() throws HibernateException{
		String sql = "select id, name , age , major from student";
		
		List<Student> list = super.createSqlQueryListT(sql, Student.class);
		
		return list;
	}

    public List<Object[]> getUser(String message) throws HibernateException{
        String sql = "select * from user where name = '" + message +"'";
        List<Object[]> list = super.createSqlQueryList(sql);
        return list;
    }

    /**
     * 查询列表
     * @param sql
     * @param pageBean
     * @return
     */
    public List<Object[]> datalogList(String sql, PageBean pageBean) throws  Exception{
        List<Object[]> logList = super.createSqlQueryByPage(sql, pageBean.getCurrentPage(), pageBean.getPageSize());
        return logList;
    }

    /**
     * 得到日志记录数
     * @return
     */
    public int getDatalogCount (String sql) throws  Exception{
        Object count = super.createSqlQuery(sql);
        if (count == null){
            return 0;
        }
        return Integer.parseInt(count.toString());
    }

    /**
     * 用户名列表
     * @return
     */
    public List<Object> getTaskName() throws Exception{
        String sql = "select taskname from datalog group by taskname";
        List<Object> taskNameList = super.createSqlQueryzObjectList(sql);
        return taskNameList;
    }

    public List getRelateList(){
        String sql = "SELECT {addr.*} FROM  `person` per INNER JOIN `address` addr" +
                " ON per.`address` = addr.`addressid`";
        List<Person> list = null;
        try {
           list = super.createSqlQueryTList(sql, "per.address", "per", "addr", Person.class);
       }catch (Exception e){
            e.printStackTrace();
       }
        for (Person person : list){
            System.out.print("  " + person.getName());
        }

        return list;
    }

}