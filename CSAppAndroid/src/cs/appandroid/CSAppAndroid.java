package cs.appandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;


public class CSAppAndroid extends Activity
{	
	private static final String TAG = "MainActivity";
	private static final String URL = "http://10.0.2.2:8888/CSAppWeb/CustomerAccountsWS";
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new HomeMenuAdapter(this));
        
		Log.v(TAG, "Test logger");
	}
}