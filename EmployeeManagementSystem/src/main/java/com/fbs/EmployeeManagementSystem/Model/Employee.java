package com.fbs.EmployeeManagementSystem.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

// if we dont specify column/ table name than by default its field name
@Entity
@Table(name="MyEmployee")//schema =""
public class Employee {
	
	@Id
	//creating id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="first_name")
	 String firstName;
	
	@Column(name="last_name")
	 String lastName;
	
	@Column(name="email")
	 String email;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
