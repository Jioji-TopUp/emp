<%@ page contentType="text/html;charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<font color="red">${msg }</font>
  	<!-- <form action="LoginServlet" method="post"> -->
  	<form action="loginLogin.action" method="post">
    <p>
    	<label>用户名</label>
    	<input type="text" name="acc.uname"/>
	</p>
	<p>
    	<label>密码</label>
    	<input type="password" name="acc.passwd"/>
	</p>
	<p>
		<input type="submit" value="登录"/>
		<input type="reset" value="重置"/>
	</p>
	</form>
   </body>
</html>
