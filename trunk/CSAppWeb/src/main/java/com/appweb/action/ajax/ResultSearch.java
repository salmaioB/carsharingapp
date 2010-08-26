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

public class ResultSearch extends Action
{
   private String addressStart;
   private String addressStop;
   private Date datepickerSearch;
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

	public ResultSearch()
    {
    	System.out.println("Construct ResultSearch");
    }

	public String getAddressStart() {
		if(addressStart==null) addressStart="";
		return addressStart;
	}

	public void setAddressStart(String addressStart) {
		this.addressStart = addressStart;
	}

	public String getAddressStop() {
		if(addressStop==null) addressStop="";
		return addressStop;
	}

	public void setAddressStop(String addressStop) {
		this.addressStop = addressStop;
	}

	public Date getDatepickerSearch() {
		return datepickerSearch;
	}

	public void setDatepickerSearch(Date datepickerSearch) {
		this.datepickerSearch = datepickerSearch;
	}

	public String execute() throws Exception
	{
		System.out.println("execute ResultSearch");
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		
		System.out.println("getAddressStart() : " + getAddressStart());
		System.out.println("getAddressStop() : " + getAddressStop());
		
		owca = offerDAO.loadSearchOffers(getAddressStart(), getAddressStop(), null);
		System.out.println("owca.size() : " + owca.size() );
		if(owca != null)
		{
			if(owca.size() > 0)
			{
				System.out.println("owca.get(0).getAcceptAnimals() : " + owca.get(0).getCustomerAccount().getAcceptAnimals());
				System.out.println("owca.get(0).getGender() : " + owca.get(0).getCustomerAccount().getGender());
				
				divPrintResultat = "resultSearch";
				return SUCCESS;
			}
		}
		return ERROR;
	}
}