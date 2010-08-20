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