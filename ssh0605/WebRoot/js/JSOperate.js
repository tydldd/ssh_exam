/**
 * js实现增删改
 */

$(function(){
	var listIndex = 0;//列表索引值
	var addOrUpdate = "";//添加或修改标识
	
	$("#checkAll")[0].checked = false;
	//设置弹出层属性
 	$("#dialog").dialog({
		autoOpen: false,//隐藏弹出div
		height: 300,
		width: 350,
		modal: true,//遮罩其他页面内容
		buttons:{
			"确定":function(){
				var name = $("#name").val();
				var age = $("#age").val();
				var major = $("#major").val();
				
				if(addOrUpdate == "add"){//添加操作
					listIndex++;
					var htmlStr = "<tr id='stu'><td><input type='checkbox' id='user' value='" + listIndex + "'/></td><td >" +
						name + "</td><td>" + age + "</td><td>" + major + "</td></tr>";
					
					$("#content").append(htmlStr);
					
					$("#dialog").dialog("close");
				}else if(addOrUpdate == "update"){//修改操作
			 		
			 		var tdElementArray = $("input[id='user']:checked").parent().nextAll();
			 		$(tdElementArray[0]).text(name);
			 		$(tdElementArray[1]).text(age);
			 		$(tdElementArray[2]).text(major);
			 		$("#dialog").dialog("close");
				}
			},
			"取消":function(){
				$( this ).dialog( "close" );
			}
		}
		
	});
	
	//初始化分页
    //显示第一页信息,其他隐藏
    $("#currentPage").val("1");
    //总记录数
    var totalCount = parseInt($("#totalCount").val());
    var totalPage;
   if((totalCount % 3) == 0){
        totalPage = totalCount / 3;
    }else{
        totalPage = parseInt(totalCount / 3) + 1;
    }
    $("#total").text(totalPage);
    $("#totalPage").val(totalPage);
  
    if(totalPage == 1){
        //设置索引值
        $("#begIndex").text("1");
        $("#endIndex").text(totalCount);
    }else{
        //设置索引值
        $("#begIndex").text("1");
        $("#endIndex").text("3");
    }
    
   
    $("tr[id='stu']").each(function(){
        var index = $(this).attr("title");
        if((index/3) >= 1){
            $(this).css("display","none");
        }
    });
 	
 	//添加
 	$("#add").click(function(){
 	    //清空弹出层数据
 	    $("#name").val("");
        $("#age").val("");
        $("#major").val("");
        
        //弹出层
 		addOrUpdate = "add";
 		$("#dialog").dialog("open");
 		$("#dialog").dialog({title:"添加"});
 	});
 	
 	//修改
 	$("#update").click(function(){
 		
 		//判断是否没有选择用户，或者是否选择多个用户
 		userCount = $("input[id='user']:checked").length;
 		
 		if(userCount == 0){
			alert("必须选择一个用户");
			return;
		}else if(userCount > 1){
			alert("不能同时修改多的用户");
			return;
		}
		
		//初始化弹出层
		var tdElementArray = $("input[id='user']:checked").parent().nextAll();
		$("#name").val($(tdElementArray[0]).text());
        $("#age").val($(tdElementArray[1]).text());
        $("#major").val($(tdElementArray[2]).text());
		
		//弹出层
 		addOrUpdate = "update";
 		$("#dialog").dialog("open");
 		$("#dialog").dialog({title:"修改"});
 	});
 	
 	//删除
 	$("#del").click(function(){
 		$("input[id='user']:checked").each(function(){
 			$(this).parent().parent().remove();
 		});
 	});
 	
 	//保存
 	$("#save").click(function(){
 	    var dataStr = "";
 	    
 	    $("tr[id='stu']").each(function(){
 	        $(this).children().each(function(i){
 	            if(i != 0){
 	                if (i != 3) {
 	                    dataStr = dataStr +  $(this).text() + ",";
 	                }else{
 	                    dataStr = dataStr +  $(this).text();
 	                }
 	                
 	            }
 	        });
 	        dataStr = dataStr + ";";
 	    });
 	    
		 var  params  = {
							"dataStr":dataStr
						 };
		  $.ajax({
			type: "POST",
			/*url: "saveStudentData_JSOperate.action",*/
			url: "saveStudentData_JSOperate.action",
			data: params,
			dataType:"json",
			success: function(data){
			  if(data.message == "success"){
			      alert("保存成功");
			  }else{
			      alert("保存失败");
			  }
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
                alert("对不起,保存失败!" + textStatus);  
            } 
		 });
		 
 	});
 	
 	
 	
});

//点击标题栏复选框全选所有复选框
function checkAll(){
	if($("input[id='checkAll']:checked").length == 1){
		$("input[id='user']").each(function(){
			this.checked=true;
		});
	}else{
		$("input[id='user']").each(function(){
			this.checked=false;
		});
	}
}


//下一页
function nextPage(){
     //总记录数
    var totalCount = parseInt($("#totalCount").val());
    var nextPage = parseInt($("#currentPage").val()) + 1;
    var totalPage = parseInt($("#totalPage").val());
    
    
    if(nextPage <= totalPage){
        $("#currentPage").val(nextPage);
        $("#current").text(nextPage);
        $("tr[id='stu']").each(function(){
            var index = $(this).attr("title");
            if(nextPage - 1 <= index/3 && index/3 < nextPage){
                $(this).css("display","");
            }else{
               $(this).css("display","none");
             }
            
        });
    }
    if(nextPage >= totalPage){
        //设置索引值
        var cuPage = parseInt($("#currentPage").val());
        $("#begIndex").text((cuPage-1)*3 + 1);
        $("#endIndex").text(totalCount);
    }else{
         //设置索引值
        var cuPage = parseInt($("#currentPage").val());
        $("#begIndex").text((cuPage-1)*3 + 1);
        $("#endIndex").text(cuPage*3);
    }
}

//上一页
function prePage(){
     //总记录数
    var totalCount = parseInt($("#totalCount").val());
    var prePage = parseInt($("#currentPage").val()) -1;
    var totalPage = parseInt($("#totalPage").val());
    
    
    if(prePage >= 1){
        $("#currentPage").val(prePage);
        $("#current").text(prePage);
        $("tr[id='stu']").each(function(){
            var index = $(this).attr("title");
            if(prePage - 1 <= index/3 && index/3 < prePage){
                $(this).css("display","");
            }else{
               $(this).css("display","none");
             }
            
        });
    }
    if(nextPage <= totalPage){
        //设置索引值
        var cuPage = parseInt($("#currentPage").val());
        $("#begIndex").text((cuPage-1)*3 + 1);
        $("#endIndex").text(totalCount);
    }else{
         //设置索引值
        var cuPage = parseInt($("#currentPage").val());
        $("#begIndex").text((cuPage-1)*3 + 1);
        $("#endIndex").text(cuPage*3);
    }
}

//第一页
function jumpPage(page){
     //总记录数
    var totalCount = parseInt($("#totalCount").val());
    $("#currentPage").val(page);
    $("#current").text(page);
    var totalPage = parseInt($("#totalPage").val());
    
    if(totalPage == 1){
        //设置索引值
        $("#begIndex").text("1");
        $("#endIndex").text(totalCount);
    }else{
        //设置索引值
        $("#begIndex").text("1");
        $("#endIndex").text("3");
    }
    
    $("tr[id='stu']").each(function(){
        var index = $(this).attr("title");
        if(page - 1 <= index/3 && index/3 < page){
            $(this).css("display","");
        }else{
           $(this).css("display","none");
         }
    });
}

//跳到最后一页
function jumpLastPage(){
     //总记录数
    var totalCount = parseInt($("#totalCount").val());
    var totalPage = parseInt($("#totalPage").val());
    $("#currentPage").val(totalPage);
    $("#current").text(totalPage);
    
  //设置索引值
    var cuPage = parseInt($("#currentPage").val());
    $("#begIndex").text((cuPage-1)*3 + 1);
    $("#endIndex").text(totalCount);
    
    $("tr[id='stu']").each(function(){
        var index = $(this).attr("title");
        if(totalPage - 1 <= index/3 && index/3 < totalPage){
            $(this).css("display","");
        }else{
           $(this).css("display","none");
         }
    });
}
