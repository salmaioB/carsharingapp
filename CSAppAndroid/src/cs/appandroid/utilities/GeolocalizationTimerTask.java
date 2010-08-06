package cs.appandroid.utilities;

import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;

public class GeolocalizationTimerTask extends TimerTask
{
	private Context context;
	private Handler geolocalizationHandler;
	
	public GeolocalizationTimerTask(Handler geolocalizationHandler, Context context)
	{
		this.context   				= context;
		this.geolocalizationHandler = geolocalizationHandler;
	}
	
    public void run()
    {
    	geolocalizationHandler.post(new Runnable()
        { 
            public void run() { 
                new GeolocalizationAsyncTask(context).execute("");
            }
        });
    }
}