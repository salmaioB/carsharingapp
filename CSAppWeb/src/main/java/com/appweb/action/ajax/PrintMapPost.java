package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PrintMapPost extends Action
{
	private String villeStartPost;
	private String villeStopPost;
	
	public String getVilleStartPost() {
		return villeStartPost;
	}
	public void setVilleStartPost(String villeStartPost) {
		this.villeStartPost = villeStartPost;
	}
	public String getVilleStopPost() {
		return villeStopPost;
	}
	public void setVilleStopPost(String villeStopPost) {
		this.villeStopPost = villeStopPost;
	}

	public String execute() throws Exception
	{
		System.out.println("PrintMapPost");

		return SUCCESS;
	}
}