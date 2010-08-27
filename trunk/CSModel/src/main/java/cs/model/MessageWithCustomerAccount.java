package cs.model;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageWithCustomerAccount
{
	private Integer id;
	private Message message;
	private CustomerAccount customerAccount;
	
	
	public MessageWithCustomerAccount()
	{
		message = new Message();
		customerAccount = new CustomerAccount();
	}
	
	public MessageWithCustomerAccount(JSONObject jsonObjectMessageWithCustomerAccount) throws JSONException
	{
		id				= jsonObjectMessageWithCustomerAccount.getInt("id");
		message 		= new Message(jsonObjectMessageWithCustomerAccount.getJSONObject("message"));
		customerAccount = new CustomerAccount(jsonObjectMessageWithCustomerAccount.getJSONObject("customerAccount"));
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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
}
