package cs.model;

public class Route
{
	private Integer id;
	private Integer idOffer;	
	private Integer idPassenger;
	private String startingAddress;
	private String startingCity;
	private String finishingAddress;
	private String finishingCity;
	private Float price;
	private Float conversionRateToEuro;
	private String currencyCode;
	
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
	
	public String getStartingCity() {
		return startingCity;
	}
	
	public void setStartingCity(String startingCity) {
		this.startingCity = startingCity;
	}

	public String getFinishingAddress() {
		return finishingAddress;
	}
	
	public void setFinishingAddress(String finishingAddress) {
		this.finishingAddress = finishingAddress;
	}
	
	public String getFinishingCity() {
		return finishingCity;
	}
	
	public void setFinishingCity(String finishingCity) {
		this.finishingCity = finishingCity;
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
