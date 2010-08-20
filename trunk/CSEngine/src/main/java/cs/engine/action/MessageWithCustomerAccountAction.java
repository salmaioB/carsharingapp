package cs.engine.action;

import java.util.ArrayList;
import java.util.List;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.model.CustomerAccount;
import cs.model.Message;
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
	public List<MessageWithCustomerAccount> loadMessageWithCustomerAccount(Integer idCustomer)
	{
		MessageDAO messageDAO = new MessageDAO();
		CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();
		
		List<Message> messages = messageDAO.loadSearchMessagesNotRead(idCustomer);
		List<MessageWithCustomerAccount> messageWithCustomerAccounts = new ArrayList<MessageWithCustomerAccount>();
		for(Message message:messages)
		{
			//customer emmetteur
			CustomerAccount customerAccount = customerAccountDAO.load( message.getIdCustomerTransmitter() );
			MessageWithCustomerAccount mwca = new MessageWithCustomerAccount();
			mwca.setCustomerAccount(customerAccount);
			mwca.setMessage(message);
			
			messageWithCustomerAccounts.add(mwca);
		}
		
		return messageWithCustomerAccounts;
	}
	public MessageWithCustomerAccountAction()
	{
		messageWithCustomerAccount = new MessageWithCustomerAccount();
	}
}
