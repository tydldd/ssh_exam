/***************************ready主体部分开始******************************/
$(document).ready(function(){ 
	//分页跳转到多少页
	$("#jumpBtn").click(function(){
		var jumpTxt = $("#jumpTxt").val();
		var pageTotal = $("#pageTotal").val();
		var re=  /^[+]?\d+$/;
		if(jumpTxt == ""){
			alert("请输入跳转页码!");
			$("#jumpTxt").focus();
			return;
		}else if(!re.test(jumpTxt)){
			alert("请输入正确页码!");
			$("#jumpTxt").attr("value","");
			$("#jumpTxt").focus();
			return;
		}else{
			if(parseInt(jumpTxt) > parseInt(pageTotal)){
				$("#gocurrentpage").attr("value",pageTotal);
				document.getElementById("submitform").submit();
			}else if(jumpTxt <= 0){
				$("#gocurrentpage").attr("value",1);
				document.getElementById("submitform").submit();
			}else{
				$("#gocurrentpage").attr("value",jumpTxt);
				document.getElementById("submitform").submit();
			}
		} 
	});

});
/***************************ready主体部分结束******************************/
/***************************以下为各个方法*********************************/
//点击分页按钮触发的方法
function dividePage(current){
	$("#gocurrentpage").attr("value",current);
	$("#submitform").submit();
}
