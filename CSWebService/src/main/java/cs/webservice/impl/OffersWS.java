package cs.webservice.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import cs.dao.dao.OfferDAO;
import cs.model.OfferWithCustomerAccount;
import cs.dao.spring.SpringDAO;


public class OffersWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer idCustomerAccount;
	private String startingCity;
	private String finishingCity;

	private List<OfferWithCustomerAccount> offersWithCustomerAccount;

	
	/**
	 * Getter and setter
	 */
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}

	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
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
	
	public List<OfferWithCustomerAccount> getOffersWithCustomerAccount() {
		return offersWithCustomerAccount;
	}
 
	public void setOffersWithCustomerAccount(List<OfferWithCustomerAccount> offersWithCustomerAccount) {
		this.offersWithCustomerAccount = offersWithCustomerAccount;
	}

	public String execute() throws Exception
 	{
	 	OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
	 	offersWithCustomerAccount = offerDAO.loadSearchOffers(startingCity, finishingCity, idCustomerAccount);
	    
	 	return SUCCESS;
 	}
}
