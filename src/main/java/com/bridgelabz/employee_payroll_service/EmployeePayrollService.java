package com.bridgelabz.employee_payroll_service;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
	
	 private List<EmployeePayrollData> employePayrollList = new ArrayList<EmployeePayrollData>();
	    Scanner scanner = new Scanner(System.in);
	    private static final String FILE_PATH = "C:\\Users\\MY PC\\Desktop\\PayRoll.txt";

	    public void readEmployeeDataFromConsole() {
	        System.out.println("Enter Employee Id");
	        int id = scanner.nextInt();
	        System.out.println("Enter Employee Name");
	        String Name = scanner.next();
	        System.out.println("Enter the salary");
	        int salary = scanner.nextInt();
	        employePayrollList.add(new EmployeePayrollData(id, Name, salary));
	    }

	    public void writeEmployeeDataInConsole() {
	        System.out.println("Writing Employee Pay Roll Data \n" + employePayrollList);
	    }

	    public void addEmployee(EmployeePayrollData employee) {
	        employePayrollList.add(employee);
	    }

	    public void writeEmployeeDataToFile() {
	        checkFile();
	        StringBuffer empBuffer = new StringBuffer();
	        employePayrollList.forEach(employee -> {
	            String employeeDataString = employee.toString().concat("\n");
	            empBuffer.append(employeeDataString);
	        });
	        try {
	            Files.write(Paths.get(FILE_PATH), empBuffer.toString().getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // method to create file if file doesn't exist
	    private void checkFile() {
	        File file = new File(FILE_PATH);
	        try {
	            // checking file already exists
	            if (!file.exists()) {
	                // if not creating a new file
	                file.createNewFile();
	                System.out.println("Created a file at " + FILE_PATH);
	            }
	        } catch (IOException e1) {
	            System.err.println("Problem encountered while creating a file");
	        }
	    }

	    public long countEntries() {
	        long entries = 0;
	        try {
	            entries = Files.lines(new File(FILE_PATH).toPath()).count();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return entries;
	    }
}

 