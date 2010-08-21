package cs.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

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
	
	public List<OfferWithCustomerAccount> getSearchOffers(String startingCity, String finishingCity)
	{	
		String URL = Define.webServiceRootUrl + "CSAppWeb/OffersWS";
		
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("startingCity", startingCity.toString()));
		paramsToPost.add(new BasicNameValuePair("finishingCity", finishingCity.toString()));
		
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost) ;
	
	    List<OfferWithCustomerAccount> offersWithCustomerAccount = new ArrayList<OfferWithCustomerAccount>();
	    
		try
		{
			// Retrieve a jsonArray which contains an offer list
			JSONArray jsonArrayListOffers = jsonObjectReturn.getJSONArray("offersWithCustomerAccount");
			Log.v("taille", Integer.toString(jsonArrayListOffers.length()));
		 
			for(int i=0; i<jsonArrayListOffers.length(); i++)
			{
				// Retrieve each offer
				JSONObject jsonObjectOfferWithCustomerAccount = jsonArrayListOffers.getJSONObject(i);
			 
				// Create an offer and set all attributes
				OfferWithCustomerAccount offerWithCustomerAccount = new OfferWithCustomerAccount();
				offerWithCustomerAccount.setId(jsonObjectOfferWithCustomerAccount.getInt("id"));
				offerWithCustomerAccount.setFirstName(jsonObjectOfferWithCustomerAccount.getString("firstName"));
				offerWithCustomerAccount.setLastName(jsonObjectOfferWithCustomerAccount.getString("lastName"));
				offerWithCustomerAccount.setNumberOfPlaceRemaining(Integer.valueOf(jsonObjectOfferWithCustomerAccount.getInt("numberOfPlaceRemaining")));
				offerWithCustomerAccount.setPricePerPassenger(Float.parseFloat(jsonObjectOfferWithCustomerAccount.getString("pricePerPassenger")));
                //offerWithCustomerAccount.setDatetimeStarted(jsonObjectOfferWithCustomerAccount.getString("datetimeStarted")));

				offersWithCustomerAccount.add(offerWithCustomerAccount);
			}
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		 
		return offersWithCustomerAccount;
	}
	
//	public List<Offer> getCustomerOffers(Integer idCustomerAccount)
//	{
//		String URL = Define.webServiceRootUrl + "CSAppWeb/CustomerOffersWS";
//		
//		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
//				
//		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost) ;
//		
//	    List<Offer> offers = new ArrayList<Offer>();

//	    try
//		{
	    	// Retrieve a jsonArray which contains an offer list
			//JSONArray jsonArrayListOffers = jsonObjectReturn.getJSONArray("offers");
			
			
//		}
//	}
}
