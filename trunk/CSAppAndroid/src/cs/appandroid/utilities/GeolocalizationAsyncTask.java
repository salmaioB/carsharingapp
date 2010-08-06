package cs.appandroid.utilities;

import cs.appandroid.controller.IdentificationController;
import cs.webservice.CustomerAccountsWS;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class GeolocalizationAsyncTask extends AsyncTask<String, Integer, String>
{
	private Context context;
	
	public GeolocalizationAsyncTask(Context context)
	{
		this.context = context;
	}
	
	protected String doInBackground(String... string)
	{
		double geolocLongitude = 2.239;
		double geolocLatitude  = 3.678;
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccountWS.saveCustomerLocation(IdentificationController.getUserLoggedId(context), geolocLongitude, geolocLatitude);		
		
		return "teub";
	}

    protected void onProgressUpdate(Integer... progress) {
    	Log.d(">>>>>>>>>>>>>Test update: ", "blablabla");
    }

    protected void onPostExecute() {
    	Log.d(">>>>>>>>>>>>>Test execute: ", "blablabla");
    }
}