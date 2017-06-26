<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ListEmp.jsp' starting page</title>
    
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
  	<h3>Welcome,${uname }</h3>
    This is List Emp page. <br>
    <a href="AddEmp.jsp">添加</a>
    <table border="1">
    	<tr>
    		<th>编号</th>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>部门</th>
    		<th>操作</th>
    	</tr>
    	<%-- jstl标签库 --%>
    	<c:forEach var="emp" items="${emps }" varStatus="order">
    		<tr <c:if test="${order.count%2==0}">bgcolor="#F8F8FF"</c:if>>
    			<td>${order.count }</td>
    			<td>${emp.name }</td>
    			<td>${emp.sex=='F'?'女':'男'}</td>
    			<td>
    				<c:choose>
    					<c:when test="${emp.dept=='0'}">团委</c:when>
    					<c:when test="${emp.dept=='1'}">后勤</c:when>
    					<c:when test="${emp.dept=='2'}">工会</c:when>
    				</c:choose>
    			</td>
    			<td>
    				<%-- <a href="FindEmpServlet?id=${emp.id }">修改</a>&nbsp;&nbsp; --%>
    				<a href="findEmp.action?emp.id=${emp.id }">修改</a>&nbsp;&nbsp;
    				<a href="javascript:onDelete(${emp.id});">删除</a>
    			</td>
    		</tr>
    	</c:forEach>   
    </table>
  </body>
  <script language="javascript">
  	function onDelete(eid){
  		if(window.confirm("Are you sure to delete?"))		
			/* window.location.href='DeleteEmpServlet?id='+eid; */	
			window.location.href='deleteEmp.action?emp.id='+eid;
  	}
  </script>
</html>
