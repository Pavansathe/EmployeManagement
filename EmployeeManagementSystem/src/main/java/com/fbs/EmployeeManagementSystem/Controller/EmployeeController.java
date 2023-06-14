package com.fbs.EmployeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fbs.EmployeeManagementSystem.Model.Employee;
import com.fbs.EmployeeManagementSystem.Service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	
	//display list of employee
	@GetMapping("/employee")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployee",empService.getAllEmployee());
		return "index";
	}
	
	//request from index.html page 
	@GetMapping("/showNewEmployeeForm")
	//BuiltIn class to connect from controller to frontend
	//Its in key,value pair
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind data
		Employee employee = new Employee();
		                 //key   ,  value
		model.addAttribute("employee", employee);
		return "new_employee";//thymleaf template
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save employee to DB
		empService.saveEmployee(employee);
		return "redirect:/employee"; //redirect to homepage
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value ="id")int id, Model model){
	
		//get employee from ythe service
		Employee employee = empService.getEmployeeId(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value ="id") int id) {
		
		//call delete employee method  
		this.empService.deleteEmployeeById(id);
		
		return "redirect:/employee"; //redirect to homepage
	}
	
}
