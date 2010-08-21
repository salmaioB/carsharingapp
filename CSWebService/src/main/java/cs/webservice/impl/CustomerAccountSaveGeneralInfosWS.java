package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.engine.action.CustomerAccountEngineAction;

public class CustomerAccountSaveGeneralInfosWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String lastName;
	private String firstName;
	private String emailAddress;
	private String mobile;
	
	/**
	 * Getter and Setter
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String execute() throws Exception
	{		
		CustomerAccountEngineAction customerAccountEngineAction = new CustomerAccountEngineAction();
		customerAccountEngineAction.saveCustomerGeneralInfos(id, lastName, firstName, emailAddress, mobile);
		
		return SUCCESS;
	}
}
