package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class CheckAddress extends Action
{
    private CustomerAccount ca;
	private String customerLogin;
	private String  customerPassword;
	private String lastName;
	private String firstName;
	private String emailAddress;
	private String address;
	private String country;
	private Integer zipCode;
	private Integer phone;
	private Integer mobile;
	private Boolean acceptAnimals;
	private Boolean acceptRadio;
	private Boolean acceptSmoker;
	private Boolean acceptToDiscuss;
	private Boolean acceptToMakeADetour;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
    public String getCustomerLogin() {
		return customerLogin;
	}
	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Boolean getAcceptAnimals() {
		return acceptAnimals;
	}
	public void setAcceptAnimals(Boolean acceptAnimals) {
		this.acceptAnimals = acceptAnimals;
	}
	public Boolean getAcceptRadio() {
		return acceptRadio;
	}
	public void setAcceptRadio(Boolean acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	public Boolean getAcceptSmoker() {
		return acceptSmoker;
	}
	public void setAcceptSmoker(Boolean acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	public Boolean getAcceptToDiscuss() {
		return acceptToDiscuss;
	}
	public void setAcceptToDiscuss(Boolean acceptToDiscuss) {
		this.acceptToDiscuss = acceptToDiscuss;
	}
	public Boolean getAcceptToMakeADetour() {
		return acceptToMakeADetour;
	}
	public void setAcceptToMakeADetour(Boolean acceptToMakeADetour) {
		this.acceptToMakeADetour = acceptToMakeADetour;
	}
	public CustomerAccount getCa() {
		return ca;
	}
	public void setCa(CustomerAccount ca) {
		this.ca = ca;
	}


	public CheckAddress()
    {
    	System.out.println("Construct Check in");
    	ca = new CustomerAccount();
    }


	public String execute() throws Exception
	{
		System.out.println("Check adresse");
		/*
		CustomerAccountEngineAction caea = new CustomerAccountEngineAction();
		ca.setAcceptAnimals(acceptAnimals);
		ca.setAcceptRadio(acceptRadio);
		ca.setAcceptSomker(acceptSmoker);
		ca.setAcceptToDiscuss(acceptToDiscuss);
		ca.setAcceptToMakeADetour(acceptToMakeADetour);
		ca.setCustomerLogin(customerLogin);
		ca.setCustomerPassword(customerPassword);
		ca.setPhone(phone);
		ca.setLastName(lastName);
		ca.setFirstName(firstName);
		ca.setEmailAddress(emailAddress);
		ca.setMobile(mobile);
		ca.setAddress(address);
		ca.setVille(ville);
		ca.setCp(cp);
		
		if (caea.save(ca) )
			return SUCCESS;
		else
			return ERROR;
		*/
		return SUCCESS;
	}
}