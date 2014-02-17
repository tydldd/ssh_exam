<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hibernateMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jQuery1.9.1-min.js"></script>
	<script type="text/javascript" src="js/hibernate/hibernate.js"></script>
	<style type="text/css">
		.h1{font:15px;color: brown}
		ul li{padding-top: 10px;list-style-type:none;color: mediumorchid;padding-left:20px}
		ul li span{width: 15px;height: 15px;float: left;background-color: mediumorchid;margin-right: 5px;float: left;margin-top: 10px;}
	</style>
  </head>
  
  <body>
    <div>	
    	<ul>
    		<span class="h1">1.无连接表的N-1关联</span> 
    		<li><a href="javascript:void(0)" onclick="saveData()">添加数据</a></li>
    		<li><a href="getPersonListByAddressid_hibernate.action">N-1取Person表的数据</a></li>
    		<span class="h1">2.无连接表的1-N关联</span> 
    		<li><a href="getAddressPersonList_hibernate.action">1-N取Address表的数据</a></li>
    		<span>3.hibernate缓存统计</span>
    		<li><a href="statisticsSecondCache_hibernate.action">统计二级缓存</a></li>
    		<span>4.hibernate懒加载</span>
    		<li><a href="lazyTest_hibernate.action">懒加载</a></li>
    	</ul>
    	
    </div>
  </body>
</html>
