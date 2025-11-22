package com.service;

import java.util.Scanner;

import com.dao.Employee_DAO;
import com.entity.EmployeeDetails;

public class Employee_Service 
{
	Scanner scan =  new Scanner(System.in);
	Employee_DAO employee_DAO = new Employee_DAO();
	public void employeeRegistration() 
	{
		System.out.print("Enter Employee Name : ");
		String eName = scan.next();
		System.out.print("Enter Employee Email-Id : ");
		String eEmail = scan.next();
		System.out.print("Enter Employee Dept-No : ");
		int eDeptNo = scan.nextInt();
		System.out.print("Enter Employee Salary : ");
		double eSalary = scan.nextDouble();
		System.out.print("Enter Employee PhNo : ");
		long ePhNo = scan.nextLong();
		System.out.print("Enter Employee Gender : ");
		String eGender = scan.next();
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmpName(eName);
		employeeDetails.setEmpEmail(eEmail);
		employeeDetails.setEmpDeptNo(eDeptNo);
		employeeDetails.setEmpSalary(eSalary);
		employeeDetails.setEmpPhNo(ePhNo);
		employeeDetails.setEmpGender(eGender);
		employee_DAO.insertionOperation(employeeDetails);
	}
	
	public void selectEmployeeDetailsByUsingEmployeeId()
	{
		System.out.print("Enter The Employee Id : ");
		int empId =  scan.nextInt();
		employee_DAO.findEmpDetailsUsingEmpId(empId);
	}
	
	public void updateEmpMobileByUsingEmployeeId()
	{
		System.out.print("Enter Employee Id : ");
		int empId =  scan.nextInt();
		System.out.println("Enter The New PhNo : ");
		long empPhno =  scan.nextLong();
		employee_DAO.updateEmpPhnoUsingEmpId(empId, empPhno);
	}
	
	public void updateEmpSalaryByUsingDeptNo()
	{
		System.out.print("Enter Employee Dept-No : ");
		int empDeptNo =  scan.nextInt();
		System.out.print("Enter New Employee Salary : ");
		double empSal =  scan.nextDouble();
		employee_DAO.updateEmpSalUsingDeptNo(empDeptNo,empSal);
	}
	
	public void deleteEmployeeDetailsByUsingEmployeeId() 
	{
		System.out.print("Enter The Employee Id : ");
		int empId =  scan.nextInt();
		employee_DAO.deleteEmpDetailsUsingEmpId(empId);
	}
	
	public void deleteEmployeeDetailsByUsingMail() 
	{
		System.out.print("Enter The Employee Mail : ");
		String empMail =  scan.next();
		employee_DAO.deleteEmpDetailsUsingEmail(empMail);
	}
	
	public void updateEmployeeMailUsingPhNO()
	{
		System.out.print("Enter Employee PhNo : ");
		long empPhNo =  scan.nextLong();
		System.out.print("Enter New Employee Email : ");
		String empMail=  scan.next();
		employee_DAO.updateEmpEmailUsingPhNO(empPhNo, empMail);
	}
	
	public void updateEmployeePhNoUsingEmail()
	{
		System.out.print("Enter Employee Mail : ");
		String empMail =  scan.next();
		System.out.print("Enter New Employee PhNo : ");
		long empPhNo =  scan.nextLong();
		employee_DAO.updateEmpPhNoUsingEmail(empMail, empPhNo);;
	}
	
	public void selectEmpDetailsUsingPhNo() 
	{
		System.out.print("Enter Employee PhNo : ");
		long empPhNo =  scan.nextLong();
		employee_DAO.getEmpDetailsUsingPhNo(empPhNo);
	}
	
	public void selectEmpDetailsUsingDeptNo()
	{
		System.out.print("Enter Employee Dept-No : ");
		int empDeptNo =  scan.nextInt();
		employee_DAO.getEmpDetailsUsingDeptNo(empDeptNo);
	}
	
}
