package com.bridgelabz.employee_payroll_service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
    Scanner scanner = new Scanner(System.in);
    public void readEmployeeDataFromConsole() {
        System.out.println("Enter Employee Id");
        int id = scanner.nextInt();
        System.out.println("Enter Employee Name");
        String Name = scanner.next();
        System.out.println("Enter the salary");
        int salary = scanner.nextInt();
        employeePayrollList.add(new EmployeePayrollData(id, Name, salary));
    }
    public void writeEmployeeDataInConsole()
    {
        System.out.println("Writing Employee Pay Roll Data \n" + employeePayrollList);
 
	}
    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        System.out.println("Welcome to the Employee_Payroll_Services");
        employeePayrollService.readEmployeeDataFromConsole();
        employeePayrollService.writeEmployeeDataInConsole();
    }
}

 