package cs.appandroid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class MyMessages extends Activity
{	
	private static final String TAG = "MyMessages";
	 
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        
	    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
	    setContentView(R.layout.mymessages);
	}
}