<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Hibernate  N-1关联</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jQuery1.9.1-min.js"></script>
	<style type="text/css">
		.table_1{border-width: 1px;}
		.title{text-align: center;color: red;}
	</style>
  </head>
  		
  <body>
  	<div class="title">N-1关联</div>
  	<s:set id="personList" value="pageBean.pageBeanList"></s:set>
  	<form action="getPersonListByAddressid_hibernate.action" id="submitform" method="post">
	   	<table class="table_1">
	   		<tr>
	   			<td>ID</td>
	   			<td>姓名</td>
	   			<td>年龄</td>
	   			<td>地址</td>
	   		</tr>
	   		<s:iterator id="person" value="#personList">
		   		<tr>
		   			<td><s:property value="#person.id"/></td>
		   			<td><s:property value="#person.name"/></td>
		   			<td><s:property value="#person.age"/></td>
		   			<td><s:property value="#person.address.addressdetail"/></td>
		   		</tr>
	   		</s:iterator>
	   	</table>
	   	<%-- 分页 --%>
   		<jsp:include page="/jsp/page/page.jsp"></jsp:include>
  	</form>
  </body>
</html>
