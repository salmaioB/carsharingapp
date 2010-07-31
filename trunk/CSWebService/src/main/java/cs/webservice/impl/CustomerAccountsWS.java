package cs.webservice.impl;


import com.opensymphony.xwork2.ActionSupport;
import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class CustomerAccountsWS  extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private CustomerAccount customerAccount;
	
	private Integer id;
	private String customerLogin;
	private String customerPassword;
	

	/**
	 * Getter and Setter
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCustomerLogin() {
		return customerLogin;
	}

	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}
	
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	public String execute() throws Exception
	{
		System.out.println("call execute");
		
		System.out.println("id : "+id);
		System.out.println("customerLogin : " + customerLogin);
		System.out.println("customerPassword : " + customerPassword);

		CustomerAccountEngineAction customerAccountEngine = new CustomerAccountEngineAction();
		
		if(id != null)
			customerAccount = customerAccountEngine.load(id);
		else
			customerAccount = customerAccountEngine.identification(customerLogin, customerPassword);
		
		//System.out.println(customerAccount.getCustomerLogin());
		
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