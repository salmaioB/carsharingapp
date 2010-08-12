package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PostEtape2 extends Action
{
 
	public PostEtape2()
    {
    	System.out.println("Construct PostEtape2");
    }


	public String execute() throws Exception
	{
		System.out.println("Check PostEtape2");
		return SUCCESS;
	}
}