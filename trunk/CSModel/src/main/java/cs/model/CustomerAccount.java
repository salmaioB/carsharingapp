package cs.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerAccount implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String customerLogin;
	private String customerPassword;
	private String lastName;
	private String firstName;
	private Double geolocLongitude;
	private Double geolocLatitude;
	private String emailAddress;
	private String address;
	private String ville;
	private Integer cp;
	private Integer phone;
	private Integer mobile;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerLogin() {
		if(customerLogin == null) customerLogin ="";
		return customerLogin;
	}

	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}	
	
	public String getCustomerPassword() {
		if(customerPassword == null) customerPassword ="";
		return customerPassword;
	}
	
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public String getLastName() {
		if(lastName == null) lastName ="";
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
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
	
	public String getEmailAddress() {
		if(emailAddress == null) emailAddress ="";
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Integer getPhone() {
		return phone;
	}
	
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	public Integer getMobile() {
		return mobile;
	}
	
	public void setMobile(Integer mobile) {
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
