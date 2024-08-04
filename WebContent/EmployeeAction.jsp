<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.sql.*,java.util.*" %>
<%@ page import="com.mvc.beans.EmployeeBean"%>
<%@ page import="com.mvc.dao.EmployeeDAO"%>

    

<%

String empName=request.getParameter("empName");
float empSalary=Float.parseFloat(request.getParameter("empSalary"));

EmployeeBean employeeBean=new EmployeeBean();
employeeBean.setEmpName(empName);
employeeBean.setEmpSalary(empSalary);

boolean flag=EmployeeDAO.insertEmployee(employeeBean);
if(flag){
	response.sendRedirect("index.html");
}else{
	response.sendRedirect("error.html");
}



%>