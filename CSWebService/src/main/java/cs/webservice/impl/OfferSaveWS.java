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
	
	private Integer idCustomerAccount;
	private Integer isDriver;
	
	private Integer numberOfPassengers;
	private float pricePerPassenger;
	
	private String startingCity;
	private String finishingCity;
	
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}

	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}

	public Integer getIsDriver() {
		return isDriver;
	}

	public void setIsDriver(Integer isDriver) {
		this.isDriver = isDriver;
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
		offerDAO.saveOfferWithRoutes(offer, routes, idCustomerAccount, isDriver);
		
	 	return SUCCESS;
 	}
}
