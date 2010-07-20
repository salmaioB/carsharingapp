package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;
import cs.model.User;

public class UserWS  extends ActionSupport {
	/**
	 * the Object (example User use) component the BeerWS are transmit automaticaly by JSON  
	 */
	private User use;
	private User use2;
	/**
	 * Getteur and Setteur
	 * @return
	 */
	public User getUse() {
		return use;
	}
	public User getUse2() {
		return use2;
	}
	public void setUse2(User use2) {
		this.use2 = use2;
	}
	public void setUse(User use) {
		this.use = use;
	}
	public String fonc() {
		  System.out.println("call execute");
		  use = new User();
		  use.setName("nameshjghfgjs");
	      return SUCCESS;
	}
  public String execute() throws Exception {
	  System.out.println("call execute");
	  use = new User();
	  use2 = new User();
	  use.setName("namesss");
	  use2.setName("namesss");
      return SUCCESS;
  }

}  