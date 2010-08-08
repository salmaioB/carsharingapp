package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class CheckOutAjax extends Action
{
    private CustomerAccount ca;
    
    public CheckOutAjax()
    {
    	System.out.println("Construct Check out");
    	ca = new CustomerAccount();
    }


	public String execute() throws Exception
	{
		System.out.println("Check out");
		getSession().clear();
		getSession().remove("customerId");
		return SUCCESS;
	}
}