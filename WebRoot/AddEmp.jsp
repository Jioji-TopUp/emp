<%@ page contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'AddEmp.jsp' starting page</title>

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
	This is Add Emp page.
	<br>
	<!-- <form action="AddEmpServlet" method="post"> -->
	<form action="addEmp.action" method="post">
	<p>
		<label>Name</label> 
		<input type="text" name="emp.name"/>
	</p>
	<p>
		<label>Gender</label> 
		<input type="radio" name="emp.sex" value="M" checked="checked" />男 
		<input type="radio" name="emp.sex" value="F" />女
	</p>
	<p>
		<label>Dept.</label>
		<select name="emp.dept">
			<option value="0">团委</option>
			<option value="1" selected="selected">后勤</option>
			<option value="2">工会</option>
		</select>
	</p>
	<p>
		<input type="submit" name="btn" value="保存"/>		
	</p>
	</form>
</body>
</html>
