package cs.model;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Offer
{
	private Integer id;
	private Integer idOfferType;
	private Integer idDriver;
	private String title;
	private String description;
	private Integer numberOfPlaceInitial;
	private Integer numberOfPlaceRemaining;
	private Float pricePerPassenger;
	private Date dateStarted;
	private Date dateEnded;
	
	public Offer()
	{
		
	}
	
	public Offer(JSONObject jsonObjectOffer) throws JSONException
	{
		id          		   = jsonObjectOffer.getInt("id");
		idOfferType 		   = jsonObjectOffer.getInt("idOfferType");
		idDriver    		   = jsonObjectOffer.getInt("idDriver");
		title       		   = jsonObjectOffer.getString("title");
		description 	 	   = jsonObjectOffer.getString("description");
		numberOfPlaceInitial   = jsonObjectOffer.getInt("numberOfPlaceInitial");
		numberOfPlaceRemaining = jsonObjectOffer.getInt("numberOfPlaceRemaining");
		
		// Ugly part
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

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
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
	
	public Date getDateStarted() {
		return dateStarted;
	}
	
	public void setStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	public Date getDateEnded() {
		return dateEnded;
	}
	
	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}
}
