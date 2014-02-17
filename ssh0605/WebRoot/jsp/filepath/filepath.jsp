<%@ page import="java.io.File" %>
<%--
  Created by IntelliJ IDEA.
  User: 成如
  Date: 13-11-10
  Time: 上午12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
    <%
        File file1 = new File("");
        File file2 = new File("/");

        String name1 = file1.getAbsolutePath();
        String name2 = file2.getAbsolutePath();
    %>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        File file3 = new File(basePath);
        String name3 = file3.getAbsolutePath();
    %>
    1、 File file1 = new File("")路径：<%=name1%><br>
    2、 File file2 = new File("/")路径：<%=name2%><br>
    3、 path = request.getContextPath()路径：<%=path%><br>
    4、 basepath = <%=basePath%><br>
    5、  File file3 = new File(basePath);路径：<%=name3%>
</body>
</html>