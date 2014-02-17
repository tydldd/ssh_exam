package com.ru.ssh.login.dao.imp;

import javassist.bytecode.ExceptionsAttribute;

import com.ru.ssh.base.hibernateUtil;
import com.ru.ssh.login.dao.LoginDaoInter;
import com.ru.ssh.login.entity.User;

/**
 * 登录dao
 * @author nanchengru
 * @since jdk1.6
 * @lastModify 2013-6-6
 * */
public class LoginDaoImp extends hibernateUtil implements LoginDaoInter{
	
	//得到用户信息
	public User getUserMessage(String name, String password) throws Exception{
		User user = null;
		String hql = "from User where name = ? and password = ?";
		user = (User) createQuery(hql, name,password).uniqueResult();
		return user;
	}
}
