package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import cs.common.HttpClient;
import cs.define.Define;
import cs.model.Offer;
import cs.model.Route;

public class OfferSaveWS
{
	private static final String URL = Define.webServiceRootUrl + "CSAppWeb/OfferSaveWS";

	private JSONObject jsonObjectSend;
	
	public OfferSaveWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	public void saveOfferWithRoutes(Offer offer, Route route, Integer idCustomerAccount, Integer isDriver)
	{
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
   
		paramsToPost.add(new BasicNameValuePair("idCustomerAccount", idCustomerAccount.toString()));
		paramsToPost.add(new BasicNameValuePair("isDriver", isDriver.toString()));
		
		paramsToPost.add(new BasicNameValuePair("numberOfPassengers", offer.getNumberOfPlaceInitial().toString()));
		paramsToPost.add(new BasicNameValuePair("pricePerPassenger", offer.getPricePerPassenger().toString()));

		paramsToPost.add(new BasicNameValuePair("startingCity", route.getStartingCity().toString()));
		paramsToPost.add(new BasicNameValuePair("finishingCity", route.getFinishingCity().toString()));		
		//paramsToPost.add(new BasicNameValuePair("price", route.getPrice().toString()));
		
		// Send the http request
		HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
	}
}
