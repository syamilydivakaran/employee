<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.sql.*,java.util.*"%>
<%@ page import="com.mvc.beans.EmployeeBean"%>
<%@ page import="com.mvc.dao.EmployeeDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee view edit delete</title>
</head>
<body>
	<table border='1'>
		<tr>
			<td>sl no.</td>
			<td>name</td>
			<td>salary</td>
			<td>action</td>
			<td>action</td>
		</tr>
		<%
			int i = 1;
			EmployeeBean employeeBean = new EmployeeBean();
			ArrayList<EmployeeBean> employee = EmployeeDAO.listAllEmployees();
			for (EmployeeBean emp : employee) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=emp.getEmpName()%></td>
			<td><%=emp.getEmpSalary()%></td>
			<td><a href="EmployeeEdit.jsp?id=<%=emp.getEmpId()%>">Edit</a></td>
			<td><a href="EmployeeDelete.jsp?id=<%=emp.getEmpId()%>">Delete</a></td>
		</tr>
		<%
			i++;
			}
		%>
	</table>
</body>
</html>