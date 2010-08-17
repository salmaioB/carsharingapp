package cs.model;

import java.util.Date;

public class MessageWithCustomerAccount
{
	private Message message;
	private CustomerAccount customerAccount;
	
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
	public MessageWithCustomerAccount()
	{
		message = new Message();
		customerAccount = new CustomerAccount();
	}
}
