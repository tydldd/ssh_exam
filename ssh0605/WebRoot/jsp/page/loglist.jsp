<%--
  Created by IntelliJ IDEA.
  User: 成如
  Date: 13-11-22
  Time: 下午1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
      <script type="text/javascript" src="js/jQuery1.9.1-min.js"></script>
      <script type="text/javascript" src="js/page/page.js"></script>
  </head>
  <body>
  <s:debug></s:debug>
  <input type="hidden" id="taskNameH" value="<s:property value='queryBean.taskName'/>">
  <input type="hidden" id="statusH" value="<s:property value='queryBean.status'/>">
  <input type="hidden" id="levelH" value="<s:property value='queryBean.level'/>">
    <form id="form" action="getDagaLogList_page.action" method="post">
        <div>
            <table>
                <tr>
                    <td>任务名：
                        <select id="taskName" name="queryBean.taskName">
                            <option value="all" selected = "selected">全部</option>
                            <s:iterator value="taskNameList" id="taskName" status="taskNameStutas">
                                <option value="<s:property value='taskName' />"><s:property value='taskName' /></option>
                            </s:iterator>
                        </select>
                    </td>
                    <td>状态：
                        <select id="status" name="queryBean.status">
                            <option selected="selected" value="all">全部</option>
                            <option value="INFO">信息</option>
                            <option value="ERROR">错误</option>
                            <option value="WARN">警告</option>
                        </select>
                    </td>
                    <td>级别：
                        <select id="level" name="queryBean.level">
                            <option selected="selected" value="all">全部</option>
                            <option value="1">一</option>
                            <option value="2">二</option>
                            <option value="3">三</option>
                        </select>
                    </td>
                    <td>
                        <input type="button" value="查询123" onclick="querylog()"/>
                    </td>
                </tr>
            </table>
        </div>

    <div id="list">
        <table border="1px">
            <s:iterator value="pageBean.pageBeanList" id="log" status="status">
                <tr>
                    <td>任务名：<s:property value="#log[0]"/> </td>
                    <td>状  态：<s:property value="#log[1]"/> </td>
                    <td>级  别：<s:property value="#log[2]"/> </td>
                    <td>描  述：<s:property value="#log[3]"/> </td>
                    <td>日  期：<s:property value="#log[4]"/> </td>
                </tr>
            </s:iterator>
        </table>
    </div>

   <div id="page">
        <jsp:include page="page.jsp"/>
   </div>
    </form>
  </body>
</html>