package com.sheffieldcloud.developer.datasource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DeveloperDao {
    private DataSource dataSource;
    private Connection con = null;
	private String db_url = "jdbc:mysql://localhost:3306/sheffieldcloud";
    private String username = "roots";
	private String password = "pass";
	 
	/*//get database connection
	public boolean getConnection() {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/sheffieldcloud");
			con = dataSource.getConnection();
			return true;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	*/
    
    public void getConnection() {
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   try {
			con = DriverManager.getConnection(db_url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	//create a user and store in database
	   
	public void registerUser(Customer c) throws SQLException {
		  String sqlsmtreg = "INSERT INTO  customer_details(firstname,lastname,email,password, unique_id,role,amount)VALUES (?,?,?,?,?,?,?)";
		   PreparedStatement ps = con.prepareStatement(sqlsmtreg);
		   
		   ps.setString(1, c.getFirstname());
		   ps.setString(2, c.getLastname());
		   ps.setString(3, c.getEmail());
		   ps.setString(4, c.getPassword());
		   ps.setString(5, c.getUniqueId());
		   ps.setString(6, c.getRole());
		   ps.setString(7, c.getAmount());
		   ps.executeUpdate();
		
	}
	
	//save appName
	public void registerApp(String developerId, String appName) {
		String sql ="insert  into app (developer_uniqueid,app_name)values(?,?)"; 
		PreparedStatement ps;
		try {
		    ps = con.prepareStatement(sql);
			ps.setString(1, developerId);
			ps.setString(2, appName);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
    	
    
}
