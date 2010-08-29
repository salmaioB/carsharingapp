package cs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import cs.common.HttpClient;
import cs.define.Define;
import cs.model.Message;


public class MessageSaveWS
{
	private static final String URL = Define.webServiceRootUrl + "CSAppWeb/MessageSaveWS";

	private JSONObject jsonObjectSend;
	
	public MessageSaveWS()
	{
		// JSON object to hold the information, which is sent to the server
		jsonObjectSend = new JSONObject();
		
		// To construct the jsonObject header
		HttpClient.constructHeader(jsonObjectSend);
	}
	
	public void saveMessage(Message message)
	{
		List<NameValuePair> paramsToPost = new ArrayList<NameValuePair>();
		paramsToPost.add(new BasicNameValuePair("title", message.getTitle()));
		paramsToPost.add(new BasicNameValuePair("content", message.getContent()));
		paramsToPost.add(new BasicNameValuePair("idOffer", message.getIdOffer().toString()));
		paramsToPost.add(new BasicNameValuePair("idCustomerAccount", message.getIdCustomerAccount().toString()));
		paramsToPost.add(new BasicNameValuePair("idCustomerTransmitter", message.getIdCustomerTransmitter().toString()));		
		paramsToPost.add(new BasicNameValuePair("isRead", message.getIsRead().toString()));
		
		
		// Send the HTTP request
		HttpClient.SendHttpPost(URL, jsonObjectSend, paramsToPost);
	}
}
