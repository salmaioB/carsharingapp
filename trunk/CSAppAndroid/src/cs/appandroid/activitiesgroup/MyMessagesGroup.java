package cs.appandroid.activitiesgroup;

import java.util.ArrayList;

import cs.appandroid.activities.MyMessages;
import cs.appandroid.controller.IdentificationController;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MyMessagesGroup extends ActivityGroup
{
	public static MyMessagesGroup myMessagesGroup;
	public ArrayList<View> historyMyMessagesGroup;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    myMessagesGroup = this;
	    historyMyMessagesGroup = new ArrayList<View>();
	    
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {
	    	Intent intentMyMessagesView = new Intent(this, MyMessages.class);
	    
	    	// Start the root activity within the group and get its view
	    	View MyMessagesView = getLocalActivityManager().startActivity("My messages view",
	    											   	   intentMyMessagesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    											   	   .getDecorView();
	    
	    	// Replace the view of this ActivityGroup
	    	replaceView(MyMessagesView);
	    }
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {
	    	Intent intentMyMessagesView = new Intent(this, MyMessages.class);
	    
	    	// Start the root activity within the group and get its view
	    	View MyMessagesView = getLocalActivityManager().startActivity("My messages view",
	    											   	   intentMyMessagesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    											   	   .getDecorView();
	    
	    	// Replace the view of this ActivityGroup
	    	replaceView(MyMessagesView);
	    }
	}
	
    @Override  
    public void onBackPressed()
    {
        MyMessagesGroup.myMessagesGroup.back();        
        return;  
    }
	
	public void back()
	{  
        if(historyMyMessagesGroup.size() > 0)
        {
        	historyMyMessagesGroup.remove(historyMyMessagesGroup.size()-1);
            
            if(historyMyMessagesGroup.size() > 0)
            	setContentView(historyMyMessagesGroup.get(historyMyMessagesGroup.size()-1));
            else
            	MyMessagesGroup.myMessagesGroup.onResume();
        }
        else finish();
    }
	
	public void replaceView(View v)
	{
        // Adds the old one to history  
		historyMyMessagesGroup.add(v);
		
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
}
