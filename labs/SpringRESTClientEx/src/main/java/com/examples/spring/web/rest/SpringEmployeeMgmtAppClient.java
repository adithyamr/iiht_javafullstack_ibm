package com.examples.spring.web.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.examples.spring.web.rest.model.Employee;

public class SpringEmployeeMgmtAppClient {
	
	private static final String BASE_URL = "http://localhost:8080/SpringRESTEmployeeCRUDEx";
	private static final String EMPLOYEES_SERVICE_URI = "/employees";
	
	private static RestTemplate client;
	
	public static void main(String[] args) throws URISyntaxException
	{
		// STEP 1: Create REST TEMPLATE
		client = new RestTemplate();
		
		// List Employees
		listEmployees();
		
		// Create Employee
		createEmployee();
		
		// List Employees
		listEmployees();	

	}
	
	
	private static void createEmployee() throws URISyntaxException {
		// Create Employee
		RequestEntity<Employee> requestEntity = new RequestEntity<>(getEmployee(), HttpMethod.POST, new URI(BASE_URL + EMPLOYEES_SERVICE_URI) );		
		ResponseEntity<String> response = client.exchange(requestEntity, String.class);
		String message = response.getStatusCodeValue() == 201 ? "Employee Created Successfully" : "Employee Creation Failed";
		System.out.println(message);
		String path = response.getHeaders().getLocation().getPath();
		System.out.println("Employee URI:" + path.substring(path.lastIndexOf("/") + 1));
	}
	
	private static void listEmployees() throws URISyntaxException
	{
		// Option 1: Submitting request using Exchange method	
		RequestEntity<Employee> requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(BASE_URL + EMPLOYEES_SERVICE_URI) );
		ResponseEntity<List> response = client.exchange(requestEntity, List.class);
		System.out.println("Employees Count: " + response.getBody().size());
		System.out.println(response.getBody());
		
//		// Option 2: Submitting request using HTTP method specific Entity method
//		response = client.getForEntity(new URI(BASE_URL + EMPLOYEES_SERVICE_URI), List.class);
//		System.out.println(response.getBody());		
	}
	
	private static Employee getEmployee() {
		Employee emp = new Employee();
		emp.setName("Anand");
		emp.setGender("M");
		emp.setAge(40);
		emp.setDepartment("IT");
		emp.setCountry("India");
		return emp;
	}

}
