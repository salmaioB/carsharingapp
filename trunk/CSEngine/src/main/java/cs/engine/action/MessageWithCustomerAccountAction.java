package cs.engine.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.dao.spring.SpringDAO;
import cs.model.CustomerAccount;
import cs.model.Message;
import cs.model.MessageWithCustomerAccount;

public class MessageWithCustomerAccountAction 
{
	private MessageWithCustomerAccount messageWithCustomerAccount;
	private MessageDAO messageDAO;
	private CustomerAccountDAO customerAccountDAO;
	
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}
	public CustomerAccountDAO getCustomerAccountDAO() {
		return customerAccountDAO;
	}
	public void setCustomerAccountDAO(CustomerAccountDAO customerAccountDAO) {
		this.customerAccountDAO = customerAccountDAO;
	}
	
	public MessageWithCustomerAccount load(Integer idMessage)
	{	
		messageWithCustomerAccount.setMessage( messageDAO.load(idMessage) );
		messageWithCustomerAccount.setCustomerAccount( customerAccountDAO.load(messageWithCustomerAccount.getMessage().getIdCustomerTransmitter()) );

		return messageWithCustomerAccount;
	}
	
	public List<MessageWithCustomerAccount> loadMessageWithCustomerAccountSend(Integer idCustomer)
	{		
		List<Message> messages = messageDAO.loadSearchMessagesSend(idCustomer);
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
	
	public List<MessageWithCustomerAccount> loadMessageWithCustomerAccountReceive(Integer idCustomer)
	{		
		List<Message> messages = messageDAO.loadSearchMessagesReceive(idCustomer);
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
	public void sendMessageResponse(String title,String content, Integer idMessageOrigine)
	{
		Message message = messageDAO.load(idMessageOrigine);
		Message messageSend = new Message();
		messageSend.setContent(content);
		messageSend.setTitle(title);
		messageSend.setDateTimeWrited(new Date());
		messageSend.setIdCustomerAccount(message.getIdCustomerTransmitter());
		messageSend.setIdCustomerTransmitter( message.getIdCustomerAccount() );
		messageSend.setIsRead(0);
		messageSend.setIdOffer(message.getIdOffer());
		messageDAO.save(messageSend);
	}
	public MessageWithCustomerAccountAction()
	{
		messageWithCustomerAccount = new MessageWithCustomerAccount();
	}
}
