package com.sheffieldcloud.developer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sheffieldcloud.developer.datasource.Customer;
import com.sheffieldcloud.developer.datasource.DeveloperDao;
import com.sheffieldcloud.developer.util.RandomIdGenerator;




/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      processRequest(request, response);
	}
    
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstname = request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String uniqueId = RandomIdGenerator.generateUniqueId();
	
		System.out.println(uniqueId);
		String role = "developer";
		Customer c = new Customer();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setEmail(email);
		c.setPassword(password);
		c.setUniqueId(uniqueId);
		c.setRole(role);
		c.setAmount("0");
		DeveloperDao dao = new DeveloperDao();

		
		try {
			dao.getConnection();
			dao.registerUser(c);
			response.sendRedirect("Home.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
}
