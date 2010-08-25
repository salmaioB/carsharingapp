package cs.model;

public class OffersToCustomerAccount
{ 
	private Integer id;
	private Integer idOffer;
	private Integer idCustomerAccount;
	private Integer isDriver;
	private Integer isOfferCreator;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOffer() {
		return idOffer;
	}
	
	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
	
	public Integer getIsDriver() {
		return isDriver;
	}

	public void setIsDriver(Integer isDriver) {
		this.isDriver = isDriver;
	}
	
	public Integer getIsOfferCreator() {
		return isOfferCreator;
	}

	public void setIsOfferCreator(Integer isOfferCreator) {
		this.isOfferCreator = isOfferCreator;
	}
}
