package com.ru.ssh.base;

import com.ru.ssh.hibernate.entity.Address;
import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * 
 * 
 * 项目名称：ssh0605
 * 类描述： hibernate数据库操作类
 * 创建人：成如
 * 创建时间：2013年10月27日 上午11:34:49
 * 修改人：成如
 * 修改时间：2013年10月27日 上午11:34:49
 * 修改备注：必须在spring配置文件中为此类设置sessionFactory属性,其他的DAO只需要继承这个类即可
 * @since  jdk1.7
 * @version 1.0
 */
@SuppressWarnings("all")
public class hibernateUtil extends HibernateDaoSupport{
	
	
	/*******使用HQL语句执行数据库操作*******/
	
	/**
	 * 
	 * createQuery(创建一个hibernate hql 查询)
	 * @param hql
	 * @param values
	 * @return Query
	 */
	public Query createQuery(String hql, Object... values)  throws HibernateException{
		Query query = getSession().createQuery(hql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		return query;
	}
	/**
	 * 
	 * queryList(hibernateHQL数据库list查询)
     * 注：当查询的记录为空时，依然返回list对象，其大小为0
	 * @param hql
	 * @param values
	 * @return Query
	 */
	public List createQueryList(String hql, Object... values)  throws HibernateException {
		Query query = getSession().createQuery(hql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		return query.list();
	}
	
	/**
	 * 
	 * createQueryByPage(分页操作方法取自SpringSide. 创建Query对象.)
	 * 
	 * dao.createQuery(hql)  
	 * dao.createQuery(hql,arg0);  
	 * dao.createQuery(hql,arg0,arg1);  
	 * dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * 
	 * @param hql
	 * @param currentPage
	 * @param pageSize
	 * @param values
	 * @return List
	 */
	public List createQueryByPage(String hql,int currentPage,int pageSize, Object... values) {
		Query query = getSession().createQuery(hql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	/**
	 * 
	 * upOrDelOperate(hibernate 删除修改操作)
	 * @param hql
	 * @param values
	 * @return Query
	 */
	public boolean upOrDelOperate(String hql, Object... values) throws HibernateException{
		Query query = getSession().createQuery(hql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		int result = query.executeUpdate();
		if(result > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * save(hibernate 添加操作)
	 * @param entity
	 * @return boolean
	 */
	public boolean save(T entity)  throws HibernateException{
		getSession().save(entity);
		return true;
	}
	
	
	/*******使用SQL语句执行数据库操作*******/
	
	/**
	 * 
	 * createSqlQuery(创建SQL 查询:得到一个Object)
     * 注：返回对象可能为空
	 * @param sql
	 * @param values
	 * @throws HibernateException
	 * @return Query
	 */
	public Object createSqlQuery(String sql, Object... values)  throws HibernateException{
		SQLQuery query = getSession().createSQLQuery(sql);
		
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		return query.uniqueResult();
	}
	
	/**
	 * 
	 * createSqlQueryList(创建SQL 查询:得到List<Object[]>)
     * 注：当查询的记录为空时，依然返回list对象，其大小为0
	 * @param sql
	 * @param values
	 * @throws HibernateException
	 * @return List
	 */
	public List<Object[]> createSqlQueryList(String sql, Object... values)  throws HibernateException {
		SQLQuery query = getSession().createSQLQuery(sql);
		
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		return query.list();
	}

    /**
     *得到list<object>
     * @param sql
     * @param values
     * @return
     * @throws HibernateException
     */
    public List<Object> createSqlQueryzObjectList(String sql, Object... values)  throws HibernateException {
        SQLQuery query = getSession().createSQLQuery(sql);

        if(values != null && values.length != 0){
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query.list();
    }
	
	
	/**
	 * 
	 * createSqlQueryListT(创建SQL 查询:得到List<T>)
	 * @param sql
	 * @param entytyClass
	 * @param values
	 * @throws HibernateException
	 * @return List
	 */
	public List createSqlQueryListT(String sql, Class entytyClass, Object... values)  throws HibernateException {
		SQLQuery query = getSession().createSQLQuery(sql);
		
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		
		return query.addEntity(entytyClass).list();
	}

    public List createSqlQueryTList(String sql, String relate, String table1Alias,String table2Alias, Class entytyClass, Object... values)  throws HibernateException {
        SQLQuery query = getSession().createSQLQuery(sql).addEntity("addr", Address.class).addJoin("per","addr.persons");

        if(values != null && values.length != 0){
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        List list = query.list();
        System.out.print("list.长度 = " + list.size());
        return list;
    }
	
	/**
	 * 
	 * createSqlQueryByPage(分页操作方法 查询：得到List<Object[]>)
	 * @param sql
	 * @param currentPage
	 * @param pageSize
	 * @param values
	 * @return
	 * @return List
	 */
	public List<Object[]> createSqlQueryByPage(String sql,int currentPage,int pageSize, Object... values) {
		SQLQuery query = getSession().createSQLQuery(sql);
		
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	}
	
	/**
	 * 
	 * createSqlQueryTByPage(分页操作方法 查询：得到List<T>)
	 * @param sql
	 * @param entytyClass
	 * @param currentPage
	 * @param pageSize
	 * @param values
	 * @return List
	 */
	public List createSqlQueryTByPage(String sql, Class entytyClass,int currentPage,int pageSize, Object... values) {
		SQLQuery query = getSession().createSQLQuery(sql);
		
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.addEntity(entytyClass).list();
	}
	
	/**
	 * 
	 * saveUpOrDelSqlOper(SQL增删改操作)
	 * @param sql
	 * @param values
	 * @throws HibernateException
	 * @return boolean
	 */
	public boolean saveUpOrDelSqlOper(String sql, Object... values) throws HibernateException{
		SQLQuery query = getSession().createSQLQuery(sql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		int result = query.executeUpdate();
		if(result > 0){
			return true;
		}
		return false;
	}
	
	
	//批量插入数据
	public void batckInject(int numbers){
		Session session = this.getSession();
		for(int i = 0; i < numbers; i++){
			Object obj = new Object();
			session.save(obj);
			if(i % 20 == 0){
				session.flush();
				session.clear();
			}
		}
		
	}
}
