package com.bridgelabz.employee_payroll_service;

public class EmployeePayrollData {

	private int employeeId;
    private String employeeName;
    private int employeeSalary;
    public EmployeePayrollData(int employeeId, String employeeName, int employeeSalary) {
    	this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
	}

    @Override
    public String toString() {
    	
        return "employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary=" + employeeSalary  + "";
    }
}
