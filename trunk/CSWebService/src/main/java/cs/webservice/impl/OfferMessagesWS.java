package cs.webservice.impl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.MessageDAO;
import cs.model.Message;
import cs.model.MessageWithCustomerAccount;


public class OfferMessagesWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer idOffer;
	private Integer idCustomerAccount;
	private List<MessageWithCustomerAccount> messagesWithCustomerAccount;
	
	
	public Integer getIdOffer() {
		return idOffer;
	}
	
	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
	
	public List<MessageWithCustomerAccount> getMessagesWithCustomerAccount() {
		return messagesWithCustomerAccount;
	}

	public void setMessagesWithCustomerAccount(
			List<MessageWithCustomerAccount> messagesWithCustomerAccount) {
		this.messagesWithCustomerAccount = messagesWithCustomerAccount;
	}

	public String execute() throws Exception
 	{
		MessageDAO messageDAO = new MessageDAO();
		messagesWithCustomerAccount = messageDAO.getOfferMessageForACustomerTransmitter(idOffer, idCustomerAccount);
		
		return SUCCESS;
 	}
}
