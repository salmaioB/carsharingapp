package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PrintMapPost extends Action
{

	private String startPost;
	private String stopPost;
	
	public String getStartPost() {
		return startPost;
	}
	public void setStartPost(String startPost) {
		this.startPost = startPost;
	}
	public String getStopPost() {
		return stopPost;
	}
	public void setStopPost(String stopPost) {
		this.stopPost = stopPost;
	}
	

	public String execute() throws Exception
	{
		System.out.println("PrintMapPost");

		return SUCCESS;
	}
}