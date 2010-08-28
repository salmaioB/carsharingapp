package cs.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.OfferDAO;
import cs.dao.spring.SpringDAO;
import cs.model.Offer;
import cs.model.Route;


public class OfferSaveWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer idOfferType;
	private Integer idDriver;
	private Integer numberOfPassengers;
	private float pricePerPassenger;
	
	private String startingCity;
	private String finishingCity;
	
		
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

	public float getPricePerPassenger() {
		return pricePerPassenger;
	}

	public void setPricePerPassenger(float pricePerPassenger) {
		this.pricePerPassenger = pricePerPassenger;
	}

	public String getStartingCity() {
		return startingCity;
	}

	public void setStartingCity(String startingCity) {
		this.startingCity = startingCity;
	}

	public String getFinishingCity() {
		return finishingCity;
	}

	public void setFinishingCity(String finishingCity) {
		this.finishingCity = finishingCity;
	}
	
	public String execute() throws Exception
 	{
		Offer offer = new Offer();
		offer.setDescription("");
		offer.setStartingCity(startingCity);
		offer.setFinishingCity(finishingCity);
		offer.setNumberOfPlaceInitial(numberOfPassengers);
		offer.setNumberOfPlaceRemaining(numberOfPassengers);
		offer.setPricePerPassenger(pricePerPassenger);
		
		Route route = new Route();
		route.setStartingAddress("");
		route.setStartingCity(startingCity);
		route.setFinishingAddress("");
		route.setFinishingCity(finishingCity);
		route.setRouteOrder(1);
		route.setPrice(0f);
		route.setConversionRateToEuro(0f);
		route.setCurrencyCode("");
		
		List<Route> routes = new ArrayList<Route>();
		routes.add(route);
		
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		offerDAO.saveOfferWithRoutes(offer, routes);
		
	 	return SUCCESS;
 	}
}
