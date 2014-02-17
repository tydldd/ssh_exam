package com.ru.javaExam.utildatabase;

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
 * 修改备注：必须在spring配置文件中为此类设置sessionFactory属性,其他的DAO只需要继承这个类即可.在sping中继承此类的bean需要设置属性： parent="hibernateDao"
 * @since  jdk1.7
 * @version 1.0
 */
@SuppressWarnings("all")
public class HibernateUtil extends HibernateDaoSupport{
	
	
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
	 * @param hql
	 * @param values
	 * @return List  list<T> T表示一个对象
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
	 * @param entity 一个对象
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
	 * 
	 * createSqlQueryListT(创建SQL 查询:得到List<T>其中T为对象)
	 * @param sql sql语句（注：查询必须是全部字段，可以使用* 或者写全字段）
	 * @param entytyClass 实体类：Student.class
	 * @param values sql参数数组
	 * @throws HibernateException
	 * @return List 返回值是对应的对象list。如：List<Student> list = super.createSqlQueryListT(sql, Student.class);
	 */
	public List createSqlQueryTList(String sql, Class entytyClass, Object... values)  throws HibernateException {
		SQLQuery query = getSession().createSQLQuery(sql);
		
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		
		return query.addEntity(entytyClass).list();
	}

    /**
     *不能执行
     * @param sql
     * @param relate
     * @param table1Alias
     * @param table2Alias
     * @param entytyClass
     * @param values
     * @return
     * @throws HibernateException
     */
    public List createSqlQueryTList(String sql, String relate, String table1Alias,String table2Alias, Class entytyClass, Object... values)  throws HibernateException {
        SQLQuery query = getSession().createSQLQuery(sql);

        if(values != null && values.length != 0){
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.addEntity(table1Alias, entytyClass).addJoin(table2Alias,relate);
        return query.list();
    }

    /**
     *
     * createSqlQueryListT(查询（多表），得到两个多个实体对象数组)
     * @param sql 类似：SELECT {dtirule.*},{dtidict.*} FROM `T_DTI_RULE` {dtirule}
     * 		 inner join `T_DTI_DICT` {dtidict} on {dtirule}.`F_CATEGORY` = {dtidict}.`F_CODE`
     * 		   注：sql 中表别名必须：{dtidict}，查询必须：{dtirule.*}，条件必须：{dtirule}.`F_CATEGORY`
     *
     * 		   sql也可以这样写：
     * 		      SELECT {addr.*} FROM  `person` per INNER JOIN `address` addr" +
     *       " ON per.`address` = addr.`addressid`"
     * @param tableAlias1 表1的别名 如：dtirule
     * @param tableAlias2 表2的别名
     * @param entity1Class 表1的实体类 如：TDtiRule.class
     * @param entity2Class 表1的实体类
     * @param values sql参数
     * @throws HibernateException
     * @return List<Object[]> obejct[]指两个实体数组.如：[TDtiRule,TDtiDict]
     */
    public List<Object[]> createSqlQueryTArrayList(String sql,String tableAlias1, String tableAlias2, Class entity1Class, Class entity2Class, Object... values)  throws HibernateException {
        SQLQuery query = getSession().createSQLQuery(sql);

        if(values != null && values.length != 0){
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        query.addEntity(tableAlias1, entity1Class).addEntity(tableAlias2, entity2Class);

        return query.list();
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
