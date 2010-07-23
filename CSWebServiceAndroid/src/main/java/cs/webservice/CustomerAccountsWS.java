package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import cs.httpclient.HttpClient;
import cs.model.CustomerAccounts;

public class CustomerAccountsWS
{
	private static final String URL = "http://10.0.2.2:8888/CSAppWeb/CustomerAccountsWS"; 
	
	public CustomerAccounts getCustomerAccounts(Integer id)
	{
		// JSON object to hold the information, which is sent to the server	 
		JSONObject jsonObjSend = new JSONObject();
		
	  try
	  {
		   // Add a nested JSONObject (e.g. for header information)
		   JSONObject header = new JSONObject();
		   header.put("deviceType","Android"); // Device type
		   header.put("deviceVersion","2.0"); // Device OS version
		   header.put("language", "es-es"); // Language of the Android client
		   jsonObjSend.put("header", header);
	  }
	  catch (JSONException e)
	  {
		  e.printStackTrace();
	  }

	  HttpClient  ht = new HttpClient();
	  
	  List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	  nameValuePairs.add(new BasicNameValuePair("id", id.toString()));
		
	  JSONObject jsonObject = ht.SendHttpPost(URL, jsonObjSend, nameValuePairs) ;

	  CustomerAccounts use = new CustomerAccounts();

		try {
			JSONObject tmp = jsonObject.getJSONObject("use");
			use.setCustomerLogin( tmp.getString("customerLogin") );
			return use;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return use;
	}
}