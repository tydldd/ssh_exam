package com.ru.ssh.login.service;

import com.ru.ssh.login.entity.User;

public interface LoginServiceInter {

	public User getUserMessage(String name, String password) throws Exception;
	public String judgeVerifyCode(String verifyCode,String message);
}
