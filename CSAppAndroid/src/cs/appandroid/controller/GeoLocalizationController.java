package cs.appandroid.controller;

import cs.appandroid.utilities.GeoLocalizationListener;
import cs.webservice.CustomerAccountsWS;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.widget.TextView;


public class GeoLocalizationController
{
	LocationManager objgps;
	GeoLocalizationListener objlistener;
	
	public GeoLocalizationController(Context context)
	{		
		// Utilisation  de la class LocationManager pour le gps 
		objgps = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		objlistener = new GeoLocalizationListener();
	}
	
	public void saveUserLocation(TextView testGeoloc, Context context)
	{
//		Criteria crit = new Criteria();
//		crit.setAccuracy(Criteria.ACCURACY_FINE);
//		String provider = objgps.getBestProvider(crit, true);
//		Location location = objgps.getLastKnownLocation(provider);
		
		//testGeoloc.setText(Double.toString(location.getLongitude()));
		
//		Log.v("aze", Double.toString(location.getLongitude()));
//		
//		double geolocLongitude = location.getLongitude();
//		double geolocLatitude  = location.getLatitude();
		
		double geolocLongitude = 2.239;
		double geolocLatitude  = 3.678;
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccountWS.saveCustomerLocation(IdentificationController.getUserLoggedId(context), geolocLongitude, geolocLatitude);
		
//		objgps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 
//									  0,
//									  0,
//									  objlistener);
	}
}
