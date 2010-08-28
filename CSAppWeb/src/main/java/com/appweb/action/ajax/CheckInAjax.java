package com.appweb.action.ajax;

import java.util.Date;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.spring.SpringEngine;
import cs.model.CustomerAccount;

public class CheckInAjax extends Action
{
	private String customerLogin;
	private String  customerPassword;
	private String lastName;
	private String firstName;
	private String emailAddress;
	private String address;
	private String country;
	private String zipCode;
	private String phone;
	private String mobile;
	private Integer acceptAnimals;
	private Integer acceptRadio;
	private Integer acceptSmoker;
	private Integer acceptToDiscuss;
	private Integer acceptToMakeADetour;
	private Integer gender;
	
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public void setCountry(String country) {
		this.country = country;
	}
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
	public Integer getAcceptAnimals() {
		if(acceptAnimals==null) acceptAnimals =0;
		return acceptAnimals;
	}
	public void setAcceptAnimals(Integer acceptAnimals) {
		this.acceptAnimals = acceptAnimals;
	}
	public Integer getAcceptRadio() {
		if(acceptRadio==null) acceptRadio= 0;
		return acceptRadio;
	}
	public void setAcceptRadio(Integer acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	public Integer getAcceptSmoker() {
		if(acceptSmoker==null) acceptSmoker=0;
		return acceptSmoker;
	}
	public void setAcceptSmoker(Integer acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	public Integer getAcceptToDiscuss() {
		if(acceptToDiscuss==null) acceptToDiscuss=0;
		return acceptToDiscuss;
	}
	public void setAcceptToDiscuss(Integer acceptToDiscuss) {
		this.acceptToDiscuss = acceptToDiscuss;
	}
	public Integer getAcceptToMakeADetour() {
		return acceptToMakeADetour;
	}

	public void setAcceptToMakeADetour(Integer acceptToMakeADetour) {
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
			
			CustomerAccountEngineAction caea = SpringEngine.getSpring().getCustomerAccountEngineAction();
			getCustomerAccount().setAcceptAnimals(getAcceptAnimals());
			getCustomerAccount().setAcceptRadio(getAcceptRadio());
			getCustomerAccount().setAcceptSmoker(getAcceptSmoker());
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
			getCustomerAccount().setGender(getGender());
			
			System.out.println("Ville : " + getCustomerAccount().getCountry());
			
			if(caea.save(getCustomerAccount()))
				System.out.println("Enregistre");
			else
				System.out.println("Error");
		}
		else
		{
			System.out.println("user not logger : " + customerLogin);

			
			getCustomerAccount().setAcceptAnimals(getAcceptAnimals());
			getCustomerAccount().setAcceptRadio(getAcceptRadio());
			getCustomerAccount().setAcceptSmoker(getAcceptSmoker());
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
			getCustomerAccount().setGender(getGender());
			getCustomerAccount().setGeolocLatitude(0.0);
			getCustomerAccount().setGeolocLongitude(0.0);
			getCustomerAccount().setCustomerType(0);
			getCustomerAccount().setIdVehicule(0);
			
			CustomerAccount ca = getCustomerAccount();

			System.out.println(ca.getCustomerLogin());
			System.out.println(ca.getCustomerPassword() );
			System.out.println(ca.getEmailAddress());
			
			CustomerAccountEngineAction caea = SpringEngine.getSpring().getCustomerAccountEngineAction();
			//Si le login et password pas utilisé
			if( caea.identification(ca.getCustomerLogin(), ca.getCustomerPassword()) ==null )
			{
				Boolean b = caea.save( ca ) ;
				if( b )
				{
					getSession().put("customerId",getCustomerAccount().getId());					
					super.initConstructor();
				}
			}

			System.out.println("ERROR : Subscription new customer" );
		}
		return SUCCESS;
	}
}