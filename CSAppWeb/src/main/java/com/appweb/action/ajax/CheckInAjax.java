package com.appweb.action.ajax;

import java.util.Date;

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
	// pourquoi coutry? 
	//country c'est le pays, à la limite city ou town non?
	private String country;
	private String zipCode;
	private String phone;
	private String mobile;
	private Boolean acceptAnimals;
	private Boolean acceptRadio;
	private Boolean acceptSmoker;
	private Boolean acceptToDiscuss;
	private Boolean acceptToMakeADetour;
	
	public String getAddress() {
		if(address == null) address = "";
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		if(country==null) country = "";
		return country;
	}
	public void setVille(String country) {
		this.country = country;
	}
	public String getZipCode() {
		if(zipCode==null) zipCode="";
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMobile() {
		if(mobile == null) mobile ="";
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    public String getCustomerLogin() {
    	if(customerLogin==null) customerLogin="";
		return customerLogin;
	}
	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}
	public String getCustomerPassword() {
		if(customerPassword==null)customerPassword="";
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getLastName() {
		if(lastName==null) lastName="";
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		if(firstName==null) firstName="";
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
		if(phone==null) phone="";
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getAcceptAnimals() {
		if(acceptAnimals==null) acceptAnimals =false;
		return acceptAnimals;
	}
	public void setAcceptAnimals(Boolean acceptAnimals) {
		this.acceptAnimals = acceptAnimals;
	}
	public Boolean getAcceptRadio() {
		if(acceptRadio==null) acceptRadio= false;
		return acceptRadio;
	}
	public void setAcceptRadio(Boolean acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	public Boolean getAcceptSmoker() {
		if(acceptSmoker==null) acceptSmoker=false;
		return acceptSmoker;
	}
	public void setAcceptSmoker(Boolean acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	public Boolean getAcceptToDiscuss() {
		if(acceptToDiscuss==null) acceptToDiscuss=false;
		return acceptToDiscuss;
	}
	public void setAcceptToDiscuss(Boolean acceptToDiscuss) {
		this.acceptToDiscuss = acceptToDiscuss;
	}
	public Boolean getAcceptToMakeADetour() {
		if(acceptToMakeADetour==null) acceptToMakeADetour =false;
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
		System.out.println("execute Check in");
		
		if(isLoging())
		{
			System.out.println("user logger");
			System.out.println("lastName : " + lastName);
			System.out.println("customerLogin : " + customerLogin);
			System.out.println(acceptAnimals);
			System.out.println(acceptRadio);
			System.out.println(acceptSmoker);
			System.out.println(acceptToDiscuss);
			System.out.println(acceptToMakeADetour);
			System.out.println(customerLogin);
			System.out.println(customerPassword);
			System.out.println(phone);
			System.out.println(lastName);
			System.out.println(firstName);
			System.out.println(emailAddress);
			System.out.println(mobile);
			System.out.println(address);
			System.out.println(country);
			System.out.println(zipCode);
			
			CustomerAccountEngineAction caea = new CustomerAccountEngineAction();
			getCustomerAccount().setAcceptAnimals(getAcceptAnimals());
			getCustomerAccount().setAcceptRadio(getAcceptRadio());
			getCustomerAccount().setAcceptSomker(getAcceptSmoker());
			getCustomerAccount().setAcceptToDiscuss(getAcceptToDiscuss());
			getCustomerAccount().setAcceptToMakeADetour(getAcceptToMakeADetour());
			getCustomerAccount().setCustomerLogin(getCustomerLogin());
			getCustomerAccount().setCustomerPassword(getCustomerPassword());
			getCustomerAccount().setPhone(getPhone());
			getCustomerAccount().setLastName(getLastName());
			getCustomerAccount().setFirstName(getFirstName());
			getCustomerAccount().setEmailAddress(getEmailAddress());
			getCustomerAccount().setMobile(getMobile());
			getCustomerAccount().setAddress(getAddress());
			getCustomerAccount().setCountry(getCountry());
			getCustomerAccount().setZipCode(getZipCode());
			
			System.out.println("Ville : " + getCustomerAccount().getCountry());
			
			if(caea.save(getCustomerAccount()))
				System.out.println("Enregistre");
			else
				System.out.println("Error");
		}
		else
		{
			System.out.println("user not logger : " + customerLogin);

			getCustomerAccount().setCustomerLogin(getCustomerLogin());
			getCustomerAccount().setCustomerPassword(getCustomerPassword());
			getCustomerAccount().setEmailAddress(getEmailAddress());
			getCustomerAccount().setAcceptAnimals(false);
			getCustomerAccount().setAcceptRadio(false);
			getCustomerAccount().setAcceptSomker(false);
			getCustomerAccount().setAcceptToDiscuss(false);
			getCustomerAccount().setAcceptToMakeADetour(false);
			getCustomerAccount().setGeolocLatitude(0.0);
			getCustomerAccount().setGeolocLongitude(0.0);
			getCustomerAccount().setIdVehicule(0);
			getCustomerAccount().setCustomerType(0);
			getCustomerAccount().setDatetimeLastConnection(new Date());
			getCustomerAccount().setDatetimeRegistration(new Date() );
			getCustomerAccount().setDatetimeLastOfferCreated(null);
			getCustomerAccount().setDatetimeLastCarSharing(null);
			getCustomerAccount().setAddress("");
			getCustomerAccount().setCountry("");
			getCustomerAccount().setZipCode("");
			getCustomerAccount().setPhone("");
			getCustomerAccount().setMobile("");
			getCustomerAccount().setLastName("");
			getCustomerAccount().setFirstName("");
			
			CustomerAccount ca = getCustomerAccount();

			System.out.println(ca.getCustomerLogin());
			System.out.println(ca.getCustomerPassword() );
			System.out.println(ca.getEmailAddress());
			
			CustomerAccountEngineAction caea = new CustomerAccountEngineAction();
			Boolean b = caea.save( ca ) ;
			if( b )
				getSession().put("customerId",getCustomerAccount().getId());					
			else
				System.out.println("ERROR : Subscription new customer" + b);
		}
		return SUCCESS;
	}
}