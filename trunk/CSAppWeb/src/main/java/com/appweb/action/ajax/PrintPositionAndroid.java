package com.appweb.action.ajax;

import com.appweb.Action;

import cs.engine.action.CustomerAccountEngineAction;
import cs.model.CustomerAccount;

public class PrintPositionAndroid extends Action
{
	private Double geolocLongitude;
	private Double geolocLatitude;
	
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
	
	public PrintPositionAndroid()
    {
    	System.out.println("Construct PrintMapPost");
    }


	public String execute() throws Exception
	{
		System.out.println("PrintMapPost");
		geolocLongitude = getCustomerAccount().getGeolocLatitude();
		geolocLatitude = getCustomerAccount().getGeolocLongitude();;
		return SUCCESS;
	}
}