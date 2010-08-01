package cs.appandroid;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class CSAppAndroid extends TabActivity
{	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main2);
	    
	    // Resource object to get Drawables
	    Resources res = getResources();
	    
	    // The activity TabHost
	    TabHost tabHost = getTabHost();
	    
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
	    
	    /**
	     * TO BE DELETED
	     */
	    // Create an Intent to launch messages activity for the tab
	    intent = new Intent().setClass(this, Identification.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("identification").setIndicator("Identification",
	                                                       	 	 res.getDrawable(R.drawable.tab_search_offers))
	                                                       	 	 .setContent(intent);
	    tabHost.addTab(spec);
	}
}
