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

public class MessageReceive extends Action
{
    private List<MessageWithCustomerAccount> listMessageReceive;

	public List<MessageWithCustomerAccount> getListMessageReceive() {
		return listMessageReceive;
	}

	public void setListMessageReceive(
			List<MessageWithCustomerAccount> listMessageReceive) {
		this.listMessageReceive = listMessageReceive;
	}

	public MessageReceive()
    {
    	System.out.println("Construct MessageReceive");
    }

	public String execute() throws Exception
	{
		System.out.println("execute MessageReceive");
		MessageWithCustomerAccountAction messageEngine  = SpringEngine.getSpring().getMessageWithCustomerAccountAction();//new MessageWithCustomerAccountAction();
		
		listMessageReceive = new ArrayList<MessageWithCustomerAccount>();
		listMessageReceive.addAll( messageEngine.loadMessageWithCustomerAccountReceive( getCustomerAccount().getId() ) );
		
		System.out.println("Nombre de message receive : " + listMessageReceive.size() );
		return SUCCESS;
	}
}