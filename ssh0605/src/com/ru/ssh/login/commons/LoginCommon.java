package com.ru.ssh.login.commons;

import com.ru.ssh.login.dao.LoginDaoInter;
import com.ru.ssh.login.service.LoginServiceInter;

public class LoginCommon {
	public LoginDaoInter loginDao;
	
	public LoginDaoInter getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDaoInter loginDao) {
		this.loginDao = loginDao;
	}
	
}
