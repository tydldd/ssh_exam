package com.ru.ssh.login.service.imp;

import org.apache.struts2.ServletActionContext;

import com.ru.ssh.login.commons.LoginCommon;
import com.ru.ssh.login.dao.imp.LoginDaoImp;
import com.ru.ssh.login.entity.User;
import com.ru.ssh.login.service.LoginServiceInter;

public class LoginServiceImp extends LoginCommon implements LoginServiceInter{
	
	
	//得到用户信息
	public User getUserMessage(String name, String password) throws Exception{
		User user = this.loginDao.getUserMessage(name, password);
		return user;
	}
	
	//判断验证码
	public String judgeVerifyCode(String verifyCode,String message){
		String verifyCodeInSession = ServletActionContext.getRequest().getSession().getAttribute("rand").toString();
		if(verifyCode == null || verifyCode.equals("")){
			message = "verifyCodeIsNull";
		}else if(!verifyCode.equals(verifyCodeInSession)){
			message = "verifyCodeError";
		}else{
			message = "verifyCodeRight";
		}
		
		return message;
	}
	
}
