package com.appweb.action.ajax;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PostEtape2 extends Action
{
	private String villeStartPost;
	private String villeStopPost;
	private String hours;
	private java.util.Date datepickerPost;
	private java.util.Date dateHours;
	private String minutes;
	private String hour;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDatepickerPost() {
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(simpleFormat.format(datepickerPost));	
		return simpleFormat.format(datepickerPost);
		//return DateFormat.getDateInstance( DateFormat.MEDIUM ).format( datepickerPost ) ;
		//return datepickerPost;
	}
	public void setDatepickerPost(java.util.Date datepickerPost) {
		this.datepickerPost = datepickerPost;
	}
	public java.util.Date getDateHours() {
		return dateHours;
	}
	public void setDateHours(java.util.Date dateHours) {
		this.dateHours = dateHours;
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
		return SUCCESS;
	}
}