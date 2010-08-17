package com.appweb.action.ajax;

import java.util.ArrayList;
import java.util.List;

import com.appweb.Action;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.action.MessageWithCustomerAccountAction;
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
		MessageWithCustomerAccountAction messageEngine  = new MessageWithCustomerAccountAction();
		
		listMessageReceive = new ArrayList<MessageWithCustomerAccount>();
		listMessageReceive.add( messageEngine.load(1) );
		listMessageReceive.add( messageEngine.load(2) );
		
		return SUCCESS;
	}
}