package com.bridgelabz.employee_payroll_service;

import static org.junit.Assert.assertEquals;

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
	        assertEquals(3, entries);
	    }
}
