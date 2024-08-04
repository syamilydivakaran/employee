<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.sql.*,java.util.*"%>
<%@ page import="com.mvc.beans.EmployeeBean"%>
<%@ page import="com.mvc.dao.EmployeeDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>:: Delete Category ::</title>
</head>
<body>
	<%
		int empId = Integer.parseInt(request.getParameter("id"));
		EmployeeBean employeeBean = new EmployeeBean();
		ArrayList<EmployeeBean> employee = EmployeeDAO.fetchEmployeeById(empId);
	%>

	<form name="employeeDelete" method="post"
		action="EmployeeDeleteAction.jsp">
		<table>
			<%
				for (EmployeeBean emp : employee) {
			%>
			<tr>
				<td></td>
				<td><input name="eId" type="hidden" value="<%=emp.getEmpId()%>" /></td>
			</tr>
			<!--  
			<tr>
				<td>Name</td>
				<td><input name="eName" type="text"
					value="<%=emp.getEmpName()%>" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="eSalary" type="text"
					value="<%=emp.getEmpSalary()%>" /></td>
			</tr>
			-->
			<%
				}
			%>
			<tr>
				<td></td>
				<td><input type="submit" value="DELETE" /></td>
			</tr>

		</table>
	</form>
</body>
</html>