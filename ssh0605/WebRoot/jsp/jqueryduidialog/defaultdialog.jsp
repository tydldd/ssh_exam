<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jquery ui dialog无按钮</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" language="javascript" src="js/jQuery1.9.1-min.js"></script>
	
	<!-- jquery ui dialog使用的js -->
	<script type="text/javascript" language="javascript" src="js/jquery-ui/ui/jquery.ui.core.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.widget.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.mouse.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.draggable.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.position.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.resizable.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.button.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.dialog.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.effect.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.effect-blind.js"></script>
	<script src="js/jquery-ui/ui/jquery.ui.effect-explode.js"></script>
	
	<!-- jquery ui dialog使用的css -->
	<link rel="stylesheet" href="js/jquery-ui/themes/base/jquery.ui.all.css">
	
	<script type="text/javascript">
		$(function(){
			$("#jq-ui-dialog").dialog();
		});
	</script>
  </head>
  
  <body>
  	<div>
  		<p>使用：</p>
  		<div>1、标题框</div>
  		<li>通过jquery.ui.dialog.css的.ui-dialog .ui-dialog-titlebar设置标题大小</li>
  		<li>通过jquery.ui.theme.css的.ui-widget-header设置标题背景和标题边框以及字体</li>
  		<li>通过jquery.ui.theme.css设置关闭按钮样式</li>
  		
  		<li>注：不设置弹出层属性信息时：使用$("#id").dialog();不能使用$("#id").dialog("open");</li>
  	</div>	
   	<div id="jq-ui-dialog" title="jquery-ui-dialog弹出层">
   		这是一个弹出层例子
   	</div>
  </body>
</html>
