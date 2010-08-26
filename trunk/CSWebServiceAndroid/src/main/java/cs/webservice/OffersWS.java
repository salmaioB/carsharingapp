package cs.webservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cs.model.OfferWithCustomerAccount;
import cs.common.HttpClient;
import cs.define.Define;


public class OffersWS
{
	private JSONObject jsonObjectSend;
	
	public OffersWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	public List<OfferWithCustomerAccount> getSearchOffers(String startingCity, String finishingCity, Integer idCustomerAccount) throws ParseException
	{	
		String URL = Define.webServiceRootUrl + "CSAppWeb/SearchOffersWithCustomerAccountWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		
		if(idCustomerAccount != null)
			paramsToPost.add(new BasicNameValuePair("idCustomerAccount", idCustomerAccount.toString()));
		
		if(startingCity != null)
			paramsToPost.add(new BasicNameValuePair("startingCity", startingCity.toString()));
		
		if(finishingCity != null)
			paramsToPost.add(new BasicNameValuePair("finishingCity", finishingCity.toString()));
		
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost) ;
	
	    List<OfferWithCustomerAccount> offers = new ArrayList<OfferWithCustomerAccount>();
	    
		try
		{
			// Retrieve a jsonArray which contains an offer list
			JSONArray jsonArrayListOffers = jsonObjectReturn.getJSONArray("offersWithCustomerAccount");
		 
			for(int i=0; i<jsonArrayListOffers.length(); i++)
			{
				// Retrieve each offer
				JSONObject jsonObjectOffer = jsonArrayListOffers.getJSONObject(i);
			 
				// Create an offer and set all attributes
				OfferWithCustomerAccount offer = new OfferWithCustomerAccount(jsonObjectOffer);
				offers.add(offer);
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		 
		return offers;
	}
}
