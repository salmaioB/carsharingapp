package com.appweb;

import com.opensymphony.xwork2.ActionSupport;
import cs.engine.action.UserEngineAction;
import cs.model.User;

public class AccueilAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "";
	private String message;
	private String testMessage;
	
	public String getTestMessage() {
		return testMessage;
	}

	public void setTestMessage(String testMessage) {
		this.testMessage = testMessage;
	}

	public String execute()
	{
		UserEngineAction u = new UserEngineAction();
		User use = u.load(new Integer(1));
		if(use!= null)
		{
			String chaine = use.getAdresse() +"-" + use.getCp() ;
			testMessage ="gfdffgjdfjkdgkjddfj";
			setMessage(chaine);
		}
		else
		{
			setMessage("use non trouvé");
			testMessage ="gfdffgjdfjkdgkjddfj";
		}
		return SUCCESS;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
