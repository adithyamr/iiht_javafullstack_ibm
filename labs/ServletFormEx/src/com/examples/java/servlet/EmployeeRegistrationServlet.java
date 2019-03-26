package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Employee Registration Servlet
 */
public class EmployeeRegistrationServlet extends HttpServlet {
	
	/* 
	 * Called when getting loaded into web container
	 * We can specify the initialization logic here.
	 */
	public void init()
	{
		System.out.println("EmployeeRegistration Servlet Initialized...");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	
	/*
	 * Called for every HTTP request
	 */
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		
		HttpSession session = request.getSession();
		
		System.out.println("Session ID: " + session.getId());
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);

		response.setContentType("text/html");
				
		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.print("<p>Registration Successful.</p>");
		out.println("<p>UserName: " + userName + "</p>");
		out.println("<a href='index.html'>home</a>");
		out.println("</body></html>");
	}
	
	/* 
	 * Called when getting unloaded from web container
	 * We can specify the clean up logic here.
	 */	
	public void destroy()
	{
		System.out.println("EmployeeRegistration Servlet Destroyed...");		
	}

}
