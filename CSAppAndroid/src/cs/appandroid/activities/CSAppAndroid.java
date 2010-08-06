package cs.appandroid.activities;

import java.util.Timer;

import cs.appandroid.controller.IdentificationController;
import cs.appandroid.utilities.GeolocalizationTimerTask;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class CSAppAndroid extends TabActivity implements OnClickListener, OnTabChangeListener
{	
	private Button connectionButton;
	private TabHost tabHost;
	
	private Intent myProfileIntent;
	
	private Handler geolocalizationHandler;
	private Timer geolocalizationTimer;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		displayMainScreen();
	}
   
	public void displayMainScreen()
	{
		setContentView(R.layout.main);
	    
	    // Connection button
	    connectionButton = (Button)findViewById(R.id.connection_button);
	    connectionButton.setOnClickListener(this);
	    
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    	connectionButton.setVisibility(View.INVISIBLE);
	    else
	    	connectionButton.setText("Connexion");
	    
	    // TabHost
	    createApplicationTabHost();
	    
	    // Geolocalization timer
	    createGeolocalizationTimer();
	}
	
	public void createApplicationTabHost()
	{
	    // Resource object to get Drawables
	    Resources res = getResources();
	    
	    // The activity TabHost
	    tabHost = getTabHost();
	    
	    // Reusable TabSpec for each tab
	    TabHost.TabSpec spec;
	    
	    // Reusable Intent for each tab
	    Intent intent;
	    
	    // Create an Intent to launch an search offers activity for the tab
	    intent = new Intent().setClass(this, SearchOffers.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("searchoffers").setIndicator("Recherche",
	                                                      	   res.getDrawable(R.drawable.tab_search_offers))
	                                                      	   .setContent(intent);
	    
	    tabHost.addTab(spec);
	    
	    // Create an Intent to launch an offer activity for the tab
	    intent = new Intent().setClass(this, AddOffer.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("addoffer").setIndicator("Ajouter une offer",
	                                                       res.getDrawable(R.drawable.tab_search_offers))
	                                                       .setContent(intent);
	    tabHost.addTab(spec);
	    
	    // Create an Intent to launch "routes list" activity for the tab
//	    intent = new Intent().setClass(this, AddOffer.class);
//	    
//	    // Initialize a TabSpec for each tab and add it to the TabHost
//	    spec = tabHost.newTabSpec("addoffer").setIndicator("Ajouter une offer",
//	                                                       res.getDrawable(R.drawable.tab_search_offers))
//	                                                       .setContent(intent);
//	    tabHost.addTab(spec);
	    
	    // Create an Intent to launch messages activity for the tab
	    intent = new Intent().setClass(this, MyMessages.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("mymessages").setIndicator("Mes messages",
	                                                       	 res.getDrawable(R.drawable.tab_search_offers))
	                                                         .setContent(intent);
	    tabHost.addTab(spec);
	    
	    // Specific intent declare like an attribute
	    // To send params to MyProfile activity
	    myProfileIntent = new Intent().setClass(this, MyProfile.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("myprofile").setIndicator("Mon profil",
	                                                       	res.getDrawable(R.drawable.tab_search_offers))
	                                                       	.setContent(myProfileIntent);
	    
	    tabHost.addTab(spec);
	    
	    tabHost.setOnTabChangedListener(this);
	}
	
	public void createGeolocalizationTimer()
	{
		geolocalizationTimer = new Timer();
		geolocalizationHandler = new Handler();
	    
	    int geolocalizationTimerDelay  = 5000;
	    int geolocalizationTimerPeriod = 10000; 
	    
		geolocalizationTimer.schedule(new GeolocalizationTimerTask(geolocalizationHandler, getBaseContext()), geolocalizationTimerDelay, geolocalizationTimerPeriod); 
	}
	
	@Override
	public void onClick(View v)
	{		
		if(v == connectionButton)
		{   
			if(tabHost.getCurrentTabTag() == "myprofile" && IdentificationController.userIsLogged(getBaseContext()))
			{
				IdentificationController.disconnectUser(getBaseContext());
				tabHost.setCurrentTab(0);
			}
			else
			{
				// Send params to show the identification screen
				myProfileIntent.putExtra("identification", true);
				tabHost.setCurrentTab(3);				
			}
		}
	}
	
	@Override
	public void onTabChanged(String tabId)
	{
	    Log.d("TabChanged", "OnTabChanged");
	    	    
	    if(tabId != "searchoffers")
	    {
	    	if(!IdentificationController.userIsLogged(getBaseContext()))
	    	{
				tabHost.setCurrentTab(3);
				connectionButton.setText("Connexion");
	    	}
	    	else
	    	{
	    		Log.d("user", "User is logged");
	    		
	    		if(tabId == "myprofile")
	    		{					
					tabHost.setCurrentTab(3);
	    			
	    			connectionButton.setText("Déconnexion");
	    			connectionButton.setVisibility(View.VISIBLE);
	    		}
	    		else
	    			connectionButton.setVisibility(View.INVISIBLE);
	    	}
	    }
	    else
	    {
	    	if(IdentificationController.userIsLogged(getBaseContext()))
	    		connectionButton.setVisibility(View.INVISIBLE);
	    	else
	    	{
	    		connectionButton.setText("Connexion");
	    		connectionButton.setVisibility(View.VISIBLE);
	    	}
	    }
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
		// Create a MenuInflater to instantiate a xml menu into an object menu
        MenuInflater inflater = getMenuInflater();
        
        // Instantiate the xml menu specified into the object menu
        inflater.inflate(R.layout.menu, menu);
 
        return true;
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
          	case R.id.option:	
             				  return true;
          	case R.id.quitter: finish();
             				   return true;
    	}
    	return false;
    }
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		
		geolocalizationTimer.cancel();
	}
}
