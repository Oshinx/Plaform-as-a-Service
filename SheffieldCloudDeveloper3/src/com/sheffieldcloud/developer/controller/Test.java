package com.sheffieldcloud.developer.controller;

import java.util.Iterator;
import java.util.List;

import com.sheffieldcloud.developer.datasource.BillingDao;
import com.sheffieldcloud.developer.datasource.DeveloperDao;



public class Test {

public static void main(String[] args) {
	BillingDao billingDao = new BillingDao();
	billingDao.getConnection();
	//billingDao.performTransaction("5", "app2", "5", "cole","3","1","1");
     //List<String> list = billingDao.getPlatformBalance();
    //  System.out.println(list.size());
   // List<Transaction> transaction=billingDao.getCustomerTransaction("");
	/*List<Transaction> transaction = billingDao.getDeveloperTransaction("cole");
    
    for(Transaction transact:transaction) {
    	System.out.println(transact.getAppname());
    	System.out.println(transact.getCharge());
    }*/
     DeveloperDao dao = new DeveloperDao();
     dao.getConnection();
     dao.registerApp("James", "colejam");
}
}
