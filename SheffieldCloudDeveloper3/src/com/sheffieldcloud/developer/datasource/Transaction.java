package com.sheffieldcloud.developer.datasource;

public class Transaction {
private String billingId;
private String appname;
private String charge;
private String developerId;

public String getBillingId() {
	return billingId;
}
public void setBillingId(String billingId) {
	this.billingId = billingId;
}
public String getAppname() {
	return appname;
}
public void setAppname(String appname) {
	this.appname = appname;
}
public String getCharge() {
	return charge;
}
public void setCharge(String charge) {
	this.charge = charge;
}
public String getDeveloperId() {
	return developerId;
}
public void setDeveloperId(String developerId) {
	this.developerId = developerId;
}
}
