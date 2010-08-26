package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cs.common.HttpClient;
import cs.define.Define;
import cs.model.CustomerOfferWithMessageAndCustomerAccount;


public class CustomerOffersWithMessageAndCustomerAccountWS
{
	private JSONObject jsonObjectSend;
	
	public CustomerOffersWithMessageAndCustomerAccountWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	public List<CustomerOfferWithMessageAndCustomerAccount> getCustomerOffersWithMessage(Integer idCustomerAccount)
	{
		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerOffersWithMessageAndCustomerAccountWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("idCustomerAccount", idCustomerAccount.toString()));
		
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost) ;
		
	    List<CustomerOfferWithMessageAndCustomerAccount> customerOffersWithMessageAndCustomerAccount = new ArrayList<CustomerOfferWithMessageAndCustomerAccount>();
	    
		try
		{
			// Retrieve a jsonArray which contains an offer list
			JSONArray jsonArrayListCustomerOffersWithMessageAndCustomerAccount = jsonObjectReturn.getJSONArray("customerOffersWithMessageAndCustomerAccount");
			
			for(int i=0; i<jsonArrayListCustomerOffersWithMessageAndCustomerAccount.length(); i++)
			{
				// Retrieve each customerOfferWithMessageAndCustomerAccount
				JSONObject jsonObjectCustomerOfferWithMessageAndCustomerAccount = jsonArrayListCustomerOffersWithMessageAndCustomerAccount.getJSONObject(i);
				
				// Create an customerOfferWithMessageAndCustomerAccount and set all attributes
				CustomerOfferWithMessageAndCustomerAccount customerOfferWithMessageAndCustomerAccount = new CustomerOfferWithMessageAndCustomerAccount(jsonObjectCustomerOfferWithMessageAndCustomerAccount);
				
				customerOffersWithMessageAndCustomerAccount.add(customerOfferWithMessageAndCustomerAccount);
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
		return customerOffersWithMessageAndCustomerAccount;
	}
}
