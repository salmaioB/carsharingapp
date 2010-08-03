package cs.appandroid.activities;

import cs.appandroid.controller.IdentificationUtilities;
import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class MyProfile extends Activity implements OnClickListener
{
	private Button validateConnectionButton;
	
    Bundle params;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{		
	    super.onCreate(savedInstanceState);
	    
	    displayMyProfile();
	}
	
	@Override
	public void onResume()
	{
		super.onStart();
		
		displayMyProfile();
	}

	@Override
	public void onClick(View v)
	{
		if(v == validateConnectionButton)
		{
			CustomerAccount customerAccount = new CustomerAccount();
			
			CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
			customerAccount = customerAccountWS.getCustomerAccount("tata", "test");
			
			if(!customerAccount.equals(null))
			{
				Log.v("Customer id", customerAccount.getId().toString());
				
				IdentificationUtilities.saveUserIsLogged(getBaseContext(), customerAccount.getId());
				
                // To retrieve the tabHost and to set the new current tab
				TabHost tabHost = ((TabActivity)getParent()).getTabHost();
				tabHost.setCurrentTab(0);
			}
		}
	}
	
	public void displayMyProfile()
	{
	    if(IdentificationUtilities.userIsLogged(getBaseContext()))
	    {
	    	Log.v("My profile", "passe");
	    	
	    	setContentView(R.layout.myprofile);
    	}
	    else
	    {
	    	Log.v("identification", "passe");
    		
    		setContentView(R.layout.identification);
    		
    		validateConnectionButton = (Button)findViewById(R.id.validate_connection_button);
    	    validateConnectionButton.setOnClickListener(this);
	    }
	}
}
