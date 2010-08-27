package com.appweb.action.ajax;

import java.util.Date;

import com.appweb.Action;

import cs.dao.dao.MessageDAO;
import cs.dao.spring.SpringDAO;
import cs.engine.action.MessageWithCustomerAccountAction;
import cs.engine.spring.SpringEngine;
import cs.model.Message;

public class MessageWriteResponse extends Action
{
    private Integer idMessage;
	private String content;
	private Integer idCustomer;
	private String contentSendSearch;
	private String titleSendSearch;
	private Integer idOffer;
	
	public Integer getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	public String getContentSendSearch() {
		return contentSendSearch;
	}
	public void setContentSendSearch(String contentSendSearch) {
		this.contentSendSearch = contentSendSearch;
	}
	public String getTitleSendSearch() {
		return titleSendSearch;
	}
	public void setTitleSendSearch(String titleSendSearch) {
		this.titleSendSearch = titleSendSearch;
	}
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Integer getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(String idMessage) {
		this.idMessage = Integer.parseInt(idMessage);
	}
    public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}
	public String getContent() {
		if(content == null) content="";
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public MessageWriteResponse()
    {
    	System.out.println("Construct MessageWrite");
    }

	public String execute() throws Exception
	{
		System.out.println("execute MessageWrite");
		MessageWithCustomerAccountAction messageEngine  = SpringEngine.getSpring().getMessageWithCustomerAccountAction();
		MessageDAO messageDAO = SpringDAO.getSpring().getMessageDAO();
		if(idMessage!=null)
		{	
			System.out.println("idMessage : " + getIdMessage() );
			System.out.println("content : " + getContent() );
			//new MessageWithCustomerAccountAction();
			StringBuilder title = new StringBuilder();
			title.append("RE : ");
			title.append( messageEngine.load(idMessage).getMessage().getTitle() );
	
			messageEngine.sendMessageResponse(title.toString(), getContent(), getIdMessage());
		}
		else
		{
			System.out.println("write new message");
			System.out.println("idCustomer : " + idCustomer);
			System.out.println("contentSendSearch : " + contentSendSearch);
			System.out.println("titleSendSearch : " + titleSendSearch);
			
			//Si le destinataires est differnts de null
			if(idCustomer != null)
			{
				Message message = new Message();
				message.setIdCustomerAccount(idCustomer);
				message.setIdCustomerTransmitter(getCustomerAccount().getId());
				message.setContent(contentSendSearch);
				message.setDatetimeWrited(new Date());
				message.setIsRead(0);
				message.setTitle(titleSendSearch);
				message.setIdOffer(idOffer);
				messageDAO.save(message);
			}
		}
		return SUCCESS;
	}
}