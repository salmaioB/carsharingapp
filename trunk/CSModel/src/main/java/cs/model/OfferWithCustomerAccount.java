package cs.model;

import java.util.Date;

public class OfferWithCustomerAccount
{
	Integer id;
	String lastName;
	String firstName;
	
	Integer numberOfPlaceRemaining;
	Float pricePerPassenger;

    Date datetimeStarted;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
