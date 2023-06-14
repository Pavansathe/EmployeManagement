package com.fbs.EmployeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fbs.EmployeeManagementSystem.Model.Employee;
import com.fbs.EmployeeManagementSystem.Repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService{

	//autowire employee repository
	@Autowired
	EmployeeRepository empRepository;
	
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepository.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		this.empRepository.save(employee);
		
	}


	@Override
	public Employee getEmployeeId(int id) {
		Optional<Employee> optional = empRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent())
		{
			employee = optional.get();
			
		}else {
			throw new RuntimeException("Employee not found for id "+id);
			
			
		}
		return employee;
		
	}


	@Override
	public void deleteEmployeeById(int id) {
		this.empRepository.deleteById(id);
		
	}

}
