package cs.appandroid.utilities;

import android.content.Context;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.util.Log;

public class GeolocalizationAsyncTask extends AsyncTask<String, Integer, String>
{
	private Context context;
	LocationManager objgps;
	
	public GeolocalizationAsyncTask(Context context)
	{
		this.context = context;
		this.objgps  = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
	}
	
	protected String doInBackground(String... string)
	{		
//		if(IdentificationController.userIsLogged(context))
//		{			
//			Criteria crit = new Criteria();
//			crit.setAccuracy(Criteria.ACCURACY_FINE);
//			String provider = objgps.getBestProvider(crit, true);
//			Location location = objgps.getLastKnownLocation(provider);
//			
//			double geolocLongitude = location.getLongitude();
//			double geolocLatitude  = location.getLatitude();
//		
//			CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
//			customerAccountWS.saveCustomerLocation(IdentificationController.getUserLoggedId(context), geolocLongitude, geolocLatitude);		
//		}
		
		return "teub";
	}

    protected void onProgressUpdate(Integer... progress) {
    	Log.d(">>>>>>>>>>>>>Test update: ", "blablabla");
    }

    protected void onPostExecute() {
    	Log.d(">>>>>>>>>>>>>Test execute: ", "blablabla");
    }
}