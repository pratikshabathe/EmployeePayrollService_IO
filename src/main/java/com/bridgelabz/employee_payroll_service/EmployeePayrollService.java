package com.bridgelabz.employee_payroll_service;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
	
	 //creating object
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
    Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "C:\\Users\\shubh\\OneDrive\\Desktop\\New folder (2)";

    /*
     * Creating method to print data
     */
    public void readEmployeeDataFromConsole() {
        System.out.println("Enter Employee Id");
        int id = scanner.nextInt();
        System.out.println("Enter Employee Name");
        String Name = scanner.next();
        System.out.println("Enter the salary");
        int salary = scanner.nextInt();
        employeePayrollList.add(new EmployeePayrollData(id, Name, salary));
    }

    public void writeEmployeeDataInConsole() {
        System.out.println("Writing Employee Pay Roll Data \n" + employeePayrollList);
    }

    public void addEmployee(EmployeePayrollData employee) {
        employeePayrollList.add(employee);
    }

    public void writeEmployeeDataToFile() {
        checkFile();
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(FILE_PATH), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkFile() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
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

    public void printData() {
        try {
            Files.lines(Paths.get(FILE_PATH)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long readDataFromFile() {
        try {
            String data = Files.readString(Paths.get(FILE_PATH));
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countEntries();
    }
    
    public static void main(String[] args) {
    	//creating the object for accessing the method
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        System.out.println("Welcome to employee payRoll");
        employeePayrollService.readEmployeeDataFromConsole();
        employeePayrollService.writeEmployeeDataInConsole();
    }
}

 