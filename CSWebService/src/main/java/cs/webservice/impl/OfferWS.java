package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.OfferDAO;
import cs.model.Offer;
import cs.model.OfferWithCustomerAccount;

public class OfferWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	private Integer idOffer;
	private OfferWithCustomerAccount offerWithCustomerAccount;

	
	public Integer getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	
	public OfferWithCustomerAccount getOfferWithCustomerAccount() {
		return offerWithCustomerAccount;
	}

	public void setOfferWithCustomerAccount(OfferWithCustomerAccount offerWithCustomerAccount) {
		this.offerWithCustomerAccount = offerWithCustomerAccount;
	}
	
	public String execute() throws Exception
 	{
		OfferDAO offerDAO = new OfferDAO();
		offerWithCustomerAccount = offerDAO.getOffer(idOffer);
		
		return SUCCESS;
 	}
}
