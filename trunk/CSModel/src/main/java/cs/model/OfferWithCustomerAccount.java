package cs.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;


public class OfferWithCustomerAccount implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id;
//  private Integer gender;
//  private String lastName;
//  private String firstName;
//  private String mobile;
//	private Integer acceptAnimals;
//  private Integer acceptRadio;
//	private Integer acceptSmoker;
//  private Integer acceptToDiscuss;
//  private Integer acceptToMakeADetour;
//	private Date datetimeRegistration;
	
	private CustomerAccount customerAccount;
    
	private String startingCity;
    private String finishingCity;
    private Integer numberOfPlaceRemaining;
    private Float pricePerPassenger;

    private Date datetimeStarted;
        
    
    public OfferWithCustomerAccount()
    {
    	
    }
    
    public OfferWithCustomerAccount(JSONObject jsonObjectOfferWithCustomerAccount) throws JSONException, ParseException
    {
    	id        	           = jsonObjectOfferWithCustomerAccount.getInt("id");
//		gender    	           = jsonObjectOfferWithCustomerAccount.getInt("gender");
//		firstName 	           = jsonObjectOfferWithCustomerAccount.getString("firstName");
//		lastName               = jsonObjectOfferWithCustomerAccount.getString("lastName");
//		mobile                 = jsonObjectOfferWithCustomerAccount.getString("mobile");
//		acceptAnimals          = jsonObjectOfferWithCustomerAccount.getInt("acceptAnimals");
//		acceptRadio            = jsonObjectOfferWithCustomerAccount.getInt("acceptRadio");
//		acceptSmoker           = jsonObjectOfferWithCustomerAccount.getInt("acceptSmoker");
//		acceptToDiscuss        = jsonObjectOfferWithCustomerAccount.getInt("acceptToDiscuss");
//		acceptToMakeADetour    = jsonObjectOfferWithCustomerAccount.getInt("acceptToMakeADetour");				
//         
//		SimpleDateFormat datetimeRegistrationFormatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
//		datetimeRegistration   = datetimeRegistrationFormatter.parse(jsonObjectOfferWithCustomerAccount.getString("datetimeRegistration"));
        
    	customerAccount        = new CustomerAccount(jsonObjectOfferWithCustomerAccount.getJSONObject("customerAccount"));
    	
        startingCity 		   = jsonObjectOfferWithCustomerAccount.getString("startingCity");
        finishingCity          = jsonObjectOfferWithCustomerAccount.getString("finishingCity");                
		
		numberOfPlaceRemaining = jsonObjectOfferWithCustomerAccount.getInt("numberOfPlaceRemaining");
		pricePerPassenger      = Float.parseFloat(jsonObjectOfferWithCustomerAccount.getString("pricePerPassenger"));

		// Ugly part
		SimpleDateFormat datetimeStartedFormatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		datetimeStarted        = datetimeStartedFormatter.parse(jsonObjectOfferWithCustomerAccount.getString("datetimeStarted"));
    }
    
    public Integer getId() {
            return id;
    }
    
    public void setId(Integer id) {
            this.id = id;
    }
//
//    public Integer getGender() {
//            return gender;
//    }
//    
//    public void setGender(Integer gender) {
//            this.gender = gender;
//    }
//    
//    public String getLastName() {
//            return lastName;
//    }
//    
//    public void setLastName(String lastName) {
//            this.lastName = lastName;
//    }
//    
//    public String getFirstName() {
//            return firstName;
//    }
//    
//    public void setFirstName(String firstName) {
//            this.firstName = firstName;
//    }
//    
//    public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//    
//    public Integer getAcceptAnimals() {
//		return acceptAnimals;
//	}
//
//	public void setAcceptAnimals(Integer acceptAnimals) {
//		this.acceptAnimals = acceptAnimals;
//	}
//
//	public Integer getAcceptRadio() {
//		return acceptRadio;
//	}
//
//	public void setAcceptRadio(Integer acceptRadio) {
//		this.acceptRadio = acceptRadio;
//	}
//
//	public Integer getAcceptSmoker() {
//		return acceptSmoker;
//	}
//
//	public void setAcceptSmoker(Integer acceptSmoker) {
//		this.acceptSmoker = acceptSmoker;
//	}
//
//	public Integer getAcceptToDiscuss() {
//		return acceptToDiscuss;
//	}
//
//	public void setAcceptToDiscuss(Integer acceptToDiscuss) {
//		this.acceptToDiscuss = acceptToDiscuss;
//	}
//
//	public Integer getAcceptToMakeADetour() {
//		return acceptToMakeADetour;
//	}
//
//	public void setAcceptToMakeADetour(Integer acceptToMakeADetour) {
//		this.acceptToMakeADetour = acceptToMakeADetour;
//	}
//    
////	public Date getDatetimeRegistration() {
////		return datetimeRegistration;
////	}
//	
//	/**
//     * Ugly part
//     * TODO: return a date object
//     */
//    public String getDatetimeRegistration()
//    {
//    	SimpleDateFormat simpleFormatDatetimeRegistration = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
//    	
//    	return simpleFormatDatetimeRegistration.format(datetimeRegistration);
//	}
//    
//    /**
//     * Ugly part
//     * TO BE DELETED
//     */
//	public String getDatetimeRegistrationToDisplay()
//	{
//		SimpleDateFormat simpleFormatDatetimeRegistration = new SimpleDateFormat("dd MMMM yyyy", new Locale("fr"));
//    	
//    	return simpleFormatDatetimeRegistration.format(datetimeRegistration);
//	}
//
//	public void setDatetimeRegistration(Date datetimeRegistration) {
//		this.datetimeRegistration = datetimeRegistration;
//	}

    
    public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
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

    /**
     * Ugly part
     * TODO: return a date object
     */
    public String getDatetimeStarted()
    {
    	SimpleDateFormat simpleFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    	System.out.println(simpleFormat.format(datetimeStarted));
    	
    	return simpleFormat.format(datetimeStarted);
    }
    
    /**
     * Ugly part
     * TO BE DELETED
     */
    public String getDatetimeStartedToDisplay()
    {
    	SimpleDateFormat simpleFormat = new SimpleDateFormat("EEE dd MMM - HH:mm", new Locale("fr"));
    	
    	return simpleFormat.format(datetimeStarted);
    }

    public void setDatetimeStarted(Date datetimeStarted) {
            this.datetimeStarted = datetimeStarted;
    }
}
