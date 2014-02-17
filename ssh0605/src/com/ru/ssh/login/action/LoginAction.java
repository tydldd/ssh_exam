package com.ru.ssh.login.action;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ru.ssh.login.commons.LoginCommon;
import com.ru.ssh.login.entity.User;
import com.ru.ssh.login.service.LoginServiceInter;

public class LoginAction extends ActionSupport{
	private Logger log = Logger.getLogger(LoginAction.class);
	private LoginServiceInter loginService;
	private String name;
	private String password;
	private String message;
	private String verifyCode;
	


	//判断用户登录信息是否正确
	public String isLogin(){
		User user = null;
		/*message = loginService.judgeVerifyCode(verifyCode, message);
		if(!message.equals("verifyCodeRight")){
			return "login";
		}*/
		
		try {
			user = loginService.getUserMessage(name, password);
		} catch (Exception e) {
			String errorMessage = "验证登录信息：操作数据库错误";
			operateWhenDatabaseFalse(e,errorMessage);
			return "login";
		}
		
		if(user ==null){
			message = "userIsNotExit";
			return "login";
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		message = "logSucess";
		return "login";
	}
	
	
	//数据库错误操作方法
	public void operateWhenDatabaseFalse(Exception e,String errorMessage){
		message = errorMessage + "\n错误信息：" + e.getMessage() + "\n错误原因：" + e.getCause();
		log.error(message);
		e.printStackTrace();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginServiceInter getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginServiceInter loginService) {
		this.loginService = loginService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
