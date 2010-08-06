package cs.appandroid.activities;

import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class MyProfile extends Activity implements OnClickListener
{
	private TextView identificationFailedTextView;
	
	private EditText loginEditText;
	private EditText passwordEditText;
	private Button validateConnectionButton;	
	
    private Runnable identificationProcess;
    private ProgressDialog identificationProgressDialog;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{		
	    super.onCreate(savedInstanceState);
	    
	    displayMyProfile();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
		displayMyProfile();
	}

	@Override
	public void onClick(View v)
	{
		if(v == validateConnectionButton)
		{
			identificationProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					identificationProcess();
				}
			};
			
			Thread thread =  new Thread(null, identificationProcess, "SearchOrderThread");
		    thread.start();
		    identificationProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Identification ...", true);
		}
	}
	
	public void displayMyProfile()
	{
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {
	    	Log.v("My profile", "passe");
	    	
	    	setContentView(R.layout.myprofile);
    	}
	    else
	    {
	    	Log.v("identification", "passe");
    		
    		setContentView(R.layout.identification);
    		
    	    identificationFailedTextView = (TextView)findViewById(R.id.identification_failed);
    	    
    	    loginEditText    = (EditText)findViewById(R.id.login_edittext);
    	    passwordEditText = (EditText)findViewById(R.id.password_edittext);
    		
    		validateConnectionButton = (Button)findViewById(R.id.validate_connection_button);
    	    validateConnectionButton.setOnClickListener(this);
	    }
	}
	
	public void identificationProcess()
	{
		CustomerAccount customerAccount = new CustomerAccount();
		
		String userLogin 	= loginEditText.getText().toString();
		String userPassword = passwordEditText.getText().toString();
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccount = customerAccountWS.getCustomerAccount(userLogin, userPassword);
		
		if(customerAccount != null)
		{
			Log.v("Customer id", customerAccount.getId().toString());
			
			IdentificationController.saveUserIsLogged(getBaseContext(), customerAccount.getId());
			
            // To retrieve the tabHost and to set the new current tab
			TabHost tabHost = ((TabActivity)getParent()).getTabHost();
			tabHost.setCurrentTab(0);
		}
		else
		{
			identificationFailedTextView.setText("Votre identifiant ou votre mot de passe est invalide");
			
		}
	}
}
