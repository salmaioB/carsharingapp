package cs.engine.action;

import java.util.ArrayList;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.model.MessageWithCustomerAccount;

public class MessageWithCustomerAccountAction 
{
	private MessageWithCustomerAccount messageWithCustomerAccount;
	
	public MessageWithCustomerAccount load(Integer idMessage)
	{
		MessageDAO messageDAO = new MessageDAO();
		CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();
		
		messageWithCustomerAccount.setMessage( messageDAO.load(idMessage) );
		messageWithCustomerAccount.setCustomerAccount( customerAccountDAO.load(messageWithCustomerAccount.getMessage().getIdCustomerTransmitter()) );

		return messageWithCustomerAccount;
	}
	
	public MessageWithCustomerAccountAction()
	{
		messageWithCustomerAccount = new MessageWithCustomerAccount();
	}
}
