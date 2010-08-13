package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import cs.model.Offer;
import cs.model.Route;
import cs.common.HttpClient;
import cs.define.Define;

public class OffersWS
{	
	private static final String URL = Define.webServiceRootUrl + "CSAppWeb/OffersWS";

	private JSONObject jsonObjectSend;
	
	public OffersWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	public List<Offer> getSearchOffers()
	{
		// JSON object to hold the information, which is sent to the server	 
		JSONObject jsonObjectSend = new JSONObject();
		
		try
		{
		 // Add a nested JSONObject (e.g. for header information)
		 JSONObject header = new JSONObject();
		 header.put("deviceType","Android"); // Device type
		 header.put("deviceVersion","2.0"); // Device OS version
		 header.put("language", "es-es"); // Language of the Android client
		 jsonObjectSend.put("header", header);
		}
		catch (JSONException e)
		{
		 e.printStackTrace();
		}
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		//nameValuePairs.add(new BasicNameValuePair("id", id.toString()));
			
		JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, nameValuePairs) ;
	
	    List<Offer> offers = new ArrayList<Offer>();
	    
		try
		{
		 // Retrieve a jsonArray which contains an offer list
		 JSONArray jsonArrayListOffers = jsonObjectReturn.getJSONArray("offers");
		 Log.v("taille", Integer.toString(jsonArrayListOffers.length()));
		 
		 for(int i=0; i<jsonArrayListOffers.length(); i++)
		 {
			 // Retrieve each offer
			 JSONObject jsonObjectOffer = jsonArrayListOffers.getJSONObject(i);
			 
			 // Create an offer and set all attributes
			 Offer offer = new Offer();
			 offer.setId(jsonObjectOffer.getInt("id"));
			 offer.setIdOfferType(jsonObjectOffer.getInt("idOfferType"));
			 offer.setIdDriver(jsonObjectOffer.getInt("idDriver"));
			 offer.setTitle(jsonObjectOffer.getString("title"));
			 offer.setDescription(jsonObjectOffer.getString("description"));
			 offer.setNumberOfPlaceInitial(jsonObjectOffer.getInt("numberOfPlaceInitial"));
			 offer.setNumberOfPlaceRemaining(jsonObjectOffer.getInt("numberOfPlaceRemaining"));
			 //offer.setDateStarted(Date.valueOf(jsonObjectOffer.getString("dateStarted")));
			 //offer.setDateEnded(Date.valueOf(jsonObjectOffer.getString("dateEnded")));
		 
			 offers.add(offer);
		 }
		}
		catch(JSONException e)
		{
		 e.printStackTrace();
		}
		 
		return offers;
	 }
	
	 public void saveOfferWithRoutes(Offer offer, List<Route> routes)
	 {
		 List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		 paramsToPost.add(new BasicNameValuePair("idOfferType", String.valueOf(0)));		 
		 paramsToPost.add(new BasicNameValuePair("idDriver", offer.getIdDriver().toString()));
		 paramsToPost.add(new BasicNameValuePair("numberOfPassengers", offer.getNumberOfPlaceInitial().toString()));
		 paramsToPost.add(new BasicNameValuePair("pricePerPassenger", offer.getPricePerPassenger().toString()));
		 
		 // Send the http request
		 HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
	 }
}
