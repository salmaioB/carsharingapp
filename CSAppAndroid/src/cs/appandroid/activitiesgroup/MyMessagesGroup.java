package cs.appandroid.activitiesgroup;

import cs.appandroid.activities.MyMessages;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MyMessagesGroup extends ActivityGroup
{
	public static MyMessagesGroup myMessagesGroup;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    myMessagesGroup = this;
	    
	    Intent intentMyMessagesView = new Intent(this, MyMessages.class);
	    
	    // Start the root activity within the group and get its view
	    View MyMessagesView = getLocalActivityManager().startActivity("My messages view",
	    											   intentMyMessagesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    											   .getDecorView();
	    
	    // Replace the view of this ActivityGroup
	    replaceView(MyMessagesView);
	}
	
	public void replaceView(View v)
	{  
        // Adds the old one to history  
		//history.add(v);
		
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
}
