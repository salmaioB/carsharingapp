package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.spring.SpringEngine;

public class CustomerAccountSaveNewPasswordWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private Integer idCustomerAccount;
	private String currentPassword;
	private String newPassword;
	private Integer saveNewPasswordStatusMessage;
	
	
	/**
	 * Getter and Setter
	 */
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public Integer getSaveNewPasswordStatusMessage() {
		return saveNewPasswordStatusMessage;
	}
	
	public void setSaveNewPasswordStatusMessage(Integer saveNewPasswordStatusMessage) {
		this.saveNewPasswordStatusMessage = saveNewPasswordStatusMessage;
	}
	
	
	public String execute() throws Exception
	{		
		CustomerAccountEngineAction customerAccountEngineAction = SpringEngine.getSpring().getCustomerAccountEngineAction();//new CustomerAccountEngineAction();
		saveNewPasswordStatusMessage = customerAccountEngineAction.saveCustomerNewPassword(idCustomerAccount, currentPassword, newPassword);
		
		return SUCCESS;
	}
}
