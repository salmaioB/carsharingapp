package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;

public class LoginActionAjax extends Action
{
    private String username;
    private String password;
    
    public LoginActionAjax()
    {
		System.out.println("Construct LoginActionAjax");
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception
	{
		System.out.println("Validating login");
		
		CustomerAccountEngineAction customerAccountEngine = new  CustomerAccountEngineAction();
		setCustomerAccount(customerAccountEngine.identification(username, password));
		
		if(getCustomerAccount() != null)
		{
			getSession().put("customerId",getCustomerAccount().getId()); 
			username+=getCustomerAccount().getId();
			return SUCCESS;
	    }
		else
		{
			return ERROR;
		}
	}
}