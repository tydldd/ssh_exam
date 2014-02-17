/**
 * Created with IntelliJ IDEA.
 * User: 成如
 * Date: 13-11-21
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */

$(function(){

});

function backValue(){
    var message = $("#test").val();
    var params = {
        "message":message
    };
    $.ajax({
        type:"post",
        url: "testDB_JSOperate.action",
        data: params,
        dataType:"json",
        success:function(data){
            //alert(data.message);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            //window.location.href="jsp/error/error.jsp";
            alert("XMLHttpRequest = " + XMLHttpRequest.message + "        textStatus =  " + textStatus + "      errorThrown=  " + errorThrown);
        }
    });
}

function selectTest(name){
    alert(name);
    var select = $("#select1").find('option:selected').val();
    alert("被选中的option：" + select);
    //得到
    var sel = $("select[id='select1']").children();
    sel.each(function(i){
        alert("每一个：" + $(this).val());
    });
}
