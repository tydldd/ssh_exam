function loginControl(){
	var userName = $("#userName").val();
	var passWord = $("#passWord").val();
	var verifyCode = $("#verifyCode").val();
	 var params = {
			 "name":userName,
			 "password":passWord,
			 "verifyCode": verifyCode
	 };
	 $.ajax({
	   type:"post",
	   url: "isLogin_login.action",
	   data: params,
	   dataType:"json",
	   success:function(data){
		 if(data.message == "logSucess"){
			 window.location.href = "jsp/main.jsp";
		 }else if(data.message == "userIsNotExit"){
			 alert("当前用户不存在");
		 }else if(data.message == "verifyCodeIsNull"){
			 alert("验证码不能为空");
		 }else if(data.message == "verifyCodeError"){
			 alert("验证码输入错误");
		 }else{
			 window.location.href = "jsp/error/error.jsp?message="+data.message;
		 }
	 	},
	 	error:function(XMLHttpRequest, textStatus, errorThrown){
	 		//window.location.href="jsp/error/error.jsp";
	 		alert("XMLHttpRequest = " + XMLHttpRequest.message + "        textStatus =  " + textStatus + "      errorThrown=  " + errorThrown);
		}
	 });
}