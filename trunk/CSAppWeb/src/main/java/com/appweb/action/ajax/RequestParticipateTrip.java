package com.appweb.action.ajax;

import com.appweb.Action;

import cs.dao.dao.OfferDAO;
import cs.dao.dao.OffersToCustomerAccountsDAO;
import cs.dao.spring.SpringDAO;
import cs.model.Offer;
import cs.model.OffersToCustomerAccount;

public class RequestParticipateTrip extends Action
{
	private Integer idTrip;

	public Integer getIdTrip() {
		return idTrip;
	}
	public void setIdTrip(Integer idTrip) {
		this.idTrip = idTrip;
	}

	public String execute() throws Exception
	{
		System.out.println("execute RequestParticipateTrip");
		
		OffersToCustomerAccountsDAO offersToCustomerAccountsDAO = SpringDAO.getSpring().getOffersToCustomerAccountsDAO();
		OffersToCustomerAccount offerToCustomerAccount = new  OffersToCustomerAccount();
	
		offerToCustomerAccount.setIdCustomerAccount( getCustomerAccount().getId() );
		offerToCustomerAccount.setIsDriver(0);
		offerToCustomerAccount.setIsOfferCreator(0);
		offerToCustomerAccount.setIdOffer(idTrip);
		
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		Offer offer = offerDAO.load(idTrip);
		
		Integer remain = offer.getNumberOfPlaceRemaining();
		remain--;
		if(remain >= 0)
		{
			if(!offersToCustomerAccountsDAO.isParticipate(idTrip, getCustomerAccount().getId() ) )
			{
				System.out.println("passe par successs");
				offer.setNumberOfPlaceRemaining(remain);
				offerDAO.save(offer);
				offersToCustomerAccountsDAO.save(offerToCustomerAccount);
				return SUCCESS;
			}
		}
		System.out.println("Passe par error");
		return ERROR;
	}
}