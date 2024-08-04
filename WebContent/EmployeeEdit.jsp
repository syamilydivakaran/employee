<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.sql.*,java.util.*"%>
<%@ page import="com.mvc.beans.EmployeeBean"%>
<%@ page import="com.mvc.dao.EmployeeDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Edit</title>
</head>
<body>
	<%
		int empId = Integer.parseInt(request.getParameter("id"));
		EmployeeBean employeeBean = new EmployeeBean();
		ArrayList<EmployeeBean> employee = EmployeeDAO.fetchEmployeeById(empId);
	%>
	<form name="employeeEdit" method="post" action="EmployeeEditAction.jsp">
<table>
<%
for(EmployeeBean emp : employee){
%>
<tr>
<td></td>
<td><input name="eId" type="hidden" value="<%=emp.getEmpId()%>"/></td>
</tr>
<tr>
<td>Name</td>
<td><input name="eName" type="text" value="<%=emp.getEmpName()%>"/></td>
</tr>
<tr>
<td>Salary</td>
<td><input name="eSalary" type="text" value="<%=emp.getEmpSalary()%>"/></td>
</tr>
<% }%>

<tr>
<td></td>
<td><input type="submit" value="UPDATE"/></td>
</tr>
</table>
</form>

</body>
</html>