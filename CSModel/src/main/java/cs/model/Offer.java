package cs.model;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Offer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idOfferType;
	private Integer idDriver;
	private String title;
	private String description;
	private String startingCity;
	private String finishingCity;
	private Integer numberOfPlaceInitial;
	private Integer numberOfPlaceRemaining;
	private Float pricePerPassenger;
	private Date datetimeStarted;
	private Date datetimeEnded;
	
	public Offer()
	{
		
	}
	
	public Offer(JSONObject jsonObjectOffer) throws JSONException
	{
		if(!jsonObjectOffer.isNull("id"))
			id          		   = jsonObjectOffer.getInt("id");
		
		if(!jsonObjectOffer.isNull("idOfferType"))
			idOfferType 		   = jsonObjectOffer.getInt("idOfferType");
		
		if(!jsonObjectOffer.isNull("idDriver"))
			idDriver    		   = jsonObjectOffer.getInt("idDriver");
		
		if(!jsonObjectOffer.isNull("title"))
			title       		   = jsonObjectOffer.getString("title");
		
		if(!jsonObjectOffer.isNull("description"))
			description 	 	   = jsonObjectOffer.getString("description");
		
		if(!jsonObjectOffer.isNull("startingCity"))
			startingCity           = jsonObjectOffer.getString("startingCity");
		
		if(!jsonObjectOffer.isNull("finishingCity"))
			finishingCity          = jsonObjectOffer.getString("finishingCity");
		
		if(!jsonObjectOffer.isNull("numberOfPlaceInitial"))
			numberOfPlaceInitial   = jsonObjectOffer.getInt("numberOfPlaceInitial");
		
		if(!jsonObjectOffer.isNull("numberOfPlaceRemaining"))
		numberOfPlaceRemaining = jsonObjectOffer.getInt("numberOfPlaceRemaining");
		
		// Ugly part
		if(!jsonObjectOffer.isNull("pricePerPassenger"))
			pricePerPassenger      = Float.parseFloat(jsonObjectOffer.getString("pricePerPassenger"));
		
		//dateStarted            = jsonObjectOffer.getInt("");
		//dateEnded			   = jsonObjectOffer.getInt("");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOfferType() {
		return idOfferType;
	}
	
	public void setIdOfferType(Integer idOfferType) {
		this.idOfferType = idOfferType;
	}
	
	public Integer getIdDriver() {
		return idDriver;
	}
	
	public void setIdDriver(Integer idDriver) {
		this.idDriver = idDriver;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
	
	public Integer getNumberOfPlaceInitial() {
		return numberOfPlaceInitial;
	}
	
	public void setNumberOfPlaceInitial(Integer numberOfPlaceInitial) {
		this.numberOfPlaceInitial = numberOfPlaceInitial;
	}
	
	public Integer getNumberOfPlaceRemaining() {
		return numberOfPlaceRemaining;
	}
	
	public void setNumberOfPlaceRemaining(Integer numberOfPlaceRemaining) {
		this.numberOfPlaceRemaining = numberOfPlaceRemaining;
	}
	
	public Float getPricePerPassenger() {
		return pricePerPassenger;
	}
	
	public void setPricePerPassenger(Float pricePerPassenger) {
		this.pricePerPassenger = pricePerPassenger;
	}
	
	public Date getDatetimeStarted() {
		return datetimeStarted;
	}
	
	public void setDatetimeStarted(Date datetimeStarted) {
		this.datetimeStarted = datetimeStarted;
	}
	
	public Date getDatetimeEnded() {
		return datetimeEnded;
	}
	
	public void setDatetimeEnded(Date datetimeEnded) {
		this.datetimeEnded = datetimeEnded;
	}
}
