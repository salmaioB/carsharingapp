package com.appweb.action.ajax;

import com.appweb.Action;

import cs.dao.dao.MessageDAO;
import cs.dao.spring.SpringDAO;

public class GetNumberOfMessageReadNotRead extends Action
{
	private Integer numberOfMessage;
	
	public Integer getNumberOfMessage() {
		return numberOfMessage;
	}
	public void setNumberOfMessage(Integer numberOfMessage) {
		this.numberOfMessage = numberOfMessage;
	}

	public String execute() throws Exception
	{
		System.out.println("execute numberOfMessage");
		//Gestion des messages
		MessageDAO messageDAO = SpringDAO.getSpring().getMessageDAO();
		setNbMessageNotRead(messageDAO.nbMessageNotRead(getCustomerAccount().getId() ) );
		setNumberOfMessage(getNbMessageNotRead() );
		
		System.out.println("getNbMessageNotRead() : " + getNbMessageNotRead());
		return SUCCESS;
	}
}

