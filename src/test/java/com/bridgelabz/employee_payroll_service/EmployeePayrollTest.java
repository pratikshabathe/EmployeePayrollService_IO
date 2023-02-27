package com.bridgelabz.employee_payroll_service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollTest {

	 @Test
	    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		 	EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        employeePayrollService.addEmployee(new EmployeePayrollData(1, "Bill ", 10000));
	        employeePayrollService.addEmployee(new EmployeePayrollData(2, "Tersia ", 20000));
	        employeePayrollService.addEmployee(new EmployeePayrollData(3, "Charlie ", 30000));
	        employeePayrollService.writeEmployeeDataToFile();
	        long entries = employeePayrollService.countEntries();
	        Assert.assertEquals(3, entries);
	    }
	 @Test
	    public void given3EmployeesWhenWrittenToFileShouldPrintEmployeeEntries() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        employeePayrollService.addEmployee(new EmployeePayrollData(1, "Bill", 10000));
	        employeePayrollService.addEmployee(new EmployeePayrollData(2, "Tersia", 20000));
	        employeePayrollService.addEmployee(new EmployeePayrollData(3, "Charlie", 30000));
	        employeePayrollService.writeEmployeeDataToFile();
	        employeePayrollService.printData();
	        long entries = employeePayrollService.countEntries();
	        Assert.assertEquals(3, entries);
	    }

	    @Test
	    public void given3EmployeesWhenWrittenToFileShouldPrintNumberOfEmployeeEntries() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        employeePayrollService.addEmployee(new EmployeePayrollData(1, "Bill", 10000));
	        employeePayrollService.addEmployee(new EmployeePayrollData(2, "Tersia", 20000));
	        employeePayrollService.addEmployee(new EmployeePayrollData(3, "Charlie", 30000));
	        employeePayrollService.writeEmployeeDataToFile();
	        long entries = employeePayrollService.countEntries();
	        System.out.println("Number of entries are " + entries);
	        Assert.assertEquals(3, entries);
	    }
}
