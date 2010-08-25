package cs.appandroid.activities;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MyRoutesGroup extends ActivityGroup
{
	public static MyRoutesGroup myRoutesGroup;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    myRoutesGroup = this;
	    
	    Intent intentMyRoutesView = new Intent(this, MyRoutes.class);
	    
	    // Start the root activity within the group and get its view
	    View MyRoutesView = getLocalActivityManager().startActivity("My routes view",
	    											 intentMyRoutesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    											 .getDecorView();
	    
	    // Replace the view of this ActivityGroup
	    replaceView(MyRoutesView);
	}
	
	public void replaceView(View v)
	{  
        // Adds the old one to history  
		//history.add(v);
		
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
}
