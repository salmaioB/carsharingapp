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
	private String emailAddress;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerLogin() {
		return customerLogin;
	}

	public void setCustomerLogin(String customerLogin) {
		this.customerLogin = customerLogin;
	}	
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
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
	
	public String getEmailAddress() {
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
	
	public Integer getAcceptRadio() {
		return acceptRadio;
	}
	
	public void setAcceptRadio(Integer acceptRadio) {
		this.acceptRadio = acceptRadio;
	}
	
	public Integer getAcceptSmoker() {
		return acceptSmoker;
	}
	
	public void setAcceptSmoker(Integer acceptSmoker) {
		this.acceptSmoker = acceptSmoker;
	}
	
	public Integer getAcceptToDiscuss() {
		return acceptToDiscuss;
	}
	
	public void setAcceptToDiscuss(Integer acceptToDiscuss) {
		this.acceptToDiscuss = acceptToDiscuss;
	}
	
	public Integer getAcceptToMakeADetour() {
		return acceptToMakeADetour;
	}
	
	public void setAcceptToMakeADetour(Integer acceptToMakeADetour) {
		this.acceptToMakeADetour = acceptToMakeADetour;
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
