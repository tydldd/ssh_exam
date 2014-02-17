package com.ru.ssh.login.dao;

import com.ru.ssh.login.entity.User;

public interface LoginDaoInter {
	public User getUserMessage(String name, String password) throws Exception;
}
