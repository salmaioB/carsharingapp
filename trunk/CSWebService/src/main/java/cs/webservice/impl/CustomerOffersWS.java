package cs.webservice.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.OfferDAO;
import cs.engine.action.OfferEngineAction;
import cs.engine.spring.SpringEngine;
import cs.model.Offer;

public class CustomerOffersWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	private Integer idCustomerAccount;
	private List<Offer> offers;
	
	/**
	 * Getter and setter
	 */
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}

	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}

	public List<Offer> getOffers() {
		return offers;
	}
 
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	public String execute() throws Exception
 	{		
	 	OfferEngineAction offerEngineAction = SpringEngine.getSpring().getOfferEngineAction();//new OfferEngineAction();
	 	
	 	offerEngineAction.getCustomerOffers(1);
	 	
	 	return SUCCESS;
 	}
}
