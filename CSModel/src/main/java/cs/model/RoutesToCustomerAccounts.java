package cs.model;

public class RoutesToCustomerAccounts
{
	private Integer id;
	private Integer idRoute;
	private Integer idCustomerAccount;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRoute() {
		return idRoute;
	}
	
	public void setIdRoute(Integer idRoute) {
		this.idRoute = idRoute;
	}
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
}
