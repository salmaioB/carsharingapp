package cs.engine.action;

import java.util.ArrayList;
import java.util.List;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.dao.spring.Spring;
import cs.model.CustomerAccount;
import cs.model.Message;
import cs.model.MessageWithCustomerAccount;

public class MessageWithCustomerAccountAction 
{
	private MessageWithCustomerAccount messageWithCustomerAccount;
	private MessageDAO messageDAO;
	private CustomerAccountDAO customerAccountDAO;
	
	public MessageWithCustomerAccount load(Integer idMessage)
	{	
		messageWithCustomerAccount.setMessage( messageDAO.load(idMessage) );
		messageWithCustomerAccount.setCustomerAccount( customerAccountDAO.load(messageWithCustomerAccount.getMessage().getIdCustomerTransmitter()) );

		return messageWithCustomerAccount;
	}
	public List<MessageWithCustomerAccount> loadMessageWithCustomerAccount(Integer idCustomer)
	{		
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
		messageDAO = Spring.getSpring().getMessageDAO();
		customerAccountDAO = Spring.getSpring().getCustomerAccountDAO();
	}
}
