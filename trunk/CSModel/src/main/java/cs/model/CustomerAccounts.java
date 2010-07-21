package cs.model;

import java.util.Date;

public class CustomerAccounts
{
	  private Integer id;
	  private String login;
	  private String password;
	  private String lastName;
	  private String firstName;
	  private String emailAddress;
	  private Integer phone;
	  private Integer mobile;
	  private Integer type;
	  private Integer idVehicule;
	  private Integer acceptAnimals;
	  private Integer acceptRadio;
	  private Integer acceptSmoker;
	  private Integer acceptToDiscuss;
	  private Integer acceptToMakeADetour;
	  private Date DatetimeRegistration;
	  private Date datetimeLastConnection;
	  private Date datetimeLastOfferCreated;
	  
	  public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
		return DatetimeRegistration;
	}
	public void setDatetimeRegistration(Date datetimeRegistration) {
		DatetimeRegistration = datetimeRegistration;
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
	private Date datetimeLastCarSharing;
}
