package cs.appandroid.activities;

import android.app.Activity;
import android.os.Bundle;

public class MyProfile extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    Bundle params;
	    
	    if(getIntent().getExtras() != null)
	    {
	    	params = new Bundle(getIntent().getExtras());
	    
		    if(params.containsKey("identification"))
		    {
		    	if(params.getBoolean("identification"))
		    		setContentView(R.layout.identification);
		    	else
		    		setContentView(R.layout.myprofile);
		    }
		    else setContentView(R.layout.myprofile);
	    }
	}
}
