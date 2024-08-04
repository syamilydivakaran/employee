<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mvc.beans.EmployeeBean"%>
<%@ page import="com.mvc.dao.EmployeeDAO"%>
<%
	int eId = Integer.parseInt(request.getParameter("eId"));
	String eName = request.getParameter("eName");
	float eSalary = Float.parseFloat(request.getParameter("eSalary"));

	boolean flag = false;
	EmployeeBean employeeBean = new EmployeeBean();
	employeeBean.setEmpId(eId);
	employeeBean.setEmpName(eName.toUpperCase().trim());
	employeeBean.setEmpSalary(eSalary);
	
	flag = EmployeeDAO.updateEmployee(employeeBean);

	if (flag) {
		response.sendRedirect("EmployeeVED.jsp");
	} else {
		response.sendRedirect("error.html");
	}
%>
%>
