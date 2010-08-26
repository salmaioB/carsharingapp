package cs.model;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomerOfferWithMessageAndCustomerAccount
{
	private Integer id;
	private Offer offer;
	private Message message;
	private CustomerAccount customerAccount;

	
	public CustomerOfferWithMessageAndCustomerAccount()
	{
		
	}
	
	public CustomerOfferWithMessageAndCustomerAccount(JSONObject jsonObjectCustomerOfferWithMessageAndCustomerAccount) throws JSONException
	{
		if(!jsonObjectCustomerOfferWithMessageAndCustomerAccount.isNull("id"))
			id              = jsonObjectCustomerOfferWithMessageAndCustomerAccount.getInt("id");
		
		if(!jsonObjectCustomerOfferWithMessageAndCustomerAccount.isNull("offer"))
			offer   		= new Offer(jsonObjectCustomerOfferWithMessageAndCustomerAccount.getJSONObject("offer"));
        
		if(!jsonObjectCustomerOfferWithMessageAndCustomerAccount.isNull("message"))
			message 		= new Message(jsonObjectCustomerOfferWithMessageAndCustomerAccount.getJSONObject("message"));
        
		if(!jsonObjectCustomerOfferWithMessageAndCustomerAccount.isNull("customerAccount"))
			customerAccount = new CustomerAccount(jsonObjectCustomerOfferWithMessageAndCustomerAccount.getJSONObject("customerAccount"));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Offer getOffer() {
		return offer;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
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
