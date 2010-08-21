package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.spring.SpringEngine;

public class CustomerAccountSavePreferencesWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer acceptAnimals;
	private Integer acceptRadio;
	private Integer acceptSmoker;
	private Integer acceptToDiscuss;
	private Integer acceptToMakeADetour;
	
	/**
	 * Getter and Setter
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAcceptAnimals() {
		return acceptAnimals;
	}
	
	public void setAcceptAnimals(Integer acceptAnimals) {
		this.acceptAnimals = acceptAnimals;
	}
	
	public Integer getAcceptRadio() {
		return acceptRadio;
	}
	
	public void setAcceptRadio(Integer acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	
	public Integer getAcceptSmoker() {
		return acceptSmoker;
	}
	
	public void setAcceptSmoker(Integer acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	
	public Integer getAcceptToDiscuss() {
		return acceptToDiscuss;
	}
	
	public void setAcceptToDiscuss(Integer acceptToDiscuss) {
		this.acceptToDiscuss = acceptToDiscuss;
	}
	
	public Integer getAcceptToMakeADetour() {
		return acceptToMakeADetour;
	}
	
	public void setAcceptToMakeADetour(Integer acceptToMakeADetour) {
		this.acceptToMakeADetour = acceptToMakeADetour;
	}
	
	public String execute() throws Exception
	{
		CustomerAccountEngineAction customerAccountEngineAction = SpringEngine.getSpring().getCustomerAccountEngineAction();//new CustomerAccountEngineAction();
		customerAccountEngineAction.saveCustomerPreferences(id, acceptAnimals, acceptRadio, acceptSmoker, acceptToDiscuss, acceptToMakeADetour);
		
		return SUCCESS;
	}
}
