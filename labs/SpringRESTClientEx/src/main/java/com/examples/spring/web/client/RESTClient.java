package com.examples.spring.web.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.examples.spring.web.rest.model.Employee;
import com.examples.spring.web.rest.model.Login;

public class RESTClient {

	private static String BASE_URL = "http://localhost:8080/SpringRESTEmployeeCRUDEx";
	private static String LOGIN_URI = "/authenticate";
	
	
	private static String EMP_CREATE_URI = "/employee";
	private static String EMP_GET_ALL_URI = "/employee";
	private static String EMP_GET_URI = "/employee/{id}";
	private static String EMP_UPDATE_URI = "/employee/{id}";
	private static String EMP_DELETE_URI = "/employee/{id}";	

	public static void main(String[] args) throws URISyntaxException {

		RESTClient restClient = new RESTClient();
		
		RestTemplate restTemplate = new RestTemplate();
		
		//restTemplate.exchange(url, method, requestEntity, responseType)
		
//		ResponseEntity<List> response = restTemplate.getForObject(new URI(BASE_URL + EMP_GET_ALL_URI), List.class);
		
		
//		Login credentials = new Login("admin", "admin@123");		
//		
//		RequestEntity<Login> request = new RequestEntity<Login>(credentials, HttpMethod.POST, new URI(BASE_URL + LOGIN_URI));
//		
//		ResponseEntity<String> response = restTemplate.exchange(request, String.class);
//		
//		System.out.println(response.getBody());		
		
		
		
		RequestEntity<Employee> empCreate = new RequestEntity<Employee>(restClient.createEmployee(), HttpMethod.POST, new URI(BASE_URL + EMP_CREATE_URI));
		
		ResponseEntity<String> empResponse = restTemplate.exchange(empCreate, String.class);
		
//		ResponseEntity<String> empResponse = restTemplate.postForEntity(new URI(BASE_URL + EMP_CREATE_URI), restClient.createEmployee(), String.class);
//		
//		System.out.println(empResponse.getBody());		
		
//		String empResponse = restTemplate.postForObject(new URI(BASE_URL + EMP_CREATE_URI), restClient.createEmployee(), String.class);		
		
//		URI empResponse = restTemplate.postForLocation(new URI(BASE_URL + EMP_CREATE_URI), restClient.createEmployee());		
		
		
//		String empId = restTemplate.postForObject(EMP_CREATE_URL, restClient.createEmployee(), String.class);
//		
//		System.out.println(empId);
//		
//		Employee emp = restTemplate.getForObject(EMP_GET_URL, Employee.class, empId);
//		System.out.println(emp.getId() + ", " + emp.getName());
		
	}

	private Employee createEmployee() {
		Employee emp = new Employee();
		emp.setName("John");
		emp.setAge(35);
		emp.setGender("Male");

		return emp;
	}
	
	private void create()
	{
		
	}
	
	private void update()
	{
		
	}
	
	private void get()
	{
		
	}
	
	private void getAll()
	{
		
	}
	
	private void delete()
	{
		
	}

}
