package com.sheffieldcloud.developer.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class CheckForCookie
 */
@WebServlet("/CheckForCookie")
public class CheckForCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String>userDetails = getUser(request, response);
		if(userDetails==null || userDetails.size() == 0) {
			System.out.println("Pass Stage 1");
	         response.sendRedirect("http://localhost:8080/SheffieldCloudPlatform/Login.jsp");
			}
		else {
			System.out.println("Pass Stage 2");
			response.sendRedirect("GetDetails");
		}
	}
	public List<String>  getUser( HttpServletRequest request, HttpServletResponse response) throws  IOException{
		Cookie[] cookies = request.getCookies();
		List<String> userdetails = new ArrayList<>();
		if(cookies==null) {
			//Go to login
			return null;
		}
		else {
		for (Cookie cookie : cookies) {
		
			if(cookie.getName().equals("userdetails")&& cookie.getMaxAge()!=0) {
				System.out.println( "inside");
			String jwt =URLDecoder.decode( cookie.getValue().toString(), "UTF-8" );
			System.out.println(jwt + "Jwt");
		    ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Jwt jwtcookie = mapper.readValue(jwt, Jwt.class);
			String id = jwtcookie.getCustomer().getUniqueId();
			String firstname = jwtcookie.getCustomer().getFirstname();
			userdetails.add(id);
			userdetails.add(firstname);
			
			}
		}

	return userdetails;
	}
	}
}