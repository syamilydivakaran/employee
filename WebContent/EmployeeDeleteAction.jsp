<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page language="java" import="java.sql.*,java.util.*"%>
<%@ page import="com.mvc.beans.EmployeeBean"%>
<%@ page import="com.mvc.dao.EmployeeDAO"%>
<%

int eId=Integer.parseInt(request.getParameter("eId"));
//int cid=(Integer)session.getAttribute("cateId");
boolean flag=false;
EmployeeBean employeeBean = new EmployeeBean();
employeeBean.setEmpId(eId);
flag=EmployeeDAO.deleteEmployee(employeeBean);
if(flag){
response.sendRedirect("EmployeeVED.jsp");
}
else{
response.sendRedirect("error.html");
}
%>