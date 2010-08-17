package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class CheckInAjax extends Action
{
	private String customerLogin;
	private String  customerPassword;
	private String lastName;
	private String firstName;
	private String emailAddress;
	private String address;
	private String ville;
	private String cp;
	private String phone;
	private String mobile;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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


	public CheckInAjax()
    {
    	System.out.println("Construct Check in");
    }


	public String execute() throws Exception
	{
		System.out.println("Check in");
		
		CustomerAccountEngineAction caea = new CustomerAccountEngineAction();
		getCustomerAccount().setAcceptAnimals(acceptAnimals);
		getCustomerAccount().setAcceptRadio(acceptRadio);
		getCustomerAccount().setAcceptSomker(acceptSmoker);
		getCustomerAccount().setAcceptToDiscuss(acceptToDiscuss);
		getCustomerAccount().setAcceptToMakeADetour(acceptToMakeADetour);
		getCustomerAccount().setCustomerLogin(customerLogin);
		getCustomerAccount().setCustomerPassword(customerPassword);
		getCustomerAccount().setPhone(phone);
		getCustomerAccount().setLastName(lastName);
		getCustomerAccount().setFirstName(firstName);
		getCustomerAccount().setEmailAddress(emailAddress);
		getCustomerAccount().setMobile(mobile);
		getCustomerAccount().setAddress(address);
		getCustomerAccount().setVille(ville);
		getCustomerAccount().setCp(cp);
		
		caea.save(getCustomerAccount());
		return SUCCESS;
	}
}