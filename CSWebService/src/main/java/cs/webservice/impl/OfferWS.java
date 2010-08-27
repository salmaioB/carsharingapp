package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.OfferDAO;
import cs.model.Offer;

public class OfferWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	private Integer idOffer;
	private Offer offer;

	
	public Integer getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public String execute() throws Exception
 	{
		OfferDAO offerDAO = new OfferDAO();
		offer = offerDAO.getOffer(idOffer);
		
		return SUCCESS;
 	}
}
