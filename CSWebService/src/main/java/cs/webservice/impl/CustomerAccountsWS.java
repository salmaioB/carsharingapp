package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;
import cs.model.CustomerAccounts;

public class CustomerAccountsWS  extends ActionSupport {
	/**
	 * the Object (example User use) component the BeerWS are transmit automaticaly by JSON  
	 */
	private CustomerAccounts use;
	private CustomerAccounts use2;
	/**
	 * Getteur and Setteur
	 * @return
	 */
	public CustomerAccounts getUse() {
		return use;
	}
	public CustomerAccounts getUse2() {
		return use2;
	}
	public void setUse2(CustomerAccounts use2) {
		this.use2 = use2;
	}
	public void setUse(CustomerAccounts use) {
		this.use = use;
	}
	public String fonc() {
		  System.out.println("call execute");
		  use = new CustomerAccounts();
		  use.setCustomerLogin("customerlogin");
	      return SUCCESS;
	}
	public String execute() throws Exception {
		System.out.println("call execute");
		use = new CustomerAccounts();
		use2 = new CustomerAccounts();
		use.setCustomerLogin("login");
		use2.setCustomerLogin("login");
		return SUCCESS;
  }
}  