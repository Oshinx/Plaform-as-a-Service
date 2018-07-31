package com.sheffieldcloud.developer.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheffieldcloud.developer.datasource.Jwt;


/**
 * Servlet implementation class LogoutRedirect
 */
@WebServlet("/LogoutRedirect")
public class LogoutRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	        	ObjectMapper mapper = new ObjectMapper();
	        	System.out.println("inn");
	        	if(cookie.getName().equals("userdetails") && cookie.getMaxAge() !=0) {
	    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    		System.out.println(URLDecoder.decode(cookie.getValue().toString(),"UTF-8"));
	    		 Jwt jwt = mapper.readValue(URLDecoder.decode(cookie.getValue().toString(),"UTF-8"),Jwt.class);
	             System.out.println(jwt.getIssuer()+"issuer"); 

	    		 cookie.setValue("");
		            cookie.setPath("/");
		            cookie.setMaxAge(0);
		            response.addCookie(cookie);
	    		 }
	        
	        	}
		response.sendRedirect("Home.jsp");
	
	}



}
