<%@page import="entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>

	<form action="update">


		<%
			Employee e1 = (Employee) session.getAttribute("e1");
		%>

		Name: <input type="text" name="ename" value="<%=e1.getEname()%>"><br>
		Salary: <input type="text" name="esalary" value="<%=e1.getEsalary()%>"><br>
	    DepartmentId: <input type="text" name="edepartment" value="<%=e1.getEdepartment()%>">

		<input type="submit" value="save">
	</form>

</body>
</html>