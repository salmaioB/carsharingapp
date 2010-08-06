package cs.appandroid.controller;

import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class MyTimerTask extends TimerTask
{
	private Handler myHandler;
	private Context context;
	private GeoLocalizationController geoLocalizationController;
	
	private TextView testGeoloc;
	
	public MyTimerTask(Handler myHandler, Context context, TextView test)
	{
		this.myHandler = myHandler;
		this.context = context;
		geoLocalizationController = new GeoLocalizationController(context);
		
		this.testGeoloc = test;
	}
	
	public void run()
	{
		myHandler.post(new Runnable()
        {
        	public void run()
        	{
        		if(IdentificationController.userIsLogged(context))
	    		{
	    			Log.v("Save user location", "done");
	    			
	    			geoLocalizationController.saveUserLocation(testGeoloc, context);
	    		}
        	}
        });
    }
}