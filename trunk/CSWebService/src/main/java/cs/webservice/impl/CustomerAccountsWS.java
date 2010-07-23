package cs.webservice.impl;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.CustomerAccountsDAO;
import cs.model.CustomerAccounts;

public class CustomerAccountsWS  extends ActionSupport {
	/**
	 * the Object (example User use) component the BeerWS are transmit automaticaly by JSON  
	 */
	private CustomerAccounts use;
	private Integer id;
	

	public CustomerAccounts getUse() {
		return use;
	}
	public void setUse(CustomerAccounts use) {
		this.use = use;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}



	//private String /*CustomerAccounts*/ use;
	/**
	 * Getteur and Setteur
	 * @return
	 */

	public String execute() throws Exception {
		System.out.println("call execute");
		
		System.out.println("id : "+id);

		CustomerAccountsDAO cad = new CustomerAccountsDAO();
		use = cad.load(id);
		
		System.out.println(use.getCustomerLogin());
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