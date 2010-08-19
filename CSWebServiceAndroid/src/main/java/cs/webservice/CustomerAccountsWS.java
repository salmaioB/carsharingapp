package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import cs.model.CustomerAccount;
import cs.common.HttpClient;
import cs.define.Define;

public class CustomerAccountsWS
{
	private JSONObject jsonObjectSend;
	
	public CustomerAccountsWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	public CustomerAccount getCustomerAccount(Integer id)
	{
		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerAccountsWS";
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("id", id.toString()));
		
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, nameValuePairs);

		CustomerAccount customerAccount = null;
        
	    try
	    {
			JSONObject jsonObjectCustomerAccount;
			
			if(!jsonObjectReturn.get("customerAccount").equals(null))
			{				
				jsonObjectCustomerAccount = jsonObjectReturn.getJSONObject("customerAccount");
	    	 
				customerAccount = new CustomerAccount(jsonObjectCustomerAccount);
			}
	    }
	    catch (JSONException e)
	    {
	    	e.printStackTrace();
	    }
	  
	    return customerAccount;
	}
	
	public CustomerAccount getCustomerAccount(String customerLogin, String customerPassword)
	{
		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerAccountsWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("customerLogin", customerLogin));
		paramsToPost.add(new BasicNameValuePair("customerPassword", customerPassword));
		
		// Contains the jsonObject return by the http request
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
		
		CustomerAccount customerAccount = null;
		
		try
	    {
			JSONObject jsonObjectCustomerAccount;
			
			if(!jsonObjectReturn.get("customerAccount").equals(null))
			{				
				jsonObjectCustomerAccount = jsonObjectReturn.getJSONObject("customerAccount");
	    	 
				customerAccount = new CustomerAccount(jsonObjectCustomerAccount);
			}
	    }
	    catch (JSONException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return customerAccount;
	}
	
	public void saveCustomerLocation(Integer idCustomerAccount, double geolocLongitude, double geolocLatitude)
	{
		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerAccountsWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("id", idCustomerAccount.toString()));
		paramsToPost.add(new BasicNameValuePair("geolocLongitude", Double.toString(geolocLongitude)));
		paramsToPost.add(new BasicNameValuePair("geolocLatitude", Double.toString(geolocLatitude)));
		
		// Send the http request
		HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
	}
	
	public void saveCustomerGeneralInfos(Integer idCustomerAccount, String lastName, String firstName, String emailAddress, String mobile)
	{
		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerAccountSaveGeneralInfosWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("id", idCustomerAccount.toString()));
		paramsToPost.add(new BasicNameValuePair("lastName", lastName));
		paramsToPost.add(new BasicNameValuePair("firstName", firstName));
		paramsToPost.add(new BasicNameValuePair("emailAddress", emailAddress));
		paramsToPost.add(new BasicNameValuePair("mobile", mobile));
		
		// Send the http request
		HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
	}
	
	public void saveCustomerPreferences(Integer idCustomerAccount, Integer acceptAnimals, Integer acceptRadio, Integer acceptSmoker, Integer acceptToDiscuss, Integer acceptToMakeADetour)
	{
		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerAccountSavePreferencesWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("id", idCustomerAccount.toString()));
		paramsToPost.add(new BasicNameValuePair("acceptAnimals", acceptAnimals.toString()));
		paramsToPost.add(new BasicNameValuePair("acceptRadio", acceptRadio.toString()));
		paramsToPost.add(new BasicNameValuePair("acceptSmoker", acceptSmoker.toString()));
		paramsToPost.add(new BasicNameValuePair("acceptToDiscuss", acceptToDiscuss.toString()));
		paramsToPost.add(new BasicNameValuePair("acceptToMakeADetour", acceptToMakeADetour.toString()));
		
		// Send the http request
		HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
	}
}