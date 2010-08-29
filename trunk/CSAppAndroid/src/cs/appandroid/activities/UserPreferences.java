package cs.appandroid.activities;

import cs.appandroid.activitiesgroup.MyProfileGroup;
import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;


public class UserPreferences extends Activity implements OnClickListener
{
	private CustomerAccount customerAccount;
	
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
    
    private Runnable saveUserPreferencesProcess;
    private ProgressDialog saveUserPreferencesProgressDialog;
	
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    displayUserPreferences();
	}
	
	@Override
	public void onResume()
	{
	    super.onResume();
	    
	    displayUserPreferences();
	}
	
	@Override
	public void onClick(View v)
	{
		if(v == validateUserPreferencesButton)
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
			
			saveUserPreferencesProgressDialog = ProgressDialog.show(MyProfileGroup.myProfileGroup, "Please wait...", "Sauvegarde de vos informations ...", true);
		}
	}
	
	public void displayUserPreferences()
	{
		Bundle params = getIntent().getExtras();
		
		if(params.containsKey("customerAccount"))
			customerAccount = (CustomerAccount)params.getSerializable("customerAccount");
		
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
}
