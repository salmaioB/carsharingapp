package com.appweb.action.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.appweb.Action;

public class PostEtape2 extends Action
{
	private String villeStartPost;
	private String villeStopPost;
	private String addressStartPost;
	private String addressStopPost;
	private Integer nbPassagerPost;
	private String hours;
	private java.util.Date datepickerPost;
	private String minutes;
	private String hour;
	private String role;
	
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
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Integer priceTotal) {
		this.priceTotal = priceTotal;
	}
	public Integer getPriceTripStop() {
		return priceTripStop;
	}
	public void setPriceTripStop(Integer priceTripStop) {
		this.priceTripStop = priceTripStop;
	}
	public Integer getPriceTrip1() {
		return priceTrip1;
	}
	public void setPriceTrip1(Integer priceTrip1) {
		this.priceTrip1 = priceTrip1;
	}
	public Integer getPriceTrip2() {
		return priceTrip2;
	}
	public void setPriceTrip2(Integer priceTrip2) {
		this.priceTrip2 = priceTrip2;
	}
	public Integer getPriceTrip3() {
		return priceTrip3;
	}
	public void setPriceTrip3(Integer priceTrip3) {
		this.priceTrip3 = priceTrip3;
	}
	public Integer getPriceTrip4() {
		return priceTrip4;
	}
	public void setPriceTrip4(Integer priceTrip4) {
		this.priceTrip4 = priceTrip4;
	}
	public Integer getPriceTrip5() {
		return priceTrip5;
	}
	public void setPriceTrip5(Integer priceTrip5) {
		this.priceTrip5 = priceTrip5;
	}
	public Integer getPriceTrip6() {
		return priceTrip6;
	}
	public void setPriceTrip6(Integer priceTrip6) {
		this.priceTrip6 = priceTrip6;
	}
	public Integer getPriceTrip7() {
		return priceTrip7;
	}
	public void setPriceTrip7(Integer priceTrip7) {
		this.priceTrip7 = priceTrip7;
	}
	public Integer getPriceTrip8() {
		return priceTrip8;
	}
	public void setPriceTrip8(Integer priceTrip8) {
		this.priceTrip8 = priceTrip8;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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

	public String getDatepickerPost() {
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(simpleFormat.format(datepickerPost));	
		return simpleFormat.format(datepickerPost);
		//return DateFormat.getDateInstance( DateFormat.MEDIUM ).format( datepickerPost ) ;
		//return datepickerPost;
	}
	public void setDatepickerPost(java.util.Date datepickerPost) {
		this.datepickerPost = datepickerPost;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
		Integer position = hours.lastIndexOf(":");
		System.out.println("-------------------------------- : " + position);
		hour = hours.substring(0,position);
		minutes = hours.substring(position+1,hours.length() );
		System.out.println("--------------------------------");
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
	
	public PostEtape2()
    {
    	System.out.println("Construct PostEtape2");
    }


	public String execute() throws Exception
	{
		System.out.println("Check PostEtape2");
		System.out.println("hours : " + hours);
		System.out.println("datepickerPost : " + datepickerPost);
		System.out.println("role : " + role);
		System.out.println("addressStartPost : " + addressStartPost);
		System.out.println("addressStopPost : " + addressStopPost);
		System.out.println("villeStartPost : " + villeStartPost);
		System.out.println("villeStopPost : " + villeStopPost);

		return SUCCESS;
	}
}