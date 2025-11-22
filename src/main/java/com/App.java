package com;

import java.util.Scanner;

import com.service.Employee_Service;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		System.out.println("------ WELCOME TO EMPLOYEE MANAGEMENT SYSTEM ------");
    	Scanner scan = new Scanner(System.in);
    	boolean exit = true;
		Employee_Service employee_Service = new Employee_Service();
    	while(exit)
    	{
        	System.out.println("Choose An Option : \n1. Employee Registration \n2. Get Employee Details By EmpId \n3. Update Employee PhNo Using Employee Id"
        			+ "\n4. Update Employee Salary Using Dept-No \n5. Delete Employee Details Using Employee-Id "
        			+ "\n6. Delete Employee Details Using Email \n7. Update Employee Email Using Employee PhNo \n8. Update Employee PhNo Using Employee Email"
        			+ "\n9. Get Employee Details By PhNo \n10. Get Employee Details By DeptNo \n11. To Exit");
        	int choice = scan.nextInt();
        	
        	switch (choice) {
    		case 1:
    			employee_Service.employeeRegistration();
    			System.out.println();
    			break;
    		case 2:
    			employee_Service.selectEmployeeDetailsByUsingEmployeeId();
    			System.out.println();
    			break;
    		case 3:
    			employee_Service.updateEmpMobileByUsingEmployeeId();
    			System.out.println();
    			break;
    		case 4:
    			employee_Service.updateEmpSalaryByUsingDeptNo();
    			System.out.println();
    			break;
    		case 5:
    			employee_Service.deleteEmployeeDetailsByUsingEmployeeId();
    			System.out.println();
    			break;
    		case 6:
    			employee_Service.deleteEmployeeDetailsByUsingMail();
    			System.out.println();
    			break;
    		case 7:
    			employee_Service.updateEmployeeMailUsingPhNO();
    			System.out.println();
    			break;
    		case 8:
    			employee_Service.updateEmployeePhNoUsingEmail();
    			System.out.println();
    			break;
    		case 9:
    			employee_Service.selectEmpDetailsUsingPhNo();
    			System.out.println();
    			break;
    		case 10:
    			employee_Service.selectEmpDetailsUsingDeptNo();
    			System.out.println();
    			break;
    		case 11:
    			exit = false;
    			System.out.println("---- THANK YOU ----");
    			break;
    		default:
    			System.out.println("Invalid Option Selected");
    			break;
    		}

    	}
    }
}
