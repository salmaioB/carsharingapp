package com.appweb.action.ajax;

import java.util.Date;

import com.appweb.Action;
import com.appweb.action.AccueilAction;

import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.spring.SpringEngine;
import cs.model.CustomerAccount;

public class ProfilAction extends AccueilAction
{
	private Integer idCustomerAccount;
	private Integer idOffer;
	
    public Integer getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}


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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
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
	public Integer getAcceptAnimals() {
		return acceptAnimals;
	}
	public void setAcceptAnimals(Integer acceptAnimals) {
		this.acceptAnimals = acceptAnimals;
	}
	public Integer getAcceptRadio() {
		return acceptRadio;
	}
	public void setAcceptRadio(Integer acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	public Integer getAcceptSmoker() {
		return acceptSmoker;
	}
	public void setAcceptSmoker(Integer acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	public Integer getAcceptToDiscuss() {
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


	public ProfilAction()
    {
    	System.out.println("Construct Check in");
    }


	public String execute()
	{
		System.out.println("Check adresse");
		if(idCustomerAccount != null )
		{
			if( !idCustomerAccount.equals( getCustomerAccount().getId() ) )
			{
				setIsCurrentCustomer(false);
				CustomerAccountEngineAction caea = SpringEngine.getSpring().getCustomerAccountEngineAction();
				setCustomerAccountProfil( caea.load(idCustomerAccount) );
			}
			else
				setCustomerAccountProfil(getCustomerAccount());
		}
		else
		{
			setCustomerAccountProfil(getCustomerAccount());
		}
		
		return SUCCESS;
	}
}