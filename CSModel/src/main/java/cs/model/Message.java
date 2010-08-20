package cs.model;

import java.util.Date;

public class Message
{
	private Integer id; 
	private String title;
	private String content;
	private Integer idCustomerAccount;
	private Integer read;
	private Date dateTime;
	private Integer idCustomerTransmitter;
	
	public Integer getIdCustomerTransmitter() {
		return idCustomerTransmitter;
	}
	public void setIdCustomerTransmitter(Integer idCustomerTransmitter) {
		this.idCustomerTransmitter = idCustomerTransmitter;
	}

	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getRead() {
		return read;
	}
	public void setRead(Integer read) {
		this.read = read;
	}
	
	public String toString()
	{
		return getId() + ' ' + getTitle() + ' ' + getContent() + ' ' + getIdCustomerAccount() + ' ' + getIdCustomerTransmitter() +' ' + getDateTime() + ' ' +getRead();
	}
}
