package com.fbs.EmployeeManagementSystem.Service;

import java.util.List;

import com.fbs.EmployeeManagementSystem.Model.Employee;

public interface EmployeeService {

	//create a method listOF EMployee
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeId(int id);
	void deleteEmployeeById(int id);
	
}
