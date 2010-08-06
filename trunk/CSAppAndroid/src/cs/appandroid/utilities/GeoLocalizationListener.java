package cs.appandroid.utilities;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

public class GeoLocalizationListener implements LocationListener
{
    public void onProviderDisabled(String provider) { 
        // TODO Auto-generated method stub 
    } 


    public void onProviderEnabled(String provider) { 
        // TODO Auto-generated method stub 
    } 


    public void onStatusChanged(String provider, int status, Bundle extras) { 
        // TODO Auto-generated method stub 
    } 


   public void onLocationChanged(Location location)
   {
	   Log.v("Coordonnées: ", "les coordonnées ont changé !!");
	   
	   System.out.println(location.getLongitude());
	   
	   Log.v("Longitude: ", Double.toString(location.getLongitude()));
	   Log.v("Latitude: ", Double.toString(location.getLatitude()));
   }
}
