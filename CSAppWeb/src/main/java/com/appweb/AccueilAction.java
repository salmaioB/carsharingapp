package com.appweb;

import com.opensymphony.xwork2.ActionSupport;

import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.action.OfferEngineAction;
import cs.model.CustomerAccount;
import cs.model.Offer;

public class AccueilAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "";
	private String message;
	private String type;
	
	public String getType() {
		if(type==null)
			type="";
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage()
	{
		if(message==null)
			message="";
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}

	public String execute()
	{
		if(getType().equals("CustomerAccounts"))
		{
			CustomerAccountEngineAction u = new CustomerAccountEngineAction();
		
			CustomerAccount use = u.load(new Integer(1));
			if(use!= null)
			{
				String chaine = use.getCustomerLogin() +"-" + use.getCustomerPassword() + use.getDatetimeRegistration() +"|"+ use.getDatetimeLastCarSharing() +"|"+ use.getDatetimeLastConnection() +"|"+ use.getDatetimeLastOfferCreated() ;
				setMessage(chaine);
			}
			else
			{
				setMessage("use not found");
			}
		}
		if(getType().equals("Offer"))
		{
			OfferEngineAction u = new OfferEngineAction();
		
			Offer  offer = u.load(new Integer(1));
			if(offer!= null)
			{
				setMessage(offer.getDescription() );
			}
			else
			{
				setMessage("offer not found");
			}
		}
		return SUCCESS;
	}
}
