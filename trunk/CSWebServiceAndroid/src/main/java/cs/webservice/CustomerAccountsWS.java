package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import cs.model.CustomerAccount;
import cs.common.HttpClient;
import cs.define.Define;

public class CustomerAccountsWS
{
	private JSONObject jsonObjectSend;
	
	private static final String URL = "http://10.0.2.2:"+Define.port+"/CSAppWeb/CustomerAccountsWS";
	
	public CustomerAccountsWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	// TO BE DELETED ?
	public CustomerAccount getCustomerAccounts(Integer id)
	{ 
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("id", id.toString()));
		
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, nameValuePairs);

		CustomerAccount customerAccount = new CustomerAccount();
        
	    try
	    {
	    	JSONObject tmp = jsonObjectReturn.getJSONObject("use");
	    	customerAccount.setCustomerLogin( tmp.getString("customerLogin") );
	    	return customerAccount;
	    }
	    catch (JSONException e)
	    {
	    	e.printStackTrace();
	    }
	  
	    return customerAccount;
	}
	
	public CustomerAccount getCustomerAccount(String customerLogin, String customerPassword)
	{
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("customerLogin", customerLogin));
		paramsToPost.add(new BasicNameValuePair("customerPassword", customerPassword));
		
		// Contains the jsonObject return by the http request
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);

		CustomerAccount customerAccount = new CustomerAccount();
		
		try
	    {
			JSONObject jsonObjectCustomerAccount;
			
			if(!jsonObjectReturn.get("customerAccount").equals(null))
			{
			 Log.v("qs", "wwwwwwww");
				
	    	 jsonObjectCustomerAccount = jsonObjectReturn.getJSONObject("customerAccount");

			 customerAccount.setCustomerLogin(jsonObjectCustomerAccount.getString("customerLogin"));
	         customerAccount.setCustomerPassword(jsonObjectCustomerAccount.getString("customerPassword"));
			 customerAccount.setLastName(jsonObjectCustomerAccount.getString("lastName"));
			 customerAccount.setFirstName(jsonObjectCustomerAccount.getString("firstName"));
			 customerAccount.setEmailAddress(jsonObjectCustomerAccount.getString("emailAddress"));
			 customerAccount.setPhone(jsonObjectCustomerAccount.getInt("phone"));
			 customerAccount.setMobile(jsonObjectCustomerAccount.getInt("mobile"));
			 customerAccount.setCustomerType(jsonObjectCustomerAccount.getInt("customerType"));
			 //customerAccount.setIdVehicule(jsonObjectCustomerAccount.getInt("_id_vehicule"));
			 customerAccount.setAcceptAnimals(jsonObjectCustomerAccount.getInt("acceptAnimals"));
             customerAccount.setAcceptRadio(jsonObjectCustomerAccount.getInt("acceptRadio"));
			 customerAccount.setAcceptSmoker(jsonObjectCustomerAccount.getInt("acceptSmoker"));
			 customerAccount.setAcceptToDiscuss(jsonObjectCustomerAccount.getInt("acceptToDiscuss"));
			 customerAccount.setAcceptToMakeADetour(jsonObjectCustomerAccount.getInt("acceptToMakeADetour"));
             //customerAccount.setDatetimeRegistration(jsonObjectCustomerAccount.getString("datetime_registration"));
             //customerAccount.setDatetimeLastConnection(jsonObjectCustomerAccount.getString("datetime_last_connection"));
             //customerAccount.setDatetimeLastOfferCreated(jsonObjectCustomerAccount.getString("datetime_last_offer_created"));
             //customerAccount.setDatetimeLastCarSharing(jsonObjectCustomerAccount.getString("datetime_last_car_sharing"));
			}
			else customerAccount = null;
	    }
	    catch (JSONException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return customerAccount;
	}
}