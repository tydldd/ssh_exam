<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	 <base href="<%=basePath%>">
	<title>jQuery UI Dialog - Modal form</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery1.10.2.js"></script>
	<!-- jquery ui dialog使用的js -->
	<script src="js/jquery-ui/ui/jquery.ui.core.js"></script>
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
	
	<script>
		$(function(){
			
			//设置弹出层属性
		 	$("#dialogForm").dialog({
		 		title:"form弹出层实例",
				autoOpen: false,
				height: 200,
				width: 350,
				modal: true,//遮罩其他页面内容
				buttons:{
					"确定":function(){
						$("#shandowDiv").css("display","block");
						var title = $("#dialogForm").dialog("option","title");//获取属性值
						alert(title);
					},
					"禁止操作":function(){
						$("#dialogForm").dialog("disable");
					},
					"取消":function(){
						$( this ).dialog( "close" );
					}
				},//按钮
				position:[200,-50],//显示位置
				resizable:true,//是否可调整大小
				
				//事件展示
				open:function(event,ui){
					$("#dialogForm").dialog({title:"form弹出层"});
				},//打开弹出层时触发事件
				close:function(event,ui){
					//alert("关闭对话框时，触发事件");
					$("#alert").css("display","block");
				},//关闭dialog时触发事件
				focus:function(event,ui){
					//alert("对话框获得焦点时执行");
				},
				dragStart:function(event,ui){
					//alert("开始对话框拖动时执行");
				},
				resizeStart:function(event,ui){
					alert("开始调整对话框大小时执行");
				}
				
			});
			
		});
		
		//注册点击事件
		function startDialog(){
			//触发弹出层
			$("#dialogForm").dialog("open");
			//$("#dialogForm").dialog("close");
		}
	</script>
</head>
<body>

	<div>
		<p>使用：</p>
		<li>自己设置弹出层属性时，使用$("#dialogForm").dialog("open")，不能使用$("#dialogForm").dialog();</li>
		<li>设置dialog的属性值，设置事件</li>
		<li>在jquery.ui.dialog.css的.ui-dialog .ui-dialog-buttonpane button中设置按钮高度</li>
		<li>在jquery.ui.theme.css的.ui-widget中设置dialog按钮字体大小</li>
		<li>在jquery.ui.dialog.css的.ui-dialog .ui-dialog-buttonpane .ui-dialog-buttonset中设置居中</li>
	</div>
	
	<div id="shandowDiv" style="display: none;">
		这是一个隐藏div
	</div>
	
	<!-- 弹出层div -->
	<div id="dialogForm">
		<p>这是一个form的弹出层例子</p>
	</div>
	
	<div id="alert" style="display: none;">
		额外弹出层!!!!!!!!!!!!!!!!
	</div>
	
	<input type="button" value="dialog" onclick="startDialog()" id="dialogButton"/>
</body>
</html>
