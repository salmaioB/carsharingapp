package com.appweb.action.ajax;

import java.text.SimpleDateFormat;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PrintMapPost extends Action
{
	private String villeStartPost;
	private String villeStopPost;
	private String role;
	private String minutes;
	private String hour;
	private String addressStartPost;
	private String addressStopPost;
	private Integer nbPassagerPost;
	private java.util.Date datepickerPost;
	
	private String villepassage1Post;
	private String villepassage2Post;
	private String villepassage3Post;
	private String villepassage4Post;
	private String villepassage5Post;
	private String villepassage6Post;
	private String villepassage7Post;
	private String villepassage8Post;
	
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
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
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

	public String execute() throws Exception
	{
		System.out.println("PrintMapPost");
		System.out.println("villepassage1Post : " + villepassage1Post);
		return SUCCESS;
	}
}