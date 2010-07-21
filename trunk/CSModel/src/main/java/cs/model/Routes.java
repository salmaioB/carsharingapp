package cs.model;

public class Routes
{
	private Integer idRoute;
	private Integer idOffer;	
	private Integer idPassenger;
	private String startingAddress;
	private String finishingAddress;
	private Float price;
	private Float conversionRateToEuro;
	private String currencyCode;

	
	public Integer getIdRoute() {
		return idRoute;
	}
	
	public void setIdRoute(Integer idRoute) {
		this.idRoute = idRoute;
	}
	
	public Integer getIdOffer() {
		return idOffer;
	}
	
	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}
	
	public Integer getIdPassenger() {
		return idPassenger;
	}
	
	public void setIdPassenger(Integer idPassenger) {
		this.idPassenger = idPassenger;
	}
	
	public String getStartingAddress() {
		return startingAddress;
	}
	
	public void setStartingAddress(String startingAddress) {
		this.startingAddress = startingAddress;
	}

	public String getFinishingAddress() {
		return finishingAddress;
	}
	
	public void setFinishingAddress(String finishingAddress) {
		this.finishingAddress = finishingAddress;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getConversionRateToEuro() {
		return conversionRateToEuro;
	}
	
	public void setConversionRateToEuro(Float conversionRateToEuro) {
		this.conversionRateToEuro = conversionRateToEuro;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
