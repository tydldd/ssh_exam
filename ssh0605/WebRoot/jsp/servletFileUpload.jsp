<%--
  Created by IntelliJ IDEA.
  User: 成如
  Date: 14-1-2
  Time: 上午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<style>
    * {
        font-family: "宋体";
        font-size: 14px
    }
</style>
<body>
<p align="center">请您选择需要上传的文件</p>
<form id="form1" name="form1" method="post"
      action="/fileUpload.do" enctype="multipart/form-data">
    <table border="0" align="center">
        <tr>
            <td>上传人：</td>
            <td><input name="name" type="text" id="name" size="20"></td>
        </tr>
        <tr>
            <td>上传文件：</td>
            <td><input name="file" type="file" size="20"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="submit" value="提交"> <input
                    type="reset" name="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
