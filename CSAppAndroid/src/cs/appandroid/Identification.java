package cs.appandroid;

import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
			customerAccount = customerAccountWS.getCustomerAccount("tata", "test");
			
			if(!customerAccount.equals(null))
			{
				Log.v("test", "ca marche !!");
				Log.v("last_name", customerAccount.getLastName());
				Log.v("first_name", customerAccount.getFirstName());
			}
		}
	}
}
