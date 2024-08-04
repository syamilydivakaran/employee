package com.mvc.beans;

public class EmployeeBean {
	/*
	* Author : syamily
	* Date: 17/07/2024
	* Version:	v.0
	* Purpose : Bean/Model class for Employee
	*/
	private int empId;
	private String empName;
	private float empSalary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	
}
