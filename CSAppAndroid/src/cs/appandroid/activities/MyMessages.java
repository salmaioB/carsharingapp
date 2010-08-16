package cs.appandroid.activities;

import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MyMessages extends Activity
{	
	private static final String TAG = "MyMessages";
	 
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Log.v(TAG, "Test logger");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymessages);
		
		
		TextView jsonTextView = (TextView) findViewById(R.id.TextView01);
		
		//Instanciation du WebService + récupère customer id = 1
		CustomerAccountsWS caws = new CustomerAccountsWS();
		//CustomerAccount ca = caws.getCustomerAccount(1);
		
		//jsonTextView.setText("login : "+ ca.getCustomerLogin());	
	}
}