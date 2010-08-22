package com.appweb.action.ajax;

import java.util.ArrayList;
import java.util.List;

import com.appweb.Action;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.action.MessageWithCustomerAccountAction;
import cs.engine.spring.SpringEngine;
import cs.model.CustomerAccount;
import cs.model.Message;
import cs.model.MessageWithCustomerAccount;

public class MessageSend extends Action
{
    private List<MessageWithCustomerAccount> listMessageSend;


	public MessageSend()
    {
    	System.out.println("Construct MessageSend");
    }

	public String execute() throws Exception
	{
		System.out.println("execute MessageSend");
		MessageWithCustomerAccountAction messageEngine  = SpringEngine.getSpring().getMessageWithCustomerAccountAction();//new MessageWithCustomerAccountAction();
		
		listMessageSend = new ArrayList<MessageWithCustomerAccount>();
		listMessageSend.addAll( messageEngine.loadMessageWithCustomerAccountSend( getCustomerAccount().getId() ) );
		
		System.out.println("Nombre de message send : " + listMessageSend.size() );
		return SUCCESS;
	}

	public List<MessageWithCustomerAccount> getListMessageSend() {
		return listMessageSend;
	}

	public void setListMessageSend(List<MessageWithCustomerAccount> listMessageSend) {
		this.listMessageSend = listMessageSend;
	}
}