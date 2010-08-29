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
import android.widget.EditText;
import android.widget.TextView;


public class UserGeneralInfos extends Activity implements OnClickListener
{
	private CustomerAccount customerAccount;
	
    private TextView alertUserSaveGeneralInfosTextView;
    private EditText userLastNameEditText;
    private EditText userFirstNameEditText;
    private EditText userEmailAddressEditText;
    private EditText userMobileEditText;
    private Button validateUserGeneralInfosButton;
    
    private Runnable saveUserGeneralInfosProcess;
    private ProgressDialog saveUserGeneralInfosProgressDialog;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    displayUserGeneralInfos();
	}
	
	public void onResume()
	{
		super.onResume();
		
	    displayUserGeneralInfos();
	}
		
	@Override
	public void onClick(View v)
	{
		if(v == validateUserGeneralInfosButton)
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
			
			saveUserGeneralInfosProgressDialog = ProgressDialog.show(MyProfileGroup.myProfileGroup, "Please wait...", "Sauvegarde de vos informations ...", true);
		}
	}
	
	public void displayUserGeneralInfos()
	{
		Bundle params = getIntent().getExtras();
		
		if(params.containsKey("customerAccount"))
			customerAccount = (CustomerAccount)params.getSerializable("customerAccount");
		
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
}
