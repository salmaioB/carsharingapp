package cs.model;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Message
{
	private Integer id;
	private Integer idOffer;
	private String title;
	private String content;
	private Integer idCustomerAccount;
	private Integer isRead;
	private Date datetimeWrited;
	private Integer idCustomerTransmitter;
	
	
	public Message()
	{
		
	}
	
	public Message(JSONObject jsonObjectMessage) throws JSONException
	{
		if(!jsonObjectMessage.isNull("id"))
			id      		  = jsonObjectMessage.getInt("id");
		
		if(!jsonObjectMessage.isNull("idOffer"))
			idOffer			  = jsonObjectMessage.getInt("idOffer");
		
		if(!jsonObjectMessage.isNull("title"))
			title			  = jsonObjectMessage.getString("title");
		
		if(!jsonObjectMessage.isNull("content"))
			content 		  = jsonObjectMessage.getString("content");
		
		if(!jsonObjectMessage.isNull("idCustomerAccount"))
			idCustomerAccount = jsonObjectMessage.getInt("idCustomerAccount");
		
		if(!jsonObjectMessage.isNull("isRead"))
			isRead			  = jsonObjectMessage.getInt("isRead");
		//dateTimeWrited    = jsonObjectMessage.get
		
		if(!jsonObjectMessage.isNull("idCustomerTransmitter"))
			idCustomerAccount = jsonObjectMessage.getInt("idCustomerTransmitter");
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
	
	public Integer getIsRead() {
		return isRead;
	}
	
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	
	public Date getDatetimeWrited() {
		return datetimeWrited;
	}
	
	public void setDatetimeWrited(Date datetimeWrited) {
		this.datetimeWrited = datetimeWrited;
	}
	
	public Integer getIdCustomerTransmitter() {
		return idCustomerTransmitter;
	}
	
	public void setIdCustomerTransmitter(Integer idCustomerTransmitter) {
		this.idCustomerTransmitter = idCustomerTransmitter;
	}
	
	public String toString()
	{
		return getId() + '/' + getTitle() + '/' + getContent() + '/' + getIdCustomerAccount() + ' ' + getIdCustomerTransmitter() +' ' + getDatetimeWrited() + ' ' +getIsRead();
	}
}
