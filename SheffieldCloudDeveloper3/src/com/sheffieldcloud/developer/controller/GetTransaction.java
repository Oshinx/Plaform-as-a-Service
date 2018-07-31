package com.sheffieldcloud.developer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import com.sheffieldcloud.developer.datasource.BillingDao;
import com.sheffieldcloud.developer.datasource.Transaction;


/**
 * Servlet implementation class Transaction
 */
@WebServlet("/GETTransaction")
public class GetTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         BillingDao billingDao = new  BillingDao();
         billingDao.getConnection();
         HttpSession session = request.getSession();
   	  String userId = null;
         if(session.getAttribute("userId")!=null) {
          userId = session.getAttribute("userId").toString();
         }
     
         System.out.println("user id get Transaction" + userId);
         String bal = billingDao.getAccountBalance(userId);
    	 List<Transaction> transactions = billingDao.getDeveloperTransaction(userId);
         session.setAttribute("tlist",transactions );  
         session.setAttribute("peanuts", bal);
         
         System.out.println(transactions.size());
         response.sendRedirect("Transaction.jsp");
       
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}

}
