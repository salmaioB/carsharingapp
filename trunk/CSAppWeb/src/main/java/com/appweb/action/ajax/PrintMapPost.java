package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PrintMapPost extends Action
{
	public PrintMapPost()
    {
    	System.out.println("Construct PrintMapPost");
    }


	public String execute() throws Exception
	{
		System.out.println("PrintMapPost");

		return SUCCESS;
	}
}