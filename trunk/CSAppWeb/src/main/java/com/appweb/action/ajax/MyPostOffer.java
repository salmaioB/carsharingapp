package com.appweb.action.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appweb.Action;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.dao.dao.OfferDAO;
import cs.dao.spring.SpringDAO;
import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.action.MessageWithCustomerAccountAction;
import cs.engine.spring.SpringEngine;
import cs.model.CustomerAccount;
import cs.model.Message;
import cs.model.MessageWithCustomerAccount;
import cs.model.OfferWithCustomerAccount;

public class MyPostOffer extends Action
{
   List<OfferWithCustomerAccount> owca;
   
	public List<OfferWithCustomerAccount> getOwca() {
		return owca;
	}

public void setOwca(List<OfferWithCustomerAccount> owca) {
	this.owca = owca;
}

	public MyPostOffer()
    {
    	System.out.println("Construct MyPostOffer");
    }
	public String execute() throws Exception
	{
		System.out.println("execute MyPostOffer");
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		
		owca = offerDAO.loadSearchOffers(null, null, getCustomerAccount().getId() );
		System.out.println("owca.get(0).getAcceptAnimals() : " + owca.get(0).getCustomerAccount().getAcceptAnimals());
		System.out.println("owca.get(0).getGender() : " + owca.get(0).getCustomerAccount().getGender());
		return SUCCESS;
	}
}