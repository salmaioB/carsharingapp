package cs.appandroid.activitiesgroup;

import java.util.ArrayList;

import cs.appandroid.activities.MyRoutes;
import cs.appandroid.controller.IdentificationController;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MyRoutesGroup extends ActivityGroup
{
	public static MyRoutesGroup myRoutesGroup;
	private ArrayList<View> historyMyRoutesGroup;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    myRoutesGroup = this;
	    historyMyRoutesGroup = new ArrayList<View>();
	    
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {
	    	Intent intentMyRoutesView = new Intent(this, MyRoutes.class);
	    	
	    	// Start the root activity within the group and get its view
	    	View MyRoutesView = getLocalActivityManager().startActivity("My routes view",
	    											 	 intentMyRoutesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    											 	 .getDecorView();
	    
	    	// Replace the view of this ActivityGroup
	    	replaceView(MyRoutesView);
	    }
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {
	    	Intent intentMyRoutesView = new Intent(this, MyRoutes.class);
	    
	    	// Start the root activity within the group and get its view
	    	View MyRoutesView = getLocalActivityManager().startActivity("My routes view",
	    											 	 intentMyRoutesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    											 	 .getDecorView();
	    
	    	// Replace the view of this ActivityGroup
	    	replaceView(MyRoutesView);
	    }
	}
	
    @Override  
    public void onBackPressed()
    {
        MyRoutesGroup.myRoutesGroup.back();        
        return;
    }
	
	public void back()
	{  
        if(historyMyRoutesGroup.size() > 0)
        {
        	historyMyRoutesGroup.remove(historyMyRoutesGroup.size()-1);
            
            if(historyMyRoutesGroup.size() > 0)
            	setContentView(historyMyRoutesGroup.get(historyMyRoutesGroup.size()-1));
            else
            	MyRoutesGroup.myRoutesGroup.onResume();
        }
        else finish();
    }
	
	public void replaceView(View v)
	{  
        // Adds the old one to history  
		MyRoutesGroup.myRoutesGroup.historyMyRoutesGroup.add(v);
		
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
}
