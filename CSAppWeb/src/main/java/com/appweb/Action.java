package com.appweb;

import com.opensymphony.xwork2.ActionSupport;

import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.action.OfferEngineAction;
import cs.engine.translation.TranslationEngine;
import cs.model.CustomerAccount;
import cs.model.Offer;

public class Action extends ActionSupport
{
	private TranslationEngine tr;
	
	public TranslationEngine getTr() {
		return tr;
	}
	public void setTr(TranslationEngine tr) {
		this.tr = tr;
	}

	public Action()
	{
		tr = new TranslationEngine();
	}
}
