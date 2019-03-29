package com.examples.spring.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriBuilder;

import com.examples.spring.web.rest.exception.LoginException;
import com.examples.spring.web.rest.exception.ValidationException;
import com.examples.spring.web.rest.model.Employee;
import com.examples.spring.web.rest.model.ErrorDetails;
import com.examples.spring.web.rest.service.EmployeeService;

/**
 * Handles requests for the employee management.
 */
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;

	@Autowired
	EmployeeService empService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public HttpEntity<? extends Object> addEmployee(@RequestBody Employee employee, WebRequest request,
			HttpSession session, BindingResult bindingResult) throws LoginException, ValidationException, URISyntaxException {

		validator.validate(employee, bindingResult);

//		if (!this.isAuthenticated(session)) {
//			throw new LoginException("Access Denied. Request to login before accessing this service.");
//		}
		
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}		

		String empId = empService.add(employee);

		
		//return new ResponseEntity<String>(empId, HttpStatus.CREATED);
		URI locationUri = new URI("/SpringRESTEmployeeCRUDEx/employees/"+empId);
		return ResponseEntity.created(locationUri).build();
//		return new ResponseEntity<Employee>(employee, HttpStatus.OK);		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public HttpEntity<List<Employee>> listEmployees(HttpSession session) {

//		if (!this.isAuthenticated(session)) {
//			throw new LoginException("Access Denied. Request to login before accessing this service.");
//		}		
		
//		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES).cachePrivate()).body(empService.list());
		
		return new ResponseEntity<List<Employee>>(empService.list(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public HttpEntity<Employee> getEmployee(@PathVariable String id, HttpSession session) {
		
//		if (!this.isAuthenticated(session)) {
//			throw new LoginException("Access Denied. Request to login before accessing this service.");
//		}
		
		return new ResponseEntity<Employee>(empService.get(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public HttpEntity<? extends Object> updateEmployee(@RequestBody Employee employee, @PathVariable String id,
			WebRequest request, HttpSession session, BindingResult bindingResult) throws ValidationException {

		validator.validate(employee, bindingResult);
		
//		if (!this.isAuthenticated(session)) {
//			throw new LoginException("Access Denied. Request to login before accessing this service.");
//		}
		
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}

		employee.setId(id);
		empService.update(employee);

		return new ResponseEntity<String>("{\"Status\":\"Success\"}", HttpStatus.OK);
//		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public HttpEntity<String> deleteEmployee(@PathVariable String id, HttpSession session) {
		
//		if (!this.isAuthenticated(session)) {
//			throw new LoginException("Access Denied. Request to login before accessing this service.");
//		}				

		empService.delete(id);
		
		return new ResponseEntity<String>("{\"Status\":\"Success\"}", HttpStatus.OK);
	}
	
	private boolean isAuthenticated(HttpSession session)
	{
		return session.getAttribute("userName") != null;
	}

	@ExceptionHandler(ValidationException.class)
	public HttpEntity<ErrorDetails> handleValidationError(ValidationException ex, WebRequest request) {
		StringBuilder validationErrors = new StringBuilder("Validation Error(s): ");
		ex.getValError().getFieldErrors()
				.forEach(item -> validationErrors.append(item.getDefaultMessage()).append(" "));

		ErrorDetails errorDetails = new ErrorDetails(new Date(), validationErrors.toString(),
				request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
