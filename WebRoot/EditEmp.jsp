<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'EditEmp.jsp' starting page</title>

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
	This is Edit Emp page.
	<br>
	<!-- <form action="EditEmpServlet" method="post"> -->
	<form action="editEmp.action" method="post">
	<p>
		<label>Name</label> 
		<input type="text" name="emp.name" value="${obj.name }"/>
	</p>
	<p>
		<label>Gender</label> 
		<input type="radio" name="emp.sex" value="M" <c:if test="${obj.sex=='M'}">checked="checked"</c:if>/>男 
		<input type="radio" name="emp.sex" value="F" <c:if test="${obj.sex=='F'}">checked="checked"</c:if>/>女
	</p>
	<p>
		<label>Dept.</label>
		<select name="emp.dept">
			<option value="0" <c:if test="${obj.dept=='0'}">selected='selected'</c:if>>团委</option>
			<option value="1" <c:if test="${obj.dept=='1'}">selected='selected'</c:if>>后勤</option>
			<option value="2" <c:if test="${obj.dept=='2'}">selected='selected'</c:if>>工会</option>
		</select>
	</p>
	<p>
		<input type="submit" name="btn" value="保存"/>
		<input type="hidden" name="emp.id" value="${obj.id }"/>		
	</p>
	</form>
</body>
</html>
