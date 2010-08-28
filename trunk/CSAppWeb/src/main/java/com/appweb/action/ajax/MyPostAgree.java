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

public class MyPostAgree extends Action
{
   List<OfferWithCustomerAccount> owca;
   private String divPrintResultat;


public String getDivPrintResultat() {
		return divPrintResultat;
	}

	public void setDivPrintResultat(String divPrintResultat) {
		this.divPrintResultat = divPrintResultat;
	}
	
	public List<OfferWithCustomerAccount> getOwca() {
		return owca;
	}

public void setOwca(List<OfferWithCustomerAccount> owca) {
	this.owca = owca;
}

	public MyPostAgree()
    {
    	System.out.println("Construct MyPostAgree");
    }
	public String execute() throws Exception
	{
		System.out.println("execute MyPostAgree");
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		
		owca = offerDAO.loadSearchOffersToParticipate( getCustomerAccount().getId() );
		if(owca != null)
		{
			if(owca.size() >0 )
			{
				System.out.println("owca.get(0).getAcceptAnimals() : " + owca.get(0).getCustomerAccount().getAcceptAnimals());
				System.out.println("owca.get(0).getGender() : " + owca.get(0).getCustomerAccount().getGender());
				
				divPrintResultat = "myAgreeOffer";
				
				System.out.println("Fin de MyPostAgree");
				return SUCCESS;
			}
			System.out.println("owca.size() == 0");
		}
		System.out.println("Fin de MyPostAgree");
		return ERROR;
	}
}