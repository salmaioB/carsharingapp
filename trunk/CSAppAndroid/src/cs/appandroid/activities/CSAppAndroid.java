package cs.appandroid.activities;

import java.io.IOException;

import cs.appandroid.controller.IdentificationUtilities;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class CSAppAndroid extends TabActivity implements OnClickListener, OnTabChangeListener
{	
	private Button connectionButton;
	private TabHost tabHost;
	
	Intent myProfileIntent;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    // Connection button
	    connectionButton = (Button)findViewById(R.id.connection_button);
	    connectionButton.setOnClickListener(this);
	    
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
	    spec = tabHost.newTabSpec("artists").setIndicator("Artists",
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
	    
//	    Log.v("number of tab", Integer.toString(tabHost.getTabWidget().getChildCount()));
//	    
//	    for(int i=0; i<tabHost.getTabWidget().getChildCount(); i++)
//	    {
//	    	Log.v("tab", Integer.toString(i));
//	    	tabHost.getTabWidget().getChildAt(i).setOnClickListener(this);
//	    }
	}

	@Override
	public void onClick(View v)
	{
//		tabHost.getCurrentTab()
		
		Log.v("az", "azza");
		
		if(v == connectionButton)
		{
			// Send params to show the identification screen
			myProfileIntent.putExtra("identification", true);
			tabHost.setCurrentTab(3);
			
			IdentificationUtilities.userIsLogged(getBaseContext());
		}
	}
	
	@Override
	public void onTabChanged(String tabId)
	{
	    Log.d("re", "OnTabChanged");
	}
}
