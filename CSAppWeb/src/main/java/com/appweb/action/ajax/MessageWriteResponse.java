package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.MessageWithCustomerAccountAction;
import cs.engine.spring.SpringEngine;

public class MessageWriteResponse extends Action
{
    private Integer idMessage;
	private String content;
	
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
		System.out.println("idMessage : " + getIdMessage() );
		System.out.println("content : " + getContent() );
		MessageWithCustomerAccountAction messageEngine  = SpringEngine.getSpring().getMessageWithCustomerAccountAction();//new MessageWithCustomerAccountAction();
		StringBuilder title = new StringBuilder();
		title.append("RE : ");
		System.out.println("11111111111111111111");
		title.append( messageEngine.load(idMessage).getMessage().getTitle() );
		System.out.println("222222222222222222222 : " + title);
		messageEngine.sendMessageResponse(title.toString(), getContent(), getIdMessage());
		System.out.println("333333333333333333333");
		return SUCCESS;
	}
}