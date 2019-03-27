package com.examples.spring.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = {"/register"})
public class RegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegisterForm() {
		ModelAndView modelView = new ModelAndView("register");
		return modelView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView("success");
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		modelView.addObject("username",username);
		return modelView;
	}	
}
