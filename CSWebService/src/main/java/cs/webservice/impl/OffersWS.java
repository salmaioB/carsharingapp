package cs.webservice.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import cs.dao.dao.OfferDAO;
import cs.model.Offer;


public class OffersWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private List<Offer> offers;
 
	/**
	 * Getter and setter
	 */
	public List<Offer> getOffers(){
		return offers;
	}
 
	public void setOffers(List<Offer> offers){
		this.offers = offers;
	}

	public String execute() throws Exception
 	{
	 	OfferDAO offerDAO = new OfferDAO();
	 	offers = offerDAO.loadSearchOffers("toto", "orleans", "tata", "paris");
	 
	 	return SUCCESS;
 	}
}
