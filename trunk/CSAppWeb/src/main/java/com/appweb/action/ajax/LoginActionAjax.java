package com.appweb.action.ajax;

import com.appweb.Action;

public class LoginActionAjax extends Action
{
    private String username;
    private String password;
    
    public LoginActionAjax()
    {
    	username ="toto";
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
		
		if(!getUsername().equals("Admin") || !getPassword().equals("Admin"))
		{
			getSession().put("username", username);
			//addActionError("Invalid user name or password! Please try again!");
			return SUCCESS;//ERROR;
	    }
		else
		{
			return SUCCESS;
		}
	}
}