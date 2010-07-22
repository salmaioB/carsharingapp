package com.appweb;

import com.opensymphony.xwork2.ActionSupport;

import cs.engine.action.CustomerAccountsEngineAction;
import cs.model.CustomerAccounts;

public class AccueilAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "";
	private String message;

	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}

	public String execute()
	{
		CustomerAccountsEngineAction u = new CustomerAccountsEngineAction();
	
		CustomerAccounts  use = u.load(new Integer(1));
		if(use!= null)
		{
			String chaine = use.getCustomerLogin() +"-" + use.getCustomerPassword() + use.getDatetimeRegistration() +"|"+ use.getDatetimeLastCarSharing() +"|"+ use.getDatetimeLastConnection() +"|"+ use.getDatetimeLastOfferCreated() ;
			setMessage(chaine);
		}
		else
		{
			setMessage("use non trouvé");
		}
		return SUCCESS;
	}
}
