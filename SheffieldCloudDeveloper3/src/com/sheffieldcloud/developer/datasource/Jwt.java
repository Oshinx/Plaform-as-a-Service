package com.sheffieldcloud.developer.datasource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Jwt {
    private String issuer;
    private Customer customer;
    private String signature;
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String signjwt() throws NoSuchAlgorithmException {
		String toSign = getIssuer() + getCustomer().toString();
		MessageDigest digest;
		digest = MessageDigest.getInstance("MD5");
		digest.update(toString().getBytes());
		StringBuilder sb = new StringBuilder();
		byte [] bytes = digest.digest();
		for(int i = 0; i<bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
	
	
}
