package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Details")
public class EmployeeDetails 
{
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column(name = "emp_name", nullable = false)
	private String empName;
	@Column(name = "emp_email", unique = true, nullable = false)
	private String empEmail;
	@Column(name = "emp_salary", nullable = false)
	private double empSalary;
	@Column(name = "emp_deptno", nullable = false)
	private int empDeptNo;
	@Column(name = "emp_phno", nullable = false, unique = true)
	private long empPhNo;
	@Column(name = "emp_gender", nullable = false)
	private String empGender;
	
	public EmployeeDetails() { }

	public EmployeeDetails(int empId, String empName, String empEmail, double empSalary, int empDeptNo, long empPhNo,
			String empGender) 
	{
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empSalary = empSalary;
		this.empDeptNo = empDeptNo;
		this.empPhNo = empPhNo;
		this.empGender = empGender;
	}

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

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpDeptNo() {
		return empDeptNo;
	}

	public void setEmpDeptNo(int empDeptNo) {
		this.empDeptNo = empDeptNo;
	}

	public long getEmpPhNo() {
		return empPhNo;
	}

	public void setEmpPhNo(long empPhNo) {
		this.empPhNo = empPhNo;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}	
}
