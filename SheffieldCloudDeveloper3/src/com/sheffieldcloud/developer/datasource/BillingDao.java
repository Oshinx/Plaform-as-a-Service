package com.sheffieldcloud.developer.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDao {
      //get connection 
	 private Connection con = null;
	   private String db_url = "jdbc:mysql://localhost:3306/sheffieldcloud";
	   private String username = "roots";
	   private String password = "pass";
	 
	   
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

	//charge customer 
	//parameter customer id, charge, app name
	public List<Transaction> getCustomerTransaction(String uniqueId) {
		String sql  = "SELECT app_name,ChargeFigure FROM bills where user_id=?";
		 List<Transaction> transactions = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setString(1, uniqueId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			 Transaction transact = new  Transaction();
			 transact.setAppname(rs.getString("app_name"));
			 transact.setCharge(rs.getString("ChargeFigure"));

			 transactions.add(transact);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactions;
	}
	
	
	public void performTransaction(String uniqueId, String app, String charge,String developer,
			String platformfee,String developerfee,String transactionFee ) {
		String sql ="INSERT INTO bills(user_id,app_name,developer_id,ChargeFigure,platformfee,developerfee,transaction_fee)VALUES(?,?,?,?,?,?,?)";
	
		try {
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, uniqueId);
			ps.setString(2, app);
			ps.setString(3, developer);
			ps.setString(4, charge);
			ps.setString(5, platformfee);
			ps.setString(6, developerfee);
			ps.setString(7, transactionFee);

			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	public List<Transaction> getDeveloperTransaction(String dev_uniqueId){
		List<Transaction> transactions = new ArrayList<>();
		String sql = "SELECT app_name,developerfee FROM bills where developer_id=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dev_uniqueId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction transact = new Transaction();
				  transact.setAppname(rs.getString("app_name"));
				  transact.setCharge(rs.getString("developerfee"));
				  transactions.add(transact);
				  
		}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
	}
	

		
		
		
		public boolean isAccountDebitable(String userid) {
			String sql = "SELECT  amount from customer_details where unique_id=? ";
			PreparedStatement ps;
		    double amount = 0.0;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, userid);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Customer customer= new Customer();
				customer.setAmount(rs.getString("amount"));
				 amount = Double.parseDouble(customer.getAmount());
				  System.out.println();
				}
				if(amount>=5) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		
		public String debitAccount(String userId,String app,String developer) {
			if(isAccountDebitable(userId)== true) {
			//charge substract -5 peanuts from the customer
			int account = Integer.parseInt(getAccountBalance(userId));	
			account-=5;
		     charge(userId,String.valueOf(account));
		     //perform transaction
		     performTransaction(userId, app, "5", developer, "1", "3", "1");
		     //get Account update
		     
		     return getAccountBalance(userId);
			}
			
				return new String("no money") ;
		}
		
		public void charge(String userId,String amount) {
			String sql="UPDATE customer_details SET amount = ?"+"WHERE unique_id =?";
			PreparedStatement ps;
			try {
				
				ps = con.prepareStatement(sql);
				ps.setString(1, amount);
				ps.setString(2, userId);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public String getAccountBalance(String userId) {
			String sql = "SELECT amount from customer_details where unique_id=?";
			String balance = null;
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
				c.setAmount(rs.getString("amount"));
				balance = c.getAmount();
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return balance;
		}
		
		public void creditDeveloper(String developerId) {
			String account = getAccountBalance(developerId);
			int bal = 3;
			bal += Integer.parseInt(account);
			upDateDeveloperAccount(developerId, String.valueOf(bal));
		}
		
		public void upDateDeveloperAccount(String developerId,String amount) {
			String sql="UPDATE customer_details SET amount = ?"+"WHERE unique_id =?";
			PreparedStatement ps;
			try {
				
				ps = con.prepareStatement(sql);
				ps.setString(1, amount);
				ps.setString(2, developerId);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public List<String> getPlatformBalance() {
			String sql ="SELECT platformfee FROM bills ";
			PreparedStatement ps;
			List<String> list = new ArrayList<>();
			try {
				ps = con.prepareStatement(sql);

				ResultSet rs =ps.executeQuery();
				while(rs.next()) {
			
					list.add(rs.getString("platformfee"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;
		}
		

		public List<String> getTransactionFeeBalance() {
			String sql ="SELECT transaction_fee FROM bills ";
			PreparedStatement ps;
			List<String> list = new ArrayList<>();
			try {
				ps = con.prepareStatement(sql);

				ResultSet rs =ps.executeQuery();
				while(rs.next()) {
			
					list.add(rs.getString("platformfee"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;
		}
		//get balance 
		//update transaction perform transaction
		// credit developer
	    //get balance
    
}
