package com.appweb.action.ajax;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appweb.Action;

import cs.dao.dao.OfferDAO;
import cs.dao.dao.OffersToCustomerAccountsDAO;
import cs.dao.spring.SpringDAO;
import cs.model.Offer;
import cs.model.OffersToCustomerAccount;
import cs.model.Route;

public class SaveOffer extends Action
{
	private String villeStartPost;
	private String villeStopPost;
	private Integer role;
	private String minutes;
	private String hour;
	private String addressStartPost;
	private String addressStopPost;
	private Integer nbPassagerPost;
	private Date datepickerPost;
	
	private String villepassage1Post;
	private String villepassage2Post;
	private String villepassage3Post;
	private String villepassage4Post;
	private String villepassage5Post;
	private String villepassage6Post;
	private String villepassage7Post;
	private String villepassage8Post;
	
	private Integer priceTrip1;
	private Integer priceTrip2;
	private Integer priceTrip3;
	private Integer priceTrip4;
	private Integer priceTrip5;
	private Integer priceTrip6;
	private Integer priceTrip7;
	private Integer priceTrip8;
	private Integer priceTripStop;
	private Integer priceTotal;
	
	private String description;
	
	public String getDescription() {
		if(description == null) description="";
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public SaveOffer()
	{
	}
	
	public Integer getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Integer priceTotal) {
		if(priceTotal != null) this.priceTotal = priceTotal;
	}
	
	public Integer getPriceTripStop() {
		if(priceTripStop==null) priceTripStop=0;
		return priceTripStop;
	}
	public void setPriceTripStop(Integer priceTripStop) {
		if(priceTripStop != null)  this.priceTripStop = priceTripStop;
	}
	public Integer getPriceTrip1() {
		if(priceTrip1==null) priceTrip1 = 0;
		return priceTrip1;
	}
	public void setPriceTrip1(Integer priceTrip1) {
		if(priceTrip1 != null)  this.priceTrip1 = priceTrip1;
	}
	public Integer getPriceTrip2() {
		if(priceTrip2==null) priceTrip2=0;
		return priceTrip2;
	}
	public void setPriceTrip2(Integer priceTrip2) {
		if(priceTrip2 != null)  this.priceTrip2 = priceTrip2;
	}
	public Integer getPriceTrip3() {
		if(priceTrip3==null) priceTrip3 = 0;
		return priceTrip3;
	}
	public void setPriceTrip3(Integer priceTrip3) {
		if(priceTrip3 != null)  this.priceTrip3 = priceTrip3;
	}
	public Integer getPriceTrip4() {
		if(priceTrip4==null) priceTrip4=0;
		return priceTrip4;
	}
	public void setPriceTrip4(Integer priceTrip4) {
		if(priceTrip4 != null)  this.priceTrip4 = priceTrip4;
	}
	public Integer getPriceTrip5() {
		if(priceTrip5==null) priceTrip5 =0;
		return priceTrip5;
	}
	public void setPriceTrip5(Integer priceTrip5) {
		if(priceTrip1 != null)  
		this.priceTrip5 = priceTrip5;
	}
	public Integer getPriceTrip6() {
		if(priceTrip6==null) priceTrip6=0;
		return priceTrip6;
	}
	public void setPriceTrip6(Integer priceTrip6) {
		if(priceTrip1 != null)  this.priceTrip6 = priceTrip6;
	}
	public Integer getPriceTrip7() {
		if(priceTrip7==null) priceTrip7= 0;
		return priceTrip7;
	}
	public void setPriceTrip7(Integer priceTrip7) {
		this.priceTrip7 = priceTrip7;
	}
	public Integer getPriceTrip8() {
		if(priceTrip8==null) priceTrip8=0;
		return priceTrip8;
	}
	public void setPriceTrip8(Integer priceTrip8) {
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
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
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
		if(addressStartPost == null )addressStartPost="";
		return addressStartPost;
	}
	public void setAddressStartPost(String addressStartPost) {
		this.addressStartPost = addressStartPost;
	}
	public String getAddressStopPost() {
		if(addressStopPost == null) addressStopPost ="";
		return addressStopPost;
	}
	public void setAddressStopPost(String addressStopPost) {
		this.addressStopPost = addressStopPost;
	}
	public Integer getNbPassagerPost() {
		if(nbPassagerPost == null) nbPassagerPost =0;
		return nbPassagerPost;
	}
	public void setNbPassagerPost(Integer nbPassagerPost) {
		this.nbPassagerPost = nbPassagerPost;
	}
	public void setDatepickerPost(java.util.Date datepickerPost) {
		this.datepickerPost = datepickerPost;
	}
	public void setDatepickerPost(String datepickerPost) {
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			this.datepickerPost = simpleFormat.parse(datepickerPost);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	public String getVilleStartPost() {
		if(villeStartPost == null) {
			System.out.println("villeStartPost is null");
			villeStartPost ="";
		}
		return villeStartPost;
	}
	public void setVilleStartPost(String villeStartPost) {
		this.villeStartPost = villeStartPost;
	}
	public String getVilleStopPost() {
		if(villeStopPost==null) villeStopPost="";
		return villeStopPost;
	}
	public void setVilleStopPost(String villeStopPost) {
		this.villeStopPost = villeStopPost;
	}

	public List< String[] > initRoutes()
	{
		System.out.println("start initRoutes");
		List< String[] > routeName = new ArrayList< String[] > ();
		
		if( !getVilleStartPost().equals("") ){ String map [] = new String[3]; map[0]=getVilleStartPost(); map[1]=addressStartPost; map[2]=""; routeName.add(map); }
		if(!getVillepassage1Post().equals("")){ String [] map  = new String[3]; map[0]=getVillepassage1Post(); map[1]=""; map[2]=getPriceTrip1().toString(); routeName.add(map); }
		if(!getVillepassage2Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage2Post(); map[1]=""; map[2]=getPriceTrip2().toString(); routeName.add(map); }
		if(!getVillepassage3Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage3Post(); map[1]=""; map[2]=getPriceTrip3().toString(); routeName.add(map); }
		if(!getVillepassage4Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage4Post(); map[1]=""; map[2]=getPriceTrip4().toString(); routeName.add(map); }
		if(!getVillepassage5Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage5Post(); map[1]=""; map[2]=getPriceTrip5().toString(); routeName.add(map); }
		if(!getVillepassage6Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage6Post(); map[1]=""; map[2]=getPriceTrip6().toString(); routeName.add(map); }
		if(!getVillepassage7Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage7Post(); map[1]=""; map[2]=getPriceTrip7().toString(); routeName.add(map); }
		if(!getVillepassage8Post().equals("")){ String map [] = new String[3]; map[0]=getVillepassage8Post(); map[1]=""; map[2]=getPriceTrip8().toString(); routeName.add(map); }
		if(!getVilleStopPost().equals("")){ String map [] = new String [3]; map[0]=getVilleStopPost(); map[1]=addressStopPost; map[2]=getPriceTripStop().toString(); routeName.add(map); }
		
		System.out.println("end initRoutes");
		return routeName;
	}
	public Integer calculPriceTotal()
	{
		return  getPriceTrip1() + getPriceTrip2() + getPriceTrip3() + getPriceTrip4() + getPriceTrip5() + getPriceTrip6() + getPriceTrip7() + getPriceTrip8() + getPriceTripStop();
	}
	public String execute() throws Exception
	{
		System.out.println("Save Offer");
		System.out.println("getVilleStartPost() : " + getVilleStartPost() );
		priceTotal = calculPriceTotal();
		
		Offer offer = new Offer();
		OfferDAO offerDAO = SpringDAO.getSpring().getOfferDAO();
		OffersToCustomerAccountsDAO offersToCustomerAccountsDAO = SpringDAO.getSpring().getOffersToCustomerAccountsDAO();
		System.out.println("after load DAO !");
		
		offer.setDatetimeStarted(datepickerPost);
		offer.setNumberOfPlaceInitial(getNbPassagerPost());
		offer.setPricePerPassenger(Float.intBitsToFloat( getPriceTotal() ));
		offer.setNumberOfPlaceRemaining(getNbPassagerPost());
		offer.setDescription(getDescription());
		offer.setStartingCity(villeStartPost);
		offer.setFinishingCity(villeStopPost);
		
		System.out.println("after set offer !");
		
		List<Route> routes = new ArrayList<Route>();
		
		System.out.println("after new list !");
		
		List< String[] > listRoutes = initRoutes();
		
		System.out.println("before iterator");
		for(int i =0; i < listRoutes.size() -1 ; i++)
		{
			Route route = new Route();
			route.setStartingCity(listRoutes.get(i)[0]);
			route.setStartingAddress(listRoutes.get(i)[1]);
			route.setFinishingAddress(listRoutes.get(i+1)[1]);
			route.setFinishingCity(listRoutes.get(i+1)[0]);
			System.out.println("listRoutes.get(i+1)[2] ) : " +  listRoutes.get(i+1)[2] );
			route.setPrice( Float.valueOf( listRoutes.get(i+1)[2] ) );

			route.setCurrencyCode("");
			route.setConversionRateToEuro(Float.intBitsToFloat(1) );
			route.setRouteOrder(i+1);
			
			routes.add(route);
		}
		System.out.println("after iterator");

		System.out.println("start to call DAO for saveOfferWithRoutes ");
		offerDAO.saveOfferWithRoutes(offer, routes, getCustomerAccount().getId(), getRole());
		
		//jointure avec l'utilisateur créant l'offre
//		OffersToCustomerAccount offerToCustomerAccount = new OffersToCustomerAccount();
//		
//		offerToCustomerAccount.setIdCustomerAccount(getCustomerAccount().getId());
//		offerToCustomerAccount.setIdOffer(offer.getId());
//		offerToCustomerAccount.setIsDriver(getRole() );
//		offerToCustomerAccount.setIsOfferCreator(1);
//		
//		offersToCustomerAccountsDAO.save(offerToCustomerAccount);
		System.out.println("finish to call DAO for saveOfferWithRoutes ");
		
		return SUCCESS;
	}
}