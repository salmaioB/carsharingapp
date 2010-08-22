package cs.model;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomerAccount implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String customerLogin;
	private String customerPassword;
	private Integer gender;
	private String lastName;
	private String firstName;
	private Double geolocLongitude;
	private Double geolocLatitude;
	private String emailAddress;
	
	private String address;
	private String country;
	private String zipCode;
	
	private String phone;
	private String mobile;
	private Integer customerType;
	private Integer idVehicule;
	private Integer acceptAnimals;
	private Integer acceptRadio;
	private Integer acceptSmoker;
	private Integer acceptToDiscuss;
	private Integer acceptToMakeADetour;
	private Date datetimeRegistration;
	private Date datetimeLastConnection;
	private Date datetimeLastOfferCreated;
	private Date datetimeLastCarSharing;

	
	public CustomerAccount()
	{
		
	}
	
	public CustomerAccount(JSONObject jsonObjectCustomerAccount) throws JSONException
	{
		id 			  	   		 = jsonObjectCustomerAccount.getInt("id");
		customerLogin 	   		 = jsonObjectCustomerAccount.getString("customerLogin");
		customerPassword   		 = jsonObjectCustomerAccount.getString("customerPassword");
		lastName           		 = jsonObjectCustomerAccount.getString("lastName");
		firstName          		 = jsonObjectCustomerAccount.getString("firstName");
		geolocLongitude    		 = jsonObjectCustomerAccount.getDouble("geolocLongitude");
		geolocLatitude     		 = jsonObjectCustomerAccount.getDouble("geolocLatitude");
		emailAddress       		 = jsonObjectCustomerAccount.getString("emailAddress");
		
		//address            		 = jsonObjectCustomerAccount.getString("");
		//country              		 = jsonObjectCustomerAccount.getString("");
		//zipCode				   	 = jsonObjectCustomerAccount.getString("");
		
		phone     		   		 = jsonObjectCustomerAccount.getString("phone");
		mobile 			   		 = jsonObjectCustomerAccount.getString("mobile");
		customerType       		 = jsonObjectCustomerAccount.getInt("customerType");
		idVehicule         		 = jsonObjectCustomerAccount.getInt("idVehicule");
		acceptAnimals      		 = jsonObjectCustomerAccount.getInt("acceptAnimals");
		acceptRadio        		 = jsonObjectCustomerAccount.getInt("acceptRadio");
		acceptSmoker       		 = jsonObjectCustomerAccount.getInt("acceptSmoker");
		acceptToDiscuss    		 = jsonObjectCustomerAccount.getInt("acceptToDiscuss");
		acceptToMakeADetour      = jsonObjectCustomerAccount.getInt("acceptToMakeADetour");
		
		//datetimeRegistration     = jsonObjectCustomerAccount.getString("");
		//datetimeLastConnection   = jsonObjectCustomerAccount.getString("");
		//datetimeLastOfferCreated = jsonObjectCustomerAccount.getString("");
		//datetimeLastCarSharing   = jsonObjectCustomerAccount.getString("");
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	// Ugly part
	public String getCustomerLogin() {
		if(customerLogin == null) customerLogin = "";
		return customerLogin;
	}

	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}	
	
	// Ugly part
	public String getCustomerPassword() {
		if(customerPassword == null) customerPassword = "";
		return customerPassword;
	}
	
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	// Ugly part
	public String getLastName() {
		if(lastName == null) lastName ="";
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Ugly part
	public String getFirstName() {
		if(firstName == null) firstName ="";
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Double getGeolocLongitude() {
		return geolocLongitude;
	}
	
	public void setGeolocLongitude(Double geolocLongitude) {
		this.geolocLongitude = geolocLongitude;
	}
	
	public Double getGeolocLatitude() {
		return geolocLatitude;
	}
	
	public void setGeolocLatitude(Double geolocLatitude) {
		this.geolocLatitude = geolocLatitude;
	}
	
	// Ugly part
	public String getEmailAddress() {
		if(emailAddress == null)
			emailAddress = "";
		
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Integer getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}
	
	public Integer getIdVehicule() {
		return idVehicule;
	}
	
	public void setIdVehicule(Integer idVehicule) {
		this.idVehicule = idVehicule;
	}
	
	public Integer getAcceptAnimals() {
		return acceptAnimals;
	}
	
	public void setAcceptAnimals(Integer acceptAnimals) {
		this.acceptAnimals = acceptAnimals;
	}
	
	public void setAcceptAnimals(Boolean acceptAnimals) {
		if(acceptAnimals==false) this.acceptAnimals = 0;
		else this.acceptAnimals = 1;
	}
	
	public Integer getAcceptRadio() {
		return acceptRadio;
	}
	
	public void setAcceptRadio(Integer acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	
	public void setAcceptRadio(Boolean acceptRadio) {
		if(acceptRadio==false) this.acceptRadio = 0;
		else this.acceptRadio = 1;
	}
	
	public Integer getAcceptSmoker() {
		return acceptSmoker;
	}
	
	public void setAcceptSmoker(Integer acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	
	public void setAcceptSomker(Boolean acceptSmoker) {
		if(acceptSmoker==false) this.acceptSmoker = 0;
		else this.acceptSmoker = 1;
	}
	
	public Integer getAcceptToDiscuss() {
		return acceptToDiscuss;
	}
	
	public void setAcceptToDiscuss(Integer acceptToDiscuss) {
		this.acceptToDiscuss = acceptToDiscuss;
	}
	
	public void setAcceptToDiscuss(Boolean acceptToDiscuss) {
		if(acceptToDiscuss==false) this.acceptToDiscuss = 0;
		else this.acceptToDiscuss = 1;
	}
	
	public Integer getAcceptToMakeADetour() {
		return acceptToMakeADetour;
	}
	
	public void setAcceptToMakeADetour(Integer acceptToMakeADetour) {
		this.acceptToMakeADetour = acceptToMakeADetour;
	}
	
	public void setAcceptToMakeADetour(Boolean acceptToMakeADetour) {
		if(acceptToMakeADetour==false) this.acceptToMakeADetour = 0;
		else this.acceptToMakeADetour = 1;
	}
	
	public Date getDatetimeRegistration() {
		return datetimeRegistration;
	}
	
	public void setDatetimeRegistration(Date datetimeRegistration) {
		this.datetimeRegistration = datetimeRegistration;
	}
	
	public Date getDatetimeLastConnection() {
		return datetimeLastConnection;
	}
	
	public void setDatetimeLastConnection(Date datetimeLastConnection) {
		this.datetimeLastConnection = datetimeLastConnection;
	}
	
	public Date getDatetimeLastOfferCreated() {
		return datetimeLastOfferCreated;
	}
	
	public void setDatetimeLastOfferCreated(Date datetimeLastOfferCreated) {
		this.datetimeLastOfferCreated = datetimeLastOfferCreated;
	}
	
	public Date getDatetimeLastCarSharing() {
		return datetimeLastCarSharing;
	}
	
	public void setDatetimeLastCarSharing(Date datetimeLastCarSharing) {
		this.datetimeLastCarSharing = datetimeLastCarSharing;
	}
}
