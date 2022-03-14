package com.email.service;

import java.util.Scanner;

import com.gl.model.Employee;

public class TestMain {

	public static String getDeptName(int deptCode) {
		String deptName = null;
		switch (deptCode) {
		case 1: {
			deptName = "tech";
			break;
		}
		case 2: {
			deptName = "admin";
			break;
		}
		case 3: {
			deptName = "hr";
			break;
		}
		case 4: {
			deptName = "legal";
			break;
		}
		default:
			System.out.println("Invalid options");
		}
		return deptName;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String firstName;
		String secondName;
		int deptCode;

		System.out.println(" Welcome to IT Support Administrator ");

		// Employee Details
		System.out.println("Enter your first Name: ");
		firstName = scanner.next();
		System.out.println("Enter your second Name:");
		secondName = scanner.next();

		// Choose department
		do {

			System.out.println("Please enter the department from the following: ");
			System.out.println("1. Technical ");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");

			// retrieve data integer from the user
			deptCode = scanner.nextInt();
			System.out.println("Invalid department Code entered!! Try again !!");
			
		} while ((deptCode > 4 || deptCode <= 0));
		//
		// create customer and check credentials 
		Employee emp = new Employee(firstName, secondName);
		emp.setDept(getDeptName(deptCode));
		emp.setEmailId(CredentialService.generateEmailAddress(emp));
		
		// Generate the password
		emp.setPassword(CredentialService.generatePassword());
		CredentialService.showCredentials(emp);

	}

}
