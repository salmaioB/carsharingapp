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
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;


public class MyProfile extends Activity implements OnClickListener
{
    private CustomerAccount customerAccount;
	
	// Components define into identification screen
	private TextView identificationFailedTextView;
	
	private EditText loginEditText;
	private EditText passwordEditText;
	private Button validateConnectionButton;
	
    private Runnable identificationProcess;
    private ProgressDialog identificationProgressDialog;
	
    // Components define into myprofile screen    
    private TextView userInfosTextView;
    private TextView userPreferenceTextView;
    private TextView userVehiclesTextView;
    //private TextView userMyAlertsTextView;
    private TextView userPasswordTextView;
    private TextView userOpinionTextView;
    
    // Components define into user general infos screen
    private TextView alertUserSaveGeneralInfosTextView;
    private EditText userLastNameEditText;
    private EditText userFirstNameEditText;
    private EditText userEmailAddressEditText;
    private EditText userMobileEditText;
    private Button validateUserGeneralInfosButton;
    
    private Runnable loadUserGeneralInfosProcess;
    private ProgressDialog loadUserGeneralInfosProgressDialog;
    
    private Runnable saveUserGeneralInfosProcess;
    private ProgressDialog saveUserGeneralInfosProgressDialog;
    
    
    // Components define into user preferences screen
    private RadioButton acceptAnimalsYesRadioButton;
    private RadioButton acceptAnimalsNoRadioButton;
    private RadioButton acceptAnimalsIndifferentRadioButton;
    private RadioButton acceptRadioYesRadioButton;
    private RadioButton acceptRadioNoRadioButton;
    private RadioButton acceptRadioIndifferentRadioButton;
    private RadioButton acceptSmokerYesRadioButton;
    private RadioButton acceptSmokerNoRadioButton;
    private RadioButton acceptSmokerIndifferentRadioButton;
    private RadioButton acceptDiscussYesRadioButton;
    private RadioButton acceptDiscussNoRadioButton;
    private RadioButton acceptDiscussIndifferentRadioButton;
    private RadioButton acceptDetourYesRadioButton;
    private RadioButton acceptDetourNoRadioButton;
    private RadioButton acceptDetourIndifferentRadioButton;
    private Button validateUserPreferencesButton;
    
    private Runnable loadUserPreferencesProcess;
    private ProgressDialog loadUserPreferencesProgressDialog;
    
    private Runnable saveUserPreferencesProcess;
    private ProgressDialog saveUserPreferencesProgressDialog;
    
    
    // Components define into user password screen
    private TextView alertUserSavePasswordTextView;
    private EditText currentPasswordEditText;
    private EditText newPasswordEditText;
    private EditText newPasswordConfirmationEditText;
    private Button validateUserPasswordButton;
    
    private Runnable saveUserPasswordProcess;
    private ProgressDialog saveUserPasswordProgressDialog;
    
	
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
		else if(v == userPreferenceTextView)
		{
			loadUserPreferencesProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					loadCustomerPreferencesProcess();
				}
			};
			
			Thread loadUserPreferencesThread = new Thread(null, loadUserPreferencesProcess, "LoadUserPreferencesThread");
			loadUserPreferencesThread.start();
			
			loadUserPreferencesProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Récupération de vos préférences ...", true);
		}
		else if(v == validateUserPreferencesButton)
		{
			saveUserPreferencesProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					saveCustomerPreferencesProcess();
				}
			};
			
			Thread saveUserPreferencesThread =  new Thread(null, saveUserPreferencesProcess, "SaveUserPreferencesThread");
			saveUserPreferencesThread.start();
			
			saveUserPreferencesProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Sauvegarde de vos informations ...", true);
		}
		else if(v == userPasswordTextView)
		{
			displayUserPasswordScreen();
		}
		else if(v == validateUserPasswordButton)
		{
			saveUserPasswordProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					saveCustomerNewPasswordProcess();
				}
			};
			
			Thread saveUserNewPasswordThread =  new Thread(null, saveUserPasswordProcess, "SaveUserNewPasswordThread");
			saveUserNewPasswordThread.start();
			
			saveUserPasswordProgressDialog = ProgressDialog.show(MyProfile.this, "Please wait...", "Sauvegarde de vos informations ...", true);
		}
	}
	
	public void displayMyProfileScreen()
	{
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {	
//	    	final boolean customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	    	
	    	setContentView(R.layout.myprofile);
	    	
//	    	if(customTitleSupported)
//	    	{
//	    		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
//	        }
	        
	        userInfosTextView      = (TextView)findViewById(R.id.user_infos_textview);
	        userInfosTextView.setOnClickListener(this);
	        
	        userPreferenceTextView = (TextView)findViewById(R.id.user_preferences_textview);
	        userPreferenceTextView.setOnClickListener(this);
	        
	        userVehiclesTextView   = (TextView)findViewById(R.id.user_vehicles_textview);
	        userVehiclesTextView.setOnClickListener(this);
	        
//	        userMyAlertsTextView   = (TextView)findViewById(R.id.user_my_alerts_textview);
//	        userMyAlertsTextView.setOnClickListener(this);
	        
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
		
		alertUserSaveGeneralInfosTextView = (TextView)findViewById(R.id.alert_user_save_general_infos_textview);
		
        userLastNameEditText              = (EditText)findViewById(R.id.user_last_name_edittext);
        userLastNameEditText.setText(customerAccount.getLastName());
    
        userFirstNameEditText             = (EditText)findViewById(R.id.user_first_name_edittext);
        userFirstNameEditText.setText(customerAccount.getFirstName());
    
        userEmailAddressEditText   		  = (EditText)findViewById(R.id.user_email_edittext);
        userEmailAddressEditText.setText(customerAccount.getEmailAddress());

        userMobileEditText  		      = (EditText)findViewById(R.id.user_mobile_edittext);
        userMobileEditText.setText(customerAccount.getMobile());
        
        validateUserGeneralInfosButton    = (Button)findViewById(R.id.validate_user_general_infos_button);
        validateUserGeneralInfosButton.setOnClickListener(this);
	}
	
	public void displayUserPreferencesScreen()
	{
		setContentView(R.layout.userpreferences);
		
		// Accept animals
		acceptAnimalsYesRadioButton         = (RadioButton)findViewById(R.id.accept_animals_yes_radiobutton);		
		acceptAnimalsNoRadioButton          = (RadioButton)findViewById(R.id.accept_animals_no_radiobutton);
	    acceptAnimalsIndifferentRadioButton = (RadioButton)findViewById(R.id.accept_animals_indifferent_radiobutton);
	    
		switch(customerAccount.getAcceptAnimals())
		{
			case 0: acceptAnimalsNoRadioButton.setChecked(true);
					break; 
			case 1: acceptAnimalsYesRadioButton.setChecked(true);
				    break;
			case 2: acceptAnimalsIndifferentRadioButton.setChecked(true);
					break;
		}
	    
	    // Accept radio
	    acceptRadioYesRadioButton         = (RadioButton)findViewById(R.id.accept_radio_yes_radiobutton);
	    acceptRadioNoRadioButton          = (RadioButton)findViewById(R.id.accept_radio_no_radiobutton);
	    acceptRadioIndifferentRadioButton = (RadioButton)findViewById(R.id.accept_radio_indifferent_radiobutton);
	    
		switch(customerAccount.getAcceptRadio())
		{
			case 0: acceptRadioNoRadioButton.setChecked(true);
					break; 
			case 1: acceptRadioYesRadioButton.setChecked(true);
				    break;
			case 2: acceptRadioIndifferentRadioButton.setChecked(true);
					break;
		}
	    
	    // Accept smoker
	    acceptSmokerYesRadioButton   	   = (RadioButton)findViewById(R.id.accept_smoker_yes_radiobutton);
	    acceptSmokerNoRadioButton		   = (RadioButton)findViewById(R.id.accept_smoker_no_radiobutton);
	    acceptSmokerIndifferentRadioButton = (RadioButton)findViewById(R.id.accept_smoker_indifferent_radiobutton);
	    
		switch(customerAccount.getAcceptSmoker())
		{
			case 0: acceptSmokerNoRadioButton.setChecked(true);
					break; 
			case 1: acceptSmokerYesRadioButton.setChecked(true);
				    break;
			case 2: acceptSmokerIndifferentRadioButton.setChecked(true);
					break;
		}
	    
	    // Accept discuss
	    acceptDiscussYesRadioButton		 	= (RadioButton)findViewById(R.id.accept_discuss_yes_radiobutton);
	    acceptDiscussNoRadioButton      	= (RadioButton)findViewById(R.id.accept_discuss_no_radiobutton);
	    acceptDiscussIndifferentRadioButton = (RadioButton)findViewById(R.id.accept_discuss_indifferent_radiobutton);
	    
		switch(customerAccount.getAcceptToDiscuss())
		{
			case 0: acceptDiscussNoRadioButton.setChecked(true);
					break; 
			case 1: acceptDiscussYesRadioButton.setChecked(true);
				    break;
			case 2: acceptDiscussIndifferentRadioButton.setChecked(true);
					break;
		}
	    
	    // Accept detour
	    acceptDetourYesRadioButton 		   = (RadioButton)findViewById(R.id.accept_detour_yes_radiobutton);
	    acceptDetourNoRadioButton		   = (RadioButton)findViewById(R.id.accept_detour_no_radiobutton);
	    acceptDetourIndifferentRadioButton = (RadioButton)findViewById(R.id.accept_detour_indifferent_radiobutton);
	    
		switch(customerAccount.getAcceptToMakeADetour())
		{
			case 0: acceptDetourNoRadioButton.setChecked(true);
					break; 
			case 1: acceptDetourYesRadioButton.setChecked(true);
				    break;
			case 2: acceptDetourIndifferentRadioButton.setChecked(true);
					break;
		}
		
		validateUserPreferencesButton    = (Button)findViewById(R.id.validate_user_preferences_button);
		validateUserPreferencesButton.setOnClickListener(this);
	}
	
	public void displayUserPasswordScreen()
	{
		setContentView(R.layout.userpassword);
		
		alertUserSavePasswordTextView   = (TextView)findViewById(R.id.alert_user_save_password_textview);
		currentPasswordEditText         = (EditText)findViewById(R.id.current_password_edittext);
	    newPasswordEditText             = (EditText)findViewById(R.id.new_password_edittext);
	    newPasswordConfirmationEditText = (EditText)findViewById(R.id.new_password_confirmation_edittext);
	    
	    validateUserPasswordButton      = (Button)findViewById(R.id.validate_user_password_button);
	    validateUserPasswordButton.setOnClickListener(this);
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
	
	public void callCustomerAccountWS()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccount = customerAccountWS.getCustomerAccount(idCustomerAccount);
	}
	
	public void loadCustomerGeneralInfosProcess()
	{
		callCustomerAccountWS();
		
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
	
		saveCustomerGeneralInfosProcessUpdateUI();
	}
	
	public void saveCustomerGeneralInfosProcessUpdateUI()
	{
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
        	   alertUserSaveGeneralInfosTextView.setVisibility(View.VISIBLE);
        	   
        	   saveUserGeneralInfosProgressDialog.dismiss();
           }
    	});
	}
	
	public void loadCustomerPreferencesProcess()
	{
		callCustomerAccountWS();
		
		loadCustomerPreferencesProcessUpdateUI();
	}
	
	public void loadCustomerPreferencesProcessUpdateUI()
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
        		   displayUserPreferencesScreen();
        	   }
        	   
        	   loadUserPreferencesProgressDialog.dismiss();
           }
    	});
	}
	
	public void saveCustomerPreferencesProcess()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());

		Integer acceptAnimals       = 0;
		Integer acceptRadio         = 0;
		Integer acceptSmoker        = 0;
		Integer acceptToDiscuss     = 0;
		Integer acceptToMakeADetour = 0;
		
		if(acceptAnimalsYesRadioButton.isChecked())
			acceptAnimals = 1;
		else if(acceptAnimalsIndifferentRadioButton.isChecked())
			acceptAnimals = 2;
		
		if(acceptRadioYesRadioButton.isChecked())
			acceptRadio = 1;
		else if(acceptRadioIndifferentRadioButton.isChecked())
			acceptRadio = 2;
		
		if(acceptSmokerYesRadioButton.isChecked())
			acceptSmoker = 1;
		else if(acceptSmokerIndifferentRadioButton.isChecked())
			acceptSmoker = 2;
		
		if(acceptDiscussYesRadioButton.isChecked())
			acceptToDiscuss = 1;
		else if(acceptDiscussIndifferentRadioButton.isChecked())
			acceptToDiscuss = 2;
		
		if(acceptDetourYesRadioButton.isChecked())
			acceptToMakeADetour = 1;
		else if(acceptDetourIndifferentRadioButton.isChecked())
			acceptToMakeADetour = 2;
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccountWS.saveCustomerPreferences(idCustomerAccount, acceptAnimals, acceptRadio, acceptSmoker, acceptToDiscuss, acceptToMakeADetour);
		
		saveCustomerPreferencesProcessUpdateUI();
	}
	
	public void saveCustomerPreferencesProcessUpdateUI()
	{
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
        	   // alert message
        	   
        	   saveUserPreferencesProgressDialog.dismiss();
           }
    	});
	}
	
	public void saveCustomerNewPasswordProcess()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		String currentPassword    = currentPasswordEditText.getText().toString();
		String newPassword        = newPasswordEditText.getText().toString();
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		Integer saveCustomerNewPasswordStatus = customerAccountWS.saveCustomerNewPassword(idCustomerAccount, currentPassword, newPassword);
	    
		Log.v("test", saveCustomerNewPasswordStatus.toString());
	    		
		saveCustomerNewPasswordProcessUpdateUI(saveCustomerNewPasswordStatus);
	}
	
	public void saveCustomerNewPasswordProcessUpdateUI(final Integer saveCustomerNewPasswordStatus)
	{
	    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
	    
 	    //final Button conn = (Button)findViewById(R.id.connection_button);
 	    
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
	       	   switch(saveCustomerNewPasswordStatus)
	    	   {
	       	   		case 0: Log.v("Error: ", "saveCustomerNewPassword json");
	       	   		        break;
	       	   		case 1: //conn.setText("aze");
	       	   			    alertUserSavePasswordTextView.setText("Votre mot de passe actuel est invalide.");
	       	   			    break;
	       	   		case 2: //conn.setText("aze");
	       	   			    alertUserSavePasswordTextView.setText("Votre mot de passe a bien été mis à jour.");
	       	   			    break;
	    	   }
        	   
        	   saveUserPasswordProgressDialog.dismiss();
           }
    	});
	}
}
