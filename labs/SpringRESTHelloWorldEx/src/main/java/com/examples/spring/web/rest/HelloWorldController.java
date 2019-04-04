package com.examples.spring.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	public String sayHello() {
		System.out.println("HelloWorldController method called...");
		//return "<html><body><h1>Hello World from Spring REST</h1></body></html>";
		return "{ \"message\": \"Hello World from Spring REST\" }";
	}
	//http://localhost:8080/SpringRESTHelloWorldEx/
	
	@GetMapping(value="/greeting")
	public String greeting1(String msg) {
		return "Hello World from Spring REST without param";
	}
	
	@GetMapping(value="/greeting", params= {"msg"})
	public String greeting2(String msg) {
		return "Hello World from Spring REST - " + msg;
	}
	
	@PostMapping(value="/greeting", consumes= {"text/plain"})
	public String postGreeting1(@RequestBody String reqBody) {
		return "Received PLAIN TEXT Request: " + reqBody;
	}
	
	@PostMapping(value="/greeting", consumes= {"text/html"})
	public String postGreeting2(@RequestBody String reqBody) {
		return "Received HTML Request: " + reqBody;
	}	
	
	@RequestMapping(value="/greeting", method=RequestMethod.PUT)
	public String updateGreeting() {
		return "Hello World from Spring REST PUT";
	}
	
	@RequestMapping(value="/greeting", method=RequestMethod.DELETE)
	public String deleteGreeting() {
		return "Hello World from Spring REST DELETE";
	}	
}
