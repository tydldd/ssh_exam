<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jQuery1.9.1-min.js"></script>
	<script type="text/javascript" src="js/login/login.js"></script>
	<style type="text/css">
		.user{text-align: center;font-size: 20px;}
		.verifyCode{float:left;}
		#randImage{width: 100px;height: 22px;}
	</style>
  </head>
  
  
  <body>
    	<div class="user">用户登录</div>
    	<div>
	    	<p>姓　名：<input id="userName" type="text" value="ru" alt="请输入姓名"/></p>
	  		<p>密　码：<input id="passWord" type="password" value="123456" alt="请输入密码"></p>
	  		<p>
	  			<span class="verifyCode">验证码：<input id="verifyCode" type="text"></span>
	  			<img id="randImage" src="jsp/verifyCodeImg.jsp?Math.random();"/>
	  		</p>
	  		<input type="button" value="登录" onclick="loginControl()">
 		</div> 	
  </body>
</html>
