package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.MessageDAO;
import cs.model.Message;


public class MessageSaveWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String content;
	private Integer idOffer;
	private Integer idCustomerAccount;
	private Integer idCustomerTransmitter;
	private Integer isRead;
//	private Date datetimeWrited;
	
	
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
	
	public Integer getIdOffer() {
		return idOffer;
	}
	
	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
	
	public Integer getIdCustomerTransmitter() {
		return idCustomerTransmitter;
	}
	
	public void setIdCustomerTransmitter(Integer idCustomerTransmitter) {
		this.idCustomerTransmitter = idCustomerTransmitter;
	}
	
	public Integer getIsRead() {
		return isRead;
	}
	
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	
//	public Date getDatetimeWrited() {
//		return datetimeWrited;
//	}
//	public void setDatetimeWrited(Date datetimeWrited) {
//		
//		System.out.println(datetimeWrited.toString());
//		this.datetimeWrited = datetimeWrited;
//	}
	
	public String execute() throws Exception
 	{
		Message message = new Message();
		message.setTitle(title);
		message.setContent(content);
		message.setIdOffer(idOffer);
		message.setIdCustomerAccount(idCustomerAccount);
		message.setIdCustomerTransmitter(idCustomerTransmitter);
		message.setIsRead(isRead);
		
		System.out.println(message.getIsRead().toString());
		
//		message.setDateTimeWrited(datetimeWrited);
		
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.save(message);
		
		return SUCCESS;	
 	}
}
