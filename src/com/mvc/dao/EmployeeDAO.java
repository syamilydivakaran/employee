package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.beans.EmployeeBean;

public class EmployeeDAO {
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	static boolean flag = false;

	// --------------START------get connection---------------
	public static Connection getDbConnection() throws SQLException {
		try {
			DBDAO.connect();
			con = DBDAO.getDbCon();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// ------------------END-----------database connection--------------------

	// --------------START-------------insert details-------------------------

	public static boolean insertEmployee(EmployeeBean employeeBean) throws SQLException {
		try {
			con = getDbConnection();
			pst = con.prepareStatement("insert into employee(emp_name)values(?)");
			pst.setString(1, employeeBean.getEmpName());
			pst.setFloat(1, employeeBean.getEmpSalary());
			pst.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	// --------------END------insert details-------------------------

	// ------------------START---------------get employees----------------------------------------
	public static ArrayList<EmployeeBean> listAllEmployees() throws SQLException {
		ArrayList<EmployeeBean> employeeBean = new ArrayList<EmployeeBean>();
		con = getDbConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM employee");
			rs = pst.executeQuery();
			while (rs.next()) {
				EmployeeBean employee = new EmployeeBean();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setEmpSalary(rs.getFloat(3));
				employeeBean.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeBean;
	}

	// --------------END----------------------------------------------------------------

	// ---------------------------------fetchEmployeeById--------------------------------------
	public static ArrayList<EmployeeBean> fetchEmployeeById(int empId) throws SQLException {
		ArrayList<EmployeeBean> employeeBean = new ArrayList<EmployeeBean>();
		con = getDbConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM employee where emp_id=" + empId + " ");
			rs = pst.executeQuery();
			while (rs.next()) {
				EmployeeBean employee = new EmployeeBean();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setEmpSalary(rs.getFloat(3));
				employeeBean.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeBean;
	}
	// --------------END----------------------------------------------------------------
	
	
	//------------------------update employee---------------------------------
	public static boolean updateEmployee(EmployeeBean employeeBean)throws Exception{
	con=getDbConnection();
	boolean flag=false;
	try {
	pst=con.prepareStatement("update employee set emp_name=? ,"
			+ " emp_salary=? where emp_id =?");
	pst.setString(1,employeeBean.getEmpName());
	pst.setFloat(2,employeeBean.getEmpSalary());
	pst.setInt(3,employeeBean.getEmpId());
	pst.executeUpdate();
	flag=true;
	}
	catch(SQLException sql){
	sql.printStackTrace();
	}
	finally{
	con.close();
	}
	return flag;
	}
	//---------------------------------------end-------------------------------
	
	//----------------------delete employee-----------------------------------
	public static boolean deleteEmployee(EmployeeBean employeeBean)throws Exception{
	con=getDbConnection();
	boolean flag=false;
	try {
	pst=con.prepareStatement("delete from employee where emp_id =?");
	System.out.println("delete from enquiry where e_id ="+employeeBean.getEmpId()+"");
	pst.setInt(1,employeeBean.getEmpId());
	pst.executeUpdate();
	flag=true;
	}
	catch(SQLException sql){
	sql.printStackTrace();
	}
	finally{
	con.close();
	}
	return flag;
	}
	//---------------------------------------end-------------------------------

}
