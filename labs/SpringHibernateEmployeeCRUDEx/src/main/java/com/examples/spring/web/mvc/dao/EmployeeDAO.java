package com.examples.spring.web.mvc.dao;

import java.util.List;

import com.examples.spring.web.mvc.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}
