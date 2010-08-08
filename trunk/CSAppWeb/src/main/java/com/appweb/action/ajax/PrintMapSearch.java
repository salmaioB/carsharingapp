package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PrintMapSearch extends Action
{
 
	private String start;
	private String stop;
	
	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getStop() {
		return stop;
	}


	public void setStop(String stop) {
		this.stop = stop;
	}


	public PrintMapSearch()
    {
    	System.out.println("Construct PrintMapSearch");
    }


	public String execute() throws Exception
	{
		System.out.println("PrintMapSearch");
		return SUCCESS;
	}
}