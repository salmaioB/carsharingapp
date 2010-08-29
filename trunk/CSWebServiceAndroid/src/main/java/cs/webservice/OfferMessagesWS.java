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
import cs.model.MessageWithCustomerAccount;


public class OfferMessagesWS
{
	private JSONObject jsonObjectSend;
	
	public OfferMessagesWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
    public List<MessageWithCustomerAccount> getOfferMessages(Integer idOffer, Integer idCustomerTransmitter, Integer idCurrentCustomerAccount)
    {
    	String URL = Define.webServiceRootUrl + "CSAppWeb/OfferMessagesWS";
    	
    	List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
    	paramsToPost.add(new BasicNameValuePair("idOffer", idOffer.toString()));    	
    	paramsToPost.add(new BasicNameValuePair("idCustomerTransmitter", idCustomerTransmitter.toString()));
    	paramsToPost.add(new BasicNameValuePair("idCurrentCustomerAccount", idCurrentCustomerAccount.toString()));
    	
    	JSONObject jsonObjectReturn = HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
    	
    	List<MessageWithCustomerAccount> messagesWithCustomerAccount = new ArrayList<MessageWithCustomerAccount>();
    	
    	try
		{
			// Retrieve a jsonArray which contains a message with customer account list
			JSONArray jsonArrayListMessages = jsonObjectReturn.getJSONArray("messagesWithCustomerAccount");
			
			for(int i=0; i<jsonArrayListMessages.length(); i++)
			{
				// Retrieve each message
				JSONObject jsonObjectMessage = jsonArrayListMessages.getJSONObject(i);
				
				// Create an customerOfferWithMessageAndCustomerAccount and set all attributes
				MessageWithCustomerAccount messageWithCustomerAccount = new MessageWithCustomerAccount(jsonObjectMessage);
				
				messagesWithCustomerAccount.add(messageWithCustomerAccount);
			}
		}
    	catch(JSONException e)
		{
			e.printStackTrace();
		}
    	
    	return messagesWithCustomerAccount;
    }
}
