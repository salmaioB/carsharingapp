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
	// Components define into identification screen
	private TextView identificationFailedTextView;
	
	private EditText loginEditText;
	private EditText passwordEditText;
	private Button validateConnectionButton;	
	
    private Runnable identificationProcess;
    private ProgressDialog identificationProgressDialog;
	
    // Components define into myprofile screen
    private TextView myProfileInfoTextView;
    
    private TextView userInfosTextView;
    private TextView userPreferenceTextView;
    private TextView userVehiclesTextView;
    private TextView userMyAlertsTextView;
    private TextView userPasswordTextView;
    private TextView userOpinionTextView;
    
    // Components define into user general infos screen
    private CustomerAccount customerAccount;
    
    private EditText userLastNameEditText;
    private EditText userFirstNameEditText;
    private EditText userEmailAddressEditText;
    private EditText userMobileEditText;
    private Button validateUserGeneralInfosButton;
    
    private Runnable loadUserGeneralInfosProcess;
    private ProgressDialog loadUserGeneralInfosProgressDialog;
    
    private Runnable saveUserGeneralInfosProcess;
    private ProgressDialog saveUserGeneralInfosProgressDialog;
    
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{		
	    super.onCreate(savedInstanceState);
	    
	    displayMyProfileScreen();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		
		displayMyProfileScreen();
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
			
			Thread thread =  new Thread(null, identificationProcess, "IdentificationThread");
		    thread.start();
		    identificationProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Identification ...", true);
		}
		else if(v == userInfosTextView)
		{
			loadUserGeneralInfosProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					loadCustomerGeneralInfosProcess();
				}
			};
			
			Thread loadUserGeneralInfosThread =  new Thread(null, loadUserGeneralInfosProcess, "LoadUserGeneralInfosThread");
			loadUserGeneralInfosThread.start();
			
			loadUserGeneralInfosProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Récupération de vos informations ...", true);
		}
		else if(v == validateUserGeneralInfosButton)
		{
			saveUserGeneralInfosProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					saveCustomerGeneralInfosProcess();
				}
			};
			
			Thread saveUserGeneralInfosThread =  new Thread(null, saveUserGeneralInfosProcess, "SaveUserGeneralInfosThread");
			saveUserGeneralInfosThread.start();
			
			saveUserGeneralInfosProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Sauvegarde de vos informations ...", true);
		}
	}
	
	public void displayMyProfileScreen()
	{
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {	
	    	setContentView(R.layout.myprofile);
	    	
	        myProfileInfoTextView  = (TextView)findViewById(R.id.my_profile_info_textview);
	        
	        userInfosTextView      = (TextView)findViewById(R.id.user_infos_textview);
	        userInfosTextView.setOnClickListener(this);
	        
	        userPreferenceTextView = (TextView)findViewById(R.id.user_preferences_textview);
	        userPreferenceTextView.setOnClickListener(this);
	        
	        userVehiclesTextView   = (TextView)findViewById(R.id.user_vehicles_textview);
	        userVehiclesTextView.setOnClickListener(this);
	        
	        userMyAlertsTextView   = (TextView)findViewById(R.id.user_my_alerts_textview);
	        userMyAlertsTextView.setOnClickListener(this);
	        
	        userPasswordTextView   = (TextView)findViewById(R.id.user_password_textview);
	        userPasswordTextView.setOnClickListener(this);
	        
	        userOpinionTextView    = (TextView)findViewById(R.id.user_opinion_textview);
	        userOpinionTextView.setOnClickListener(this);
    	}
	    else
	    {
    		setContentView(R.layout.identification);
    		
    	    identificationFailedTextView = (TextView)findViewById(R.id.identification_failed);
    	    
    	    loginEditText    = (EditText)findViewById(R.id.login_edittext);
    	    passwordEditText = (EditText)findViewById(R.id.password_edittext);
    		
    		validateConnectionButton = (Button)findViewById(R.id.validate_connection_button);
    	    validateConnectionButton.setOnClickListener(this);
	    }
	}
	
	public void displayUserGeneralInfosScreen()
	{
		setContentView(R.layout.usergeneralinfos);
		
        userLastNameEditText           = (EditText)findViewById(R.id.user_last_name_edittext);
        userLastNameEditText.setText(customerAccount.getLastName());
    
        userFirstNameEditText          = (EditText)findViewById(R.id.user_first_name_edittext);
        userFirstNameEditText.setText(customerAccount.getFirstName());
    
        userEmailAddressEditText   		   = (EditText)findViewById(R.id.user_email_edittext);
        userEmailAddressEditText.setText(customerAccount.getEmailAddress());

        userMobileEditText  		   = (EditText)findViewById(R.id.user_mobile_edittext);
        userMobileEditText.setText(customerAccount.getMobile());
    
        // TO DELETE ?
        //userYearOfBirthEditText        = (EditText)findViewById(R.id.user_year_of_birth_edittext);
        //userYearOfBirthEditText.setText(customerAccount.get);
    
        validateUserGeneralInfosButton = (Button)findViewById(R.id.validate_user_general_infos_button);
        validateUserGeneralInfosButton.setOnClickListener(this);
	}
	
	public void identificationProcess()
	{
		CustomerAccount identificationCA = new CustomerAccount();
		
		String userLogin 	= loginEditText.getText().toString();
		String userPassword = passwordEditText.getText().toString();
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		identificationCA = customerAccountWS.getCustomerAccount(userLogin, userPassword);
		
		if(identificationCA != null)
		{
			Log.v("Customer id", identificationCA.getId().toString());
			
			IdentificationController.saveUserIsLogged(getBaseContext(), identificationCA.getId());
		}
		
		identificationProcessUpdateUI(identificationCA);
	}
	
	public void identificationProcessUpdateUI(final CustomerAccount identificationCA)
	{
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
           	   // Code execute by UI main thread
        	   if(identificationCA != null)
        	   {
        		   // To retrieve the tabHost and to set the new current tab
        		   TabHost tabHost = ((TabActivity)getParent()).getTabHost();
        		   tabHost.setCurrentTab(0);
        	   }
        	   else
        		   identificationFailedTextView.setText("Votre identifiant ou votre mot de passe est invalide");
        	   
    		   identificationProgressDialog.dismiss();
           }
        });
	}
	
	public void loadCustomerGeneralInfosProcess()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccount = customerAccountWS.getCustomerAccount(idCustomerAccount);
		
		loadCustomerGeneralInfosProcessUpdateUI();
	}
	
	public void loadCustomerGeneralInfosProcessUpdateUI()
	{
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
        	   // Code execute by UI main thread
        	   if(customerAccount != null)
        	   {
        		   displayUserGeneralInfosScreen();
        	   }
        	   
        	   loadUserGeneralInfosProgressDialog.dismiss();
           }
    	});
	}
	
	public void saveCustomerGeneralInfosProcess()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		String lastName     	  = userLastNameEditText.getText().toString();
		String firstName    	  = userFirstNameEditText.getText().toString();
		String emailAddress 	  = userEmailAddressEditText.getText().toString();
		String mobile       	  = userMobileEditText.getText().toString();
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccountWS.saveCustomerGeneralInfos(idCustomerAccount, lastName, firstName, emailAddress, mobile);
	}
	
	public void saveCustomerGeneralInfosProcessUpdateUI()
	{
		
	}
}
