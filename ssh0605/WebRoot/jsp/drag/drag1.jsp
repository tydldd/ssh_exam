<%--
  Created by IntelliJ IDEA.
  User: 成如
  Date: 13-11-25
  Time: 下午2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
     <script type="text/javascript" src="/js/jQuery1.9.1-min.js"></script>
     <script type="text/javascript" src="/js/jquery-ui/ui/jquery.ui.core.js"></script>
      <script>
          $(function() {
              $( "#dragsource" ).draggable();
          })
      </script>
  </head>
  <body>
      <div id="container">
          <div id="dragsource">
              <p>拽我!</p>
          </div>
      </div><!-- End container -->
  </body>
</html>