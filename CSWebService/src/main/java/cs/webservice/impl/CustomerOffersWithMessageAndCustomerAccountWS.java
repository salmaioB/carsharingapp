package cs.webservice.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.OfferDAO;
import cs.model.CustomerOfferWithMessageAndCustomerAccount;


public class CustomerOffersWithMessageAndCustomerAccountWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	private Integer idCustomerAccount;
	private List<CustomerOfferWithMessageAndCustomerAccount> customerOffersWithMessageAndCustomerAccount;
	
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}

	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}

	public List<CustomerOfferWithMessageAndCustomerAccount> getCustomerOffersWithMessageAndCustomerAccount() {
		return customerOffersWithMessageAndCustomerAccount;
	}

	public void setCustomerOffersWithMessageAndCustomerAccount(List<CustomerOfferWithMessageAndCustomerAccount> customerOffersWithMessageAndCustomerAccount) {
		this.customerOffersWithMessageAndCustomerAccount = customerOffersWithMessageAndCustomerAccount;
	}
	
	public String execute() throws Exception
 	{		
	 	OfferDAO offerDAO = new OfferDAO();
	 	customerOffersWithMessageAndCustomerAccount = offerDAO.loadOfferWithCustomerMessageReceive(idCustomerAccount);
	 	
	 	return SUCCESS;
 	}
}
