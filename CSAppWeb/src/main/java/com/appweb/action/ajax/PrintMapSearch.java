package com.appweb.action.ajax;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.appweb.Action;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.OfferDAO;
import cs.dao.dao.OffersToCustomerAccountsDAO;
import cs.dao.dao.RouteDAO;
import cs.dao.spring.SpringDAO;
import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;
import cs.model.Offer;
import cs.model.Route;

public class PrintMapSearch extends Action
{
	private Integer idTrip;

	private List<CustomerAccount> customerAccountPartcipate;
	
	private String villeStartPost;
	private String villeStopPost;
	private String role;
	private String minutes;
	private String hour;
	private String addressStartPost;
	private String addressStopPost;
	private Integer nbPassagerPost;
	private Date datepickerPost;
	
	private String description;
	
	private Boolean isOfferPassenger;
	
	private Integer gender;
	private String firstName;
	private String lastName;
	
	private Integer idCustomer;
	
	public Boolean getIsOfferPassenger()
	{
		return isOfferPassenger;
	}
	public void setIsOfferPassenger(Boolean isOfferPassenger)
	{
		this.isOfferPassenger = isOfferPassenger;
	}
	
	public Boolean isLoging()
	{
		return super.isLoging();
	}
	public List<CustomerAccount> getCustomerAccountPartcipate() {
		return customerAccountPartcipate;
	}

	public void setCustomerAccountPartcipate(
			List<CustomerAccount> customerAccountPartcipate) {
		this.customerAccountPartcipate = customerAccountPartcipate;
	}
	
	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	private String villepassage1Post;
	private String villepassage2Post;
	private String villepassage3Post;
	private String villepassage4Post;
	private String villepassage5Post;
	private String villepassage6Post;
	private String villepassage7Post;
	private String villepassage8Post;
	
	private String priceTrip1;
	private String priceTrip2;
	private String priceTrip3;
	private String priceTrip4;
	private String priceTrip5;
	private String priceTrip6;
	private String priceTrip7;
	private String priceTrip8;
	private String priceTripStop;
	private String priceTotal;
	
	private Integer acceptAnimals;
	private Integer acceptRadio;
	private Integer acceptSmoker;
	private Integer acceptToDiscuss;
	
	public Boolean isCreatorOffer()
	{
		OffersToCustomerAccountsDAO offersToCustomerAccountsDAO = SpringDAO.getSpring().getOffersToCustomerAccountsDAO();
		return offersToCustomerAccountsDAO.isCreatorOffer(idTrip, getCustomerAccount().getId() );
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
	private Integer acceptToMakeADetour;
	
	public PrintMapSearch()
	{
		System.out.println("Construct PrintMapSearch");
		acceptAnimals = 0;
		acceptRadio = 0;
		acceptSmoker = 0;
		acceptToDiscuss = 0;
		acceptToMakeADetour = 0;
		
		priceTrip1 = "0";
		priceTrip2 = "0";
		priceTrip3 = "0";
		priceTrip4 = "0";
		priceTrip5 = "0";
		priceTrip6 = "0";
		priceTrip7 = "0";
		priceTrip8 = "0";
		priceTripStop = "0";
		priceTotal = "0";
	}
	
	public String getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(String priceTotal) {
		if(priceTotal != null) this.priceTotal = priceTotal;
	}
	
	public String getPriceTripStop() {
		return priceTripStop;
	}
	public void setPriceTripStop(String priceTripStop) {
		if(priceTripStop != null)  this.priceTripStop = priceTripStop;
	}
	public String getPriceTrip1() {
		return priceTrip1;
	}
	public void setPriceTrip1(String priceTrip1) {
		if(priceTrip1 != null)  this.priceTrip1 = priceTrip1;
	}
	public String getPriceTrip2() {
		return priceTrip2;
	}
	public void setPriceTrip2(String priceTrip2) {
		if(priceTrip2 != null)  this.priceTrip2 = priceTrip2;
	}
	public String getPriceTrip3() {
		return priceTrip3;
	}
	public void setPriceTrip3(String priceTrip3) {
		if(priceTrip3 != null)  this.priceTrip3 = priceTrip3;
	}
	public String getPriceTrip4() {
		return priceTrip4;
	}
	public void setPriceTrip4(String priceTrip4) {
		if(priceTrip4 != null)  this.priceTrip4 = priceTrip4;
	}
	public String getPriceTrip5() {
		return priceTrip5;
	}
	public void setPriceTrip5(String priceTrip5) {
		if(priceTrip1 != null)  
		this.priceTrip5 = priceTrip5;
	}
	public String getPriceTrip6() {
		return priceTrip6;
	}
	public void setPriceTrip6(String priceTrip6) {
		if(priceTrip1 != null)  this.priceTrip6 = priceTrip6;
	}
	public String getPriceTrip7() {
		return priceTrip7;
	}
	public void setPriceTrip7(String priceTrip7) {
		this.priceTrip7 = priceTrip7;
	}
	public String getPriceTrip8() {
		return priceTrip8;
	}
	public void setPriceTrip8(String priceTrip8) {
		if(priceTrip8 != null)  this.priceTrip8 = priceTrip8;
	}

	public String getVillepassage1Post() {
		if(villepassage1Post==null) villepassage1Post ="";
		return villepassage1Post;
	}
	public void setVillepassage1Post(String villepassage1Post) {
		this.villepassage1Post = villepassage1Post;
	}
	public String getVillepassage2Post() {
		if(villepassage2Post==null) villepassage2Post ="";
		return villepassage2Post;
	}
	public void setVillepassage2Post(String villepassage2Post) {
		this.villepassage2Post = villepassage2Post;
	}
	public String getVillepassage3Post() {
		if(villepassage3Post==null) villepassage3Post ="";
		return villepassage3Post;
	}
	public void setVillepassage3Post(String villepassage3Post) {
		this.villepassage3Post = villepassage3Post;
	}
	public String getVillepassage4Post() {
		if(villepassage4Post==null) villepassage4Post ="";
		return villepassage4Post;
	}
	public void setVillepassage4Post(String villepassage4Post) {
		this.villepassage4Post = villepassage4Post;
	}
	public String getVillepassage5Post() {
		if(villepassage5Post==null) villepassage5Post ="";
		return villepassage5Post;
	}
	public void setVillepassage5Post(String villepassage5Post) {
		this.villepassage5Post = villepassage5Post;
	}
	public String getVillepassage6Post() {
		if(villepassage6Post==null) villepassage6Post ="";
		return villepassage6Post;
	}
	public void setVillepassage6Post(String villepassage6Post) {
		this.villepassage6Post = villepassage6Post;
	}
	public String getVillepassage7Post() {
		if(villepassage7Post==null) villepassage7Post ="";
		return villepassage7Post;
	}
	public void setVillepassage7Post(String villepassage7Post) {
		this.villepassage7Post = villepassage7Post;
	}
	public String getVillepassage8Post() {
		if(villepassage8Post==null) villepassage8Post ="";
		return villepassage8Post;
	}
	public void setVillepassage8Post(String villepassage8Post) {
		this.villepassage8Post = villepassage8Post;
	}
	public String getDatepickerPost() {
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(simpleFormat.format(datepickerPost));	
		return simpleFormat.format(datepickerPost);
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getAddressStartPost() {
		return addressStartPost;
	}
	public void setAddressStartPost(String addressStartPost) {
		this.addressStartPost = addressStartPost;
	}
	public String getAddressStopPost() {
		return addressStopPost;
	}
	public void setAddressStopPost(String addressStopPost) {
		this.addressStopPost = addressStopPost;
	}
	public Integer getNbPassagerPost() {
		return nbPassagerPost;
	}
	public void setNbPassagerPost(Integer nbPassagerPost) {
		this.nbPassagerPost = nbPassagerPost;
	}
	public void setDatepickerPost(java.util.Date datepickerPost) {
		this.datepickerPost = datepickerPost;
	}
	public String getVilleStartPost() {
		return villeStartPost;
	}
	public void setVilleStartPost(String villeStartPost) {
		this.villeStartPost = villeStartPost;
	}
	public String getVilleStopPost() {
		return villeStopPost;
	}
	public void setVilleStopPost(String villeStopPost) {
		this.villeStopPost = villeStopPost;
	}

	public Integer getIdTrip() {
		return idTrip;
	}
	public void setIdTrip(Integer idTrip) {
		this.idTrip = idTrip;
	}
	
	public void setDataTrip(Integer id, String startingCity, String startingAddress, String finishingCity, String finishingAddress, String price )
	{
		if(id==0){
			villeStartPost = startingCity;
			addressStartPost  = startingAddress;
			priceTrip1 = price;
		}
		if(id==1 )
		{
			villepassage1Post = startingCity;
			priceTrip2 = price;	
		}
		if(id==2 )
		{
			villepassage2Post = startingCity;
			priceTrip3 = price;
		}
		if(id==3)
		{
			villepassage3Post = startingCity;
			priceTrip4 = price;	
		}
		if(id==4)
		{
			villepassage4Post = startingCity;
			priceTrip5 = price;
		}
		if(id==5 ){
			villepassage5Post = startingCity;
			priceTrip6 = price;	
		}
		if(id==6){
			villepassage6Post = startingCity;
			priceTrip7 = price;
		}
		if(id==7 ){
			villepassage7Post = startingCity;
			priceTrip8 = price;
		}
		if(id==8){
			villepassage8Post = startingCity;	
		}
	}
	public String execute() throws Exception
	{
		System.out.println("PrintMapSearch");
		//Get DAO
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		CustomerAccountDAO customerAccountDAO = SpringDAO.getSpring().getCustomerAccountDAO();
		RouteDAO routeDAO = SpringDAO.getSpring().getRouteDAO();
		OffersToCustomerAccountsDAO offersToCustomerAccountsDAO = SpringDAO.getSpring().getOffersToCustomerAccountsDAO();
		
		//Offer
		Offer offer = offerDAO.load(idTrip);
		setDescription(offer.getDescription());
		setNbPassagerPost( offer.getNumberOfPlaceRemaining() );
		setDatepickerPost(offer.getDatetimeStarted());
		setHour(String.valueOf( offer.getDatetimeStarted().getHours() ) );
		setMinutes(String.valueOf( offer.getDatetimeStarted().getMinutes() ) );
		offersToCustomerAccountsDAO.getCreatorOffer(idTrip);
	
		//Customer
		CustomerAccount customerAccount = customerAccountDAO.load( offersToCustomerAccountsDAO.getCreatorOffer(idTrip).getId()  );
	
		acceptAnimals = customerAccount.getAcceptAnimals();
		acceptRadio = customerAccount.getAcceptRadio();
		acceptSmoker = customerAccount.getAcceptSmoker();
		acceptToDiscuss = customerAccount.getAcceptToDiscuss();
		acceptToMakeADetour = customerAccount.getAcceptToMakeADetour();
		gender = customerAccount.getGender();
		firstName = customerAccount.getFirstName();
		lastName = customerAccount.getLastName();
		idCustomer = customerAccount.getId(); 
		
		//Routes
		List<Route> routes = routeDAO.loadRoutes( offer.getId() );

		System.out.println("routes.size() : " + routes.size());
		Float priceAll = 0f;
		
		for(int i = 0; i <= routes.size() -1 ; i++)
		{
			Route route = routes.get(i);
			System.out.println("route.getStartingAddress() : " + route.getStartingAddress() +" - getFinishingAddress() : "+route.getFinishingAddress());
			System.out.println("route.getStartingAddress() : " + route.getStartingCity() +" - getFinishingCity() : "+route.getFinishingCity() );
			System.out.println("route.getPrice() : " + route.getPrice());
			priceAll += route.getPrice();
			setDataTrip(i, route.getStartingCity(),route.getStartingAddress(), route.getFinishingCity(), route.getFinishingAddress(), route.getPrice().toString() );
		}
		System.out.println("priceAll FIN --:" + priceAll);

		if(routes.get(routes.size()-1)!= null)
		{
			villeStopPost = routes.get(routes.size()-1).getFinishingCity();
			addressStopPost  = routes.get(routes.size()-1).getFinishingAddress();
			priceTripStop = routes.get(routes.size()-1).getPrice().toString();
			System.out.println("priceTripStop : " + priceTripStop);
			priceAll += routes.get(routes.size()-1).getPrice();
		}
		System.out.println("priceAll FIN:" + priceAll);

		priceTotal = priceAll.toString();
		System.out.println("idTrip : " + idTrip);
		if( getCustomerAccount().getId() != null)
		{	
			//Chargement des participants
			setCustomerAccountPartcipate( offersToCustomerAccountsDAO.loadListCustomerParticipateOffer(idTrip,getCustomerAccount().getId() ) );
		}
		
		//setCustomerAccountPartcipate( offersToCustomerAccountsDAO.loadListCustomerParticipateOffer(idTrip) );
		CustomerAccount ca = offersToCustomerAccountsDAO.getCreatorOffer(idTrip);
		System.out.println("createur de l'offre : " + ca.getCustomerLogin() );
		setIsOfferPassenger( offersToCustomerAccountsDAO.isOfferPassenger(idTrip,ca.getId()) );
		
		System.out.println("FINNNNNNNNNNN");
		return SUCCESS;
	}
}