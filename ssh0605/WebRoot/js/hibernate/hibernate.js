function saveData(){
	var params = {
		
	};
	 $.ajax({
	   url: "save_hibernate.action",
	   data: params,
	   dataType:"json",
	   success:function(data){
		 if(data.message == "0"){
			 alert("数据插入成功");
		 }else{
			 window.location.href="jsp/error/error.jsp?message="+data.message;
		 }
	 	},
	 	error:function(XMLHttpRequest, textStatus, errorThrown){
	 		alert("数据插入失败！");
		}
	 });
}