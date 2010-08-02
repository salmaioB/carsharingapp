package cs.appandroid.activities;

import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;

public class Identification extends Activity implements OnClickListener
{
	private Button connectionButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.identification);
	    
	    connectionButton = (Button)findViewById(R.id.connection_button);
	    connectionButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		if(v == connectionButton)
		{
			//bool test = IsLoggedIn();
			
			CustomerAccount customerAccount = new CustomerAccount();
			
			CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
			customerAccount = customerAccountWS.getCustomerAccount("tat", "test");
			
			if(customerAccount != null)
			{
				// Create a new file to set the id customer
				
				Log.v("test", "ca marche !!");
				Log.v("last_name", customerAccount.getLastName());
				Log.v("first_name", customerAccount.getFirstName());
				
				Intent intent = new Intent().setClass(this, MyProfile.class);
				//intent.putExtra(name, value);
				startActivity(intent);
			}
			else
			{
				Log.v("test", "ca marche !!");
				LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    
				Log.v("test", "ca marche !!");
				PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.identification, null, false), 100, 100, true);
			    
				Log.v("test", "ca marche !!");
			    // The code below assumes that the root container has an id called 'main'
			    pw.showAtLocation(this.findViewById(R.id.toto), Gravity.CENTER, 0, 0); 
			}
		}
	}
}
