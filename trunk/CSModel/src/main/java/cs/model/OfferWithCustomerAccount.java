package cs.model;

import java.util.Date;

public class OfferWithCustomerAccount
{
	private Integer id;
	private Integer gender;
	private String lastName;
	private String firstName;
	
	private String startingCity;
	private String finishingCity;
	private Integer numberOfPlaceRemaining;
	private Float pricePerPassenger;

    private Date datetimeStarted;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
    
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getStartingCity() {
		return startingCity;
	}

	public void setStartingCity(String startingCity) {
		this.startingCity = startingCity;
	}

	public String getFinishingCity() {
		return finishingCity;
	}

	public void setFinishingCity(String finishingCity) {
		this.finishingCity = finishingCity;
	}
	
	public Float getPricePerPassenger() {
		return pricePerPassenger;
	}
	
	public void setPricePerPassenger(Float pricePerPassenger) {
		this.pricePerPassenger = pricePerPassenger;
	}

	public Integer getNumberOfPlaceRemaining() {
		return numberOfPlaceRemaining;
	}

	public void setNumberOfPlaceRemaining(Integer numberOfPlaceRemaining) {
		this.numberOfPlaceRemaining = numberOfPlaceRemaining;
	}

	public Date getDatetimeStarted() {
		return datetimeStarted;
	}

	public void setDatetimeStarted(Date datetimeStarted) {
		this.datetimeStarted = datetimeStarted;
	}
}
