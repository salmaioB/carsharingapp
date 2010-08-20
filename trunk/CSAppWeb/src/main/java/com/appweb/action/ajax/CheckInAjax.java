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
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setVille(String country) {
		this.country = country;
	}
	public String getzipCode() {
		return zipCode;
	}
	public void setCp(String zipCode) {
		this.zipCode = zipCode;
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
		System.out.println("execute Check in");
		
		if(isLoging())
		{
			System.out.println("user logger");
			System.out.println("customerLogin : " + customerLogin);
			
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
			getCustomerAccount().setCountry(country);
			getCustomerAccount().setZipCode(zipCode);
			
			System.out.println("Ville : " + getCustomerAccount().getCountry());
			
			caea.save(getCustomerAccount());
		}
		else
		{
			System.out.println("user not logger");

			getCustomerAccount().setCustomerLogin(customerLogin);
			getCustomerAccount().setCustomerPassword(customerPassword);
			getCustomerAccount().setEmailAddress(emailAddress);
			getCustomerAccount().setAcceptAnimals(false);
			getCustomerAccount().setAcceptRadio(false);
			getCustomerAccount().setAcceptSomker(false);
			getCustomerAccount().setAcceptToDiscuss(false);
			getCustomerAccount().setAcceptToMakeADetour(false);
			getCustomerAccount().setGeolocLatitude(0.0);
			getCustomerAccount().setGeolocLongitude(0.0);
			getCustomerAccount().setIdVehicule(0);
			getCustomerAccount().setCustomerType(0);
			getCustomerAccount().setDatetimeLastConnection(null);//new Date());
			getCustomerAccount().setDatetimeRegistration(null);// new Date() );
			getCustomerAccount().setDatetimeLastOfferCreated(null);
			getCustomerAccount().setDatetimeLastCarSharing(null);
			getCustomerAccount().setAddress("");
			getCustomerAccount().setCountry(country);
			getCustomerAccount().setZipCode(zipCode);
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