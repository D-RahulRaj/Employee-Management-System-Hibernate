package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.EmployeeDetails;

public class Employee_DAO 
{
	public void insertionOperation(EmployeeDetails employeeDetails) 
	{
		// JPA STEPS
		
		// 1. LOAD THE PERSISTENCE.XML FILE
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		
		// 2. ESTABLISH THE CONNECTION AND 3. CREATE THE PLATFORM
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// 4. BEGIN THE TRANSACTION
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employeeDetails); // To Insert Data Automaticllly We Use Persist(Object) Method
		
		// 5. PERFORM THE OPERTAIONS (Insert, Update, Delete, Select)
		
		// 6. COMMIT THE TRANSACTION
		entityTransaction.commit();
	}
	
	public void findEmpDetailsUsingEmpId(int empid)
	{
		// JPA STEPS
	
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, empid);
		if (employeeDetails != null) 
		{
			System.out.println("Employee Name : "+employeeDetails.getEmpName());
			System.out.println("Employee Email : "+employeeDetails.getEmpEmail());
			System.out.println("Employee Dept-No : "+employeeDetails.getEmpDeptNo());
			System.out.println("Employee Salary : "+employeeDetails.getEmpSalary());
			System.out.println("Employee PhNo : "+employeeDetails.getEmpPhNo());
			System.out.println("Employee Gender : "+employeeDetails.getEmpGender());
		}
		
		else System.out.println("Employee Data Not Found");
	}
	
	public void updateEmpPhnoUsingEmpId(int empId, long empPhNo)
	{
		// JPA STEPS
		
			EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, empId);
			if (employeeDetails != null) 
			{
				employeeDetails.setEmpPhNo(empPhNo);
				entityManager.merge(employeeDetails);
				System.out.println("Phone Number Updated Successfully");
			}
			else System.out.println("Data Not Foud");
			entityTransaction.commit();
	}
	
	public void deleteEmpDetailsUsingEmpId(int empId)
	{
		// JPA STEPS
		
			EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, empId);
			if (employeeDetails != null) 
			{
				entityManager.remove(employeeDetails);
				System.out.println("Data Deleted Successfully");
			}
			else System.out.println("Data Not Foud");
			entityTransaction.commit();
	}
	
	public void updateEmpSalUsingDeptNo(int deptNo, double sal)
	{
		// JPQL - JAVA PERSISTENCE QUERY LANGUAGE WITH JPA STEPS
		String update = "update EmployeeDetails empDetails set empDetails.empSalary = ?1 where empDetails.empDeptNo = ?2";
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery(update);
		query.setParameter(1, sal);
		query.setParameter(2, deptNo);
		int result = query.executeUpdate();
		if(result!=0) 
			System.out.println("Salary Updated Successfully");
		else
			System.out.println("Department Not Found");
		entityTransaction.commit();
	}
	
	public void deleteEmpDetailsUsingEmail(String empMail)
	{
		// JPQl - JAVA PERSISTENCE QUERY LANGUAGE WITH JPA STEPS
			
			String delete = "delete from EmployeeDetails empDetails where empDetails.empEmail = ?1";
			EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery(delete);
			query.setParameter(1, empMail);
			int result = query.executeUpdate();
			if (result!= 0) 
			{
				System.out.println("Data Deleted Successfully");
			}
			else System.out.println("Data Not Foud");
			entityTransaction.commit();
	}
	
	public void updateEmpEmailUsingPhNO(long empPhNo,String empMail)
	{
		// JPQL Using Dynamic Inputs (Runtime Inputs) - 
		// Type 1 - Position Paratmeter (?postition)
		String updateEmailUsingPhno = 
				"update EmployeeDetails empDetails set empDetails.empEmail = ?1 where empDetails.empPhNo = ?2";
		 EntityManagerFactory emf =
				 Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		 EntityManager entityManager = emf.createEntityManager();
		 EntityTransaction entityTransaction = entityManager.getTransaction();
		 entityTransaction.begin();
		 Query query = entityManager.createQuery(updateEmailUsingPhno);
		 query.setParameter(1, empMail);
		 query.setParameter(2, empPhNo);
		 int result = query.executeUpdate();
			if(result!=0) 
				System.out.println("Email Updated Successfully");
			else
				System.out.println("Employee Data Not Found");
			entityTransaction.commit();
	}
	
	public void updateEmpPhNoUsingEmail(String empMail,long empPhNo)
	{
		// JPQL Using Dynamic Inputs (Runtime Inputs) - 
		// Type 2 - Named Paratmeter (:coulumnName)
		String updatePhNoUsingMail = 
				"update EmployeeDetails empDetails set empDetails.empPhNo = :empPhNo where empDetails.empEmail = :empMail";
		 EntityManagerFactory emf =
				 Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		 EntityManager entityManager = emf.createEntityManager();
		 EntityTransaction entityTransaction = entityManager.getTransaction();
		 entityTransaction.begin();
		 Query query = entityManager.createQuery(updatePhNoUsingMail);
		 query.setParameter("empPhNo", empPhNo);
		 query.setParameter("empMail", empMail);
		 int result = query.executeUpdate();
			if(result!=0) 
				System.out.println("PhNo Updated Successfully");
			else
				System.out.println("Employee Data Not Found");
			entityTransaction.commit();
	}
	
	public void getEmpDetailsUsingPhNo(long PhNo) 
	{
		// JPQL Using Dynamic Inputs (Runtime Inputs) And Along With getSingleResult();
		String selectEmpByPhNo = "select emp from EmployeeDetails emp where emp.empPhNo = :phoneNo";
		EntityManagerFactory emf =
				 Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		 EntityManager entityManager = emf.createEntityManager();
		 EntityTransaction entityTransaction = entityManager.getTransaction();
		 entityTransaction.begin();
		 Query query = entityManager.createQuery(selectEmpByPhNo);
		 query.setParameter("phoneNo",PhNo);
		 try {
			 EmployeeDetails employeeDetails = (EmployeeDetails) query.getSingleResult();
			 System.out.println("Employee Name : "+employeeDetails.getEmpName());
			 System.out.println("Employee Email : "+employeeDetails.getEmpEmail());
			 System.out.println("Employee Dept-No : "+employeeDetails.getEmpDeptNo());
		     System.out.println("Employee Salary : "+employeeDetails.getEmpSalary());
		     System.out.println("Employee PhNo : "+employeeDetails.getEmpPhNo());
			 System.out.println("Employee Gender : "+employeeDetails.getEmpGender());
		} catch (Exception e) {
			System.out.println("Employee Details Not Found");
		}
	}
	
	public void getEmpDetailsUsingDeptNo(int DeptNo) 
	{
		// JPQL Using Dynamic Inputs (Runtime Inputs) And Along With getSingleResult();
		String selectEmpByDeptNo = "select emp from EmployeeDetails emp where emp.empDeptNo = ?1";
		EntityManagerFactory emf =
				 Persistence.createEntityManagerFactory("Employee_Management_System_Using_Hibernate");
		 EntityManager entityManager = emf.createEntityManager();
		 EntityTransaction entityTransaction = entityManager.getTransaction();
		 entityTransaction.begin();
		 Query query = entityManager.createQuery(selectEmpByDeptNo);
		 query.setParameter(1,DeptNo);
		 try {
			 EmployeeDetails employeeDetails = (EmployeeDetails) query.getSingleResult();
			 System.out.println("Employee Name : "+employeeDetails.getEmpName());
			 System.out.println("Employee Email : "+employeeDetails.getEmpEmail());
			 System.out.println("Employee Dept-No : "+employeeDetails.getEmpDeptNo());
		     System.out.println("Employee Salary : "+employeeDetails.getEmpSalary());
		     System.out.println("Employee PhNo : "+employeeDetails.getEmpPhNo());
			 System.out.println("Employee Gender : "+employeeDetails.getEmpGender());
		} catch (Exception e) {
			System.out.println("Employee Details Not Found");
		}
	}
}
