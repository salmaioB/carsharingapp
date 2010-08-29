package cs.appandroid.activitiesgroup;

import java.util.ArrayList;

import cs.appandroid.activities.R;
import cs.appandroid.activities.UserGeneralInfos;
import cs.appandroid.activities.UserPassword;
import cs.appandroid.activities.UserPreferences;
import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;
import android.app.ActivityGroup;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;


public class MyProfileGroup extends ActivityGroup implements OnClickListener
{
	// Components define into identification screen
	private TextView identificationFailedTextView;
	
	private EditText loginEditText;
	private EditText passwordEditText;
	private Button validateConnectionButton;
	
    private Runnable identificationProcess;
    private ProgressDialog identificationProgressDialog;
	
    
    // Components define into "my profile" screen    
    private TextView userInfosTextView;
    private TextView userPreferenceTextView;
    //private TextView userVehiclesTextView;
    //private TextView userMyAlertsTextView;
    private TextView userPasswordTextView;
    //private TextView userOpinionTextView;
     
    private CustomerAccount customerAccount;
    
    // Intents to call
    private Intent intentUserGeneralInfosView;
    private Intent intentUserPreferencesView;
    private Intent intentUserPasswordView;
    
    private Runnable loadUserGeneralInfosProcess;
    private ProgressDialog loadUserGeneralInfosProgressDialog;
    
    private Runnable loadUserPreferencesProcess;
    private ProgressDialog loadUserPreferencesProgressDialog;
    
    
    public static MyProfileGroup myProfileGroup;
    public ArrayList<View> historyMyProfileGroup;
    
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    myProfileGroup        = this;
	    historyMyProfileGroup = new ArrayList<View>();
	    
	    intentUserGeneralInfosView = new Intent(this, UserGeneralInfos.class);
	    intentUserPreferencesView  = new Intent(this, UserPreferences.class);
	    intentUserPasswordView     = new Intent(this, UserPassword.class);
	    
	    displayMyProfile();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
				
		displayMyProfile();
	}
	
	public void displayMyProfile()
	{
	    if(IdentificationController.userIsLogged(getBaseContext()))
	    {
	    	setContentView(R.layout.myprofile);
	        
	        userInfosTextView      = (TextView)findViewById(R.id.user_infos_textview);
	        userInfosTextView.setOnClickListener(this);
	        
	        userPreferenceTextView = (TextView)findViewById(R.id.user_preferences_textview);
	        userPreferenceTextView.setOnClickListener(this);
	        
//	        userVehiclesTextView   = (TextView)findViewById(R.id.user_vehicles_textview);
//	        userVehiclesTextView.setOnClickListener(this);
	        
//	        userMyAlertsTextView   = (TextView)findViewById(R.id.user_my_alerts_textview);
//	        userMyAlertsTextView.setOnClickListener(this);
	        
	        userPasswordTextView   = (TextView)findViewById(R.id.user_password_textview);
	        userPasswordTextView.setOnClickListener(this);
	        
//	        userOpinionTextView    = (TextView)findViewById(R.id.user_opinion_textview);
//	        userOpinionTextView.setOnClickListener(this);
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
		    identificationProgressDialog = ProgressDialog.show(MyProfileGroup.this, "Please wait...", "Identification ...", true);
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
			
			loadUserGeneralInfosProgressDialog = ProgressDialog.show(MyProfileGroup.this, "Please wait...", "Récupération de vos informations ...", true);
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
			
			loadUserPreferencesProgressDialog = ProgressDialog.show(MyProfileGroup.this, "Please wait...", "Récupération de vos préférences ...", true);
		}
		else if(v == userPasswordTextView)
	    {
			intentUserPasswordView.putExtra("customerAccount", customerAccount);
 		   
	    	// Start the root activity within the group and get its view
	    	View UserPasswordView = getLocalActivityManager().startActivity("User password view",
	    													 intentUserPasswordView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    			   										 .getDecorView();
	    
	    	// Replace the view of this ActivityGroup
	    	replaceView(UserPasswordView);
	    }
	}
	
    @Override  
    public void onBackPressed()
    {
        MyProfileGroup.myProfileGroup.back();        
        return;  
    }
	
	public void back()
	{  
        if(historyMyProfileGroup.size() > 0)
        {
        	historyMyProfileGroup.remove(historyMyProfileGroup.size()-1);
            
            if(historyMyProfileGroup.size() > 0)
            	setContentView(historyMyProfileGroup.get(historyMyProfileGroup.size()-1));
            else
            	MyProfileGroup.myProfileGroup.onResume();
        }
        else finish();
    }
	
	public void replaceView(View v)
	{
        // Adds the old one to history  
		historyMyProfileGroup.add(v);
		
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
	
	public void identificationProcess()
	{
		CustomerAccount identificationCA = new CustomerAccount();
		
		String userLogin 	= loginEditText.getText().toString();
		String userPassword = passwordEditText.getText().toString();
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		identificationCA = customerAccountWS.getCustomerAccount(userLogin, userPassword);
		
		if(identificationCA != null)
			IdentificationController.saveUserIsLogged(getBaseContext(), identificationCA.getId());
		
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
        		   intentUserGeneralInfosView.putExtra("customerAccount", customerAccount);
        		   
       	    	   // Start the root activity within the group and get its view
       	    	   View UserGeneralInfosView = getLocalActivityManager().startActivity("User general infos",
       	    			   												intentUserGeneralInfosView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
       	    			   												.getDecorView();
       	    
       	    	   // Replace the view of this ActivityGroup
       	    	   replaceView(UserGeneralInfosView);
        	   }
        	   
        	   loadUserGeneralInfosProgressDialog.dismiss();
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
        		   intentUserPreferencesView.putExtra("customerAccount", customerAccount);
        		   
       	    	   // Start the root activity within the group and get its view
       	    	   View UserPreferencesView = getLocalActivityManager().startActivity("User preferences view",
       	    			   												intentUserPreferencesView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
       	    			   												.getDecorView();
       	    
       	    	   // Replace the view of this ActivityGroup
       	    	   replaceView(UserPreferencesView);
        	   }
        	   
        	   loadUserPreferencesProgressDialog.dismiss();
           }
    	});
	}
	
	public void callCustomerAccountWS()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		customerAccount = customerAccountWS.getCustomerAccount(idCustomerAccount);
	}
}
