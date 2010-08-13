package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.OfferDAO;
import cs.model.Offer;


public class OfferSaveWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer idOfferType;
	private Integer idDriver;
	private Integer numberOfPassengers;
	private Float pricePerPassenger;
	
		
	public Integer getIdOfferType() {
		return idOfferType;
	}

	public void setIdOfferType(Integer idOfferType) {
		this.idOfferType = idOfferType;
	}
	
	public Integer getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(Integer idDriver) {
		this.idDriver = idDriver;
	}
	
	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}
	
	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public Float getPricePerPassenger() {
		return pricePerPassenger;
	}

	public void setPricePerPassenger(Float pricePerPassenger) {
		this.pricePerPassenger = pricePerPassenger;
	}

	public String execute() throws Exception
 	{
		Offer offer = new Offer();
		
		System.out.println(idOfferType.toString());
		
		offer.setIdOfferType(idOfferType);
	    offer.setIdDriver(idDriver);
		offer.setTitle("");
		offer.setDescription("");
		offer.setNumberOfPlaceInitial(numberOfPassengers);
		offer.setNumberOfPlaceRemaining(numberOfPassengers);
		offer.setPricePerPassenger(pricePerPassenger);
		
		OfferDAO offerDAO = new OfferDAO();
		offerDAO.saveOfferWithRoutes(offer, null);
		
	 	return SUCCESS;
 	}
}
