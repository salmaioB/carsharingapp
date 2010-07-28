package cs.webservice.impl;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.CustomerAccountDAO;
import cs.model.CustomerAccount;

public class CustomerAccountsWS  extends ActionSupport
{
	private CustomerAccount customerAccount;
	private Integer id;
	

	/**
	 * Getter and Setter
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CustomerAccount getUse() {
		return customerAccount;
	}
	
	public void setUse(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String execute() throws Exception
	{
		System.out.println("call execute");
		
		System.out.println("id : "+id);

		CustomerAccountDAO cad = new CustomerAccountDAO();
		customerAccount = cad.load(id);
		
		System.out.println(customerAccount.getCustomerLogin());
		/*
		CustomerAccounts user = new CustomerAccounts();
		
		user.setCustomerLogin("login");
		user.setCustomerPassword("password");
		user.setCustomerType(0);
		
		user.setDatetimeLastCarSharing(null);
		user.setDatetimeLastConnection(null);
		user.setDatetimeLastOfferCreated(null);
		user.setDatetimeRegistration(null);
		
		user.setAcceptAnimals(0);
		user.setAcceptRadio(0);
		user.setAcceptSmoker(0);
		user.setAcceptToDiscuss(0);
		user.setAcceptToMakeADetour(0);
		
		oos = new ObjectOutputStream() {
		};
		oos.writeObject(user);
		
		ObjectInputStream ois = new ObjectInputStream(){ };
		
		CustomerAccounts user2 = (CustomerAccounts) ois.readObject();
		System.out.println(oos.toString());
		*/
		System.out.println("Fin du call execute");
		return SUCCESS;
  }
}  