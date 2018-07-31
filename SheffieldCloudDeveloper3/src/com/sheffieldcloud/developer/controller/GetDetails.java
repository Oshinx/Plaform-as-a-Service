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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheffieldcloud.developer.datasource.Jwt;





/**
 * Servlet implementation class GetDetails
 */
@WebServlet("/inpex.html")
public class GetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		List<String>userDetails = getUser(request, response);
		System.out.println(userDetails==null || userDetails.size() < 0);
		if(userDetails==null || userDetails.size() < 0) {
         response.sendRedirect("http://localhost:8080/SheffieldCloudPlatform/Login.jsp");
		}
		if(userDetails==null || userDetails.size() >= 0) { 
		String userId = userDetails.get(0);
		String name = userDetails.get(1);
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		System.out.println(userId + "get details");
		session.setAttribute("name",  name);
       response.sendRedirect("Documentation.jsp");}
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
